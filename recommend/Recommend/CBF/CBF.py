import pandas as pd
import csv
import json
from ast import literal_eval
from CBF import loadData

class ContentsBasedFiltering:

    def __init__(self, percent, gamenames={'Dungreed' : 3, 'Skul: The Hero Slayer': 2}):
        print('init')
        readData = loadData.ReadData()
        self.percent = percent
        self.gameNames = gamenames
        self.pointDic = {}
        self.pointList = []
        self.data = readData.gameData
        self.genreData = readData.genreData

    # 점수표 제작
    def makePoint(self):
        print('mp')
        for gameName in self.gameNames:
            for tag in self.genreData['genre']:
                if str(tag) not in self.pointDic:
                    self.pointDic[str(tag)] = 0
            for target in self.data[self.data['name'] == gameName]['genre']:
                point = 10
                for genre in target:
                    if genre == 'VR' or genre == 'Free to Play':
                        continue
                    self.pointDic[genre] += point * self.gameNames[gameName]
                    point -= 1

    #데이터 정제
    def refine(self):
        print('refine')
        # Weighted rating(WR) = (v / (v + m)) * R + (m / (v + m)) * C
        # R: 평점, V: 투표수, M: 최소 투표수, C: 평균 평점
        # 전체 평균 평점
        C = self.data['score'].mean()

        # 최소 투표수
        m = self.data['vote'].quantile(self.percent)
        self.data = self.data.loc[self.data['vote'] >= m]

        # 가중치 계산
        def weight_rating(data, m=m, c=C):
            v = data['vote']
            R = data['score']
            return (v / (v + m)) * R + (m / (v + m)) * c

        # 데이터 정제
        self.data['score'] = self.data.apply(weight_rating, axis=1)




    def simEval(self):
        print('se')
        for i in self.data.index:
            point = 0
            game = self.data.at[i, 'genre']  # get_value(i, 'genre')
            name = self.data.at[i, 'name']
            cnt = 10
            for genre in game:
                if genre == "Beat 'em up":
                    genre = "Beat'em up"
                if genre == "Dystopian ":
                    genre = "Dystopian"
                if genre == "Shoot 'Em Up":
                    genre = "Shoot'Em Up"
                if genre == "Parody ":
                    genre = 'Parody'
                point += self.pointDic[genre] * cnt
                cnt -= 1
            if name in self.gameNames:
                point = -1
            self.pointList.append(point)

        # 계산된 유사도를 데이터에 추가
        self.data.loc[:, 'point'] = self.pointList

    def result(self, n):
        print('res')
        # 데이터 출력
        result = self.data.sort_values(by=['point'], ascending=False).head(n)
        result = result.to_json(orient='records')
        parsed = json.loads(result)
        return json.dumps(parsed, indent=4)