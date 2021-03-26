from flask import Flask
from flask import Response
from CBF.CBF import ContentsBasedFiltering
from CF.CF import CollaborativeFiltering
from flask_cors import CORS
import werkzeug
werkzeug.cached_property = werkzeug.utils.cached_property
from flask_restplus import Api, Resource


app = Flask(__name__)

## CORS 에러 방지
CORS(app)

## Swagger API 설정
api = Api(app, version='1.0', title='Recommendation API',
          description='게임 추천 API',)

recomm = api.namespace('Recommendation', description='게임추천 API 목록')
app.config.SWAGGER_UI_DOC_EXPANSION = 'list'


@app.route('/')
def index():
    return "hello, world!"


@recomm.route('/CBF/<int:appid>')
class CBF(Resource):
    def get(self, appid):
        list = []
        list.append(appid)
        data = ContentsBasedFiltering(list)
        data.refine()
        data.makePoint()
        data.simEval()
        return Response(data.result(10), content_type='application/json; charset=utf-8')


@recomm.route('/CF/<int:steamid>')
class CF(Resource):
    def get(self,steamid):
        data = CollaborativeFiltering(steamid)
        data.getUserData()
        data.refine()
        already_rated, predictions = data.recommend_games(30)
        return Response(predictions, content_type='application/json; charset=utf-8')
