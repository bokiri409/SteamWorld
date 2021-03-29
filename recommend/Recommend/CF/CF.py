# import
from scipy.sparse.linalg import svds
from CF import loadData
import json
import pandas as pd
import numpy as np
import requests
from bs4 import BeautifulSoup


class CollaborativeFiltering:

    def __init__(self, user_id):
        print('init')
        ReadData = loadData.ReadData()
        self.userData = ReadData.userData
        self.appList = ReadData.appList
        self.userId = user_id
        self.searchData = pd.DataFrame(columns=['appid', 'playtime_forever', 'playtime_2weeks', 'steamid'])
        self.searchUser = ""
        self.svd_preds = ""
        self.newSteamId = ""

    def getUserData(self):
        print('gud')
        self.userData = self.userData.drop(columns=['Unnamed: 0'])
        self.userData = self.userData.drop_duplicates(['appid', 'steamid'])
        url = 'https://api.steampowered.com/IPlayerService/GetOwnedGames/v1/?key=F1DAAB7BF3894FBDC83881C81C20803A&steamid=' + str(self.userId)
        response = requests.get(url)
        flag = 0
        if response.status_code == 200:
            flag = 1
            html = response.text
            soup = BeautifulSoup(html, 'html.parser')
            jsonData = pd.read_json(soup.text)
            if jsonData.empty:
                print("empty")
            elif jsonData['response']['game_count'] == 0:
                print("none data")
        else:
            print(response.status_code)

        if flag == 1:
            self.searchUser = pd.DataFrame(jsonData['response']['games'])
            self.searchUser = self.searchUser.drop(['playtime_windows_forever', 'playtime_mac_forever',
                                                    'playtime_linux_forever'], axis='columns')
            self.searchUser['steamid'] = self.userId
            self.newSteamId = self.searchUser['steamid']
            self.newSteamId = self.userData['steamid'].unique().size
            self.searchUser['newsteamid'] = self.newSteamId
        else:
            pass

        if 'playtime_2weeks' not in self.searchUser.columns:
            self.searchUser['playtime_2weeks'] = 0


    # weight 할당 def
    def refine(self):

        print('rf')
        # 가중치 부여
        self.searchUser['weight'] = 0
        self.searchUser['playtime_forever'] = self.searchUser['playtime_forever'] / 60
        self.searchUser['playtime_forever'] = np.log10(self.searchUser['playtime_forever'])
        def nonePlaying(playtime_forever, playtime_2weeks, weight):
            # 플레이시간 0
            if playtime_forever == float('-inf'):
                weight = 1
            # 플레이시간 1시간 이내
            elif playtime_forever < 0:
                weight = -1
            # 플레이시간 10시간 이내
            # elif 0 <= playtime_forever < 1:
            #   weight = 2
            # 플레이시간 1시간 이상
            else:
                weight = 2

            if playtime_2weeks >= 60:
                weight = weight + 1

            return weight

        self.searchUser['weight'] = self.searchUser.apply(lambda x: nonePlaying(x['playtime_forever'],
                                                            x['playtime_2weeks'], x['weight']), axis=1)
        # 데이터 병합
        self.userData = self.userData.append(self.searchUser)

        pivotUserApp = self.userData.pivot(
            index='newsteamid',
            columns='appid',
            values='weight'
        ).fillna(0)

        matrix = pivotUserApp.values
        weightMean = np.mean(matrix, axis=1)
        matrixUserMean = matrix - weightMean.reshape(-1, 1)
        U, sigma, Vt = svds(matrixUserMean, k=12)
        sigma = np.diag(sigma)
        svd_user_predicted_weight = np.dot(np.dot(U, sigma), Vt) + weightMean.reshape(-1, 1)
        self.svd_preds = pd.DataFrame(svd_user_predicted_weight, columns=pivotUserApp.columns)


    def recommend_games(self, num_recommendations=5):

        print('rg')
        user_row_number = self.newSteamId
        # 최종적으로 만든 pred_df에서 사용자 index에 따라 게임 데이터 정렬 -> 게임 weight가 높은 순으로 정렬 됌
        sorted_user_predictions = self.svd_preds.iloc[user_row_number].sort_values(ascending=False)

        # 원본 데이터에서 user_id 해당하는 데이터를 뽑아낸다.
        user_data = self.userData[self.userData.newsteamid == user_row_number]

        # 위에서 뽑은 user_data와 게임 데이터를 합친다.
        user_history = user_data.merge(self.appList, on='appid').sort_values(['weight'], ascending=False)

        # 원본 게임 데이터에서 사용자 목록에 있는 게임 데이터를 제외해 데이터를 추출
        recommendations = self.appList[~self.appList['appid'].isin(user_history['appid'])]
        # 사용자의 게임 weight가 높은 순으로 정렬된 데이터와 위 recommendations 을 합친다.
        recommendations = recommendations.merge(pd.DataFrame(sorted_user_predictions).reset_index(), on='appid')
        # 컬럼 이름 바꾸고 정렬해서 return
        recommendations = recommendations.rename(columns={user_row_number: 'Predictions'}).sort_values('Predictions',
                                                ascending=False).iloc[:num_recommendations, :]

        user_history = user_history.to_json(orient='records')
        user_history = json.loads(user_history)
        recommendations = recommendations.to_json(orient='records')
        recommendations = json.loads(recommendations)

        return json.dumps(user_history), json.dumps(recommendations)


