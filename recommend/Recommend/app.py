from flask import Flask
from flask import Response
from CBF.CBF import ContentsBasedFiltering
from CF.CF import CollaborativeFiltering
from flask_cors import CORS
import werkzeug
werkzeug.cached_property = werkzeug.utils.cached_property
from flask_restplus import Api, Resource
import json
import time

app = Flask(__name__)

## CORS 에러 방지
CORS(app)

## Swagger API 설정
api = Api(app, version='1.0', title='Recommendation API',
          description='게임 추천 API',)

recomm = api.namespace('rec', description='게임추천 API 목록')
app.config.SWAGGER_UI_DOC_EXPANSION = 'list'


@app.route('/')
def index():
    return "hello, world!"


@recomm.route('/cbf/<int:appid>')
class CBF(Resource):
    def get(self, appid):
        data = ContentsBasedFiltering(appid)
        data.makePoint()
        data.refine()
        data.simEval()
        result = data.result(10).to_json(orient='records')
        parsed = json.loads(result)
        resp = {
            'success': 'success',
            'data' : parsed
        }
        return Response(json.dumps(resp, ensure_ascii=False), content_type='application/json; charset=utf-8')


@recomm.route('/cf/<int:steamid>')
class CF(Resource):
    def get(self, steamid):
        data = CollaborativeFiltering(steamid)
        reason = data.getUserData()
        if reason == 'success':
            data.refine()
            already_rated, predictions = data.recommend_games(10)
            result = predictions.to_json(orient='records')
            parsed = json.loads(result)
            resp = {
                'success': 'success',
                'data': parsed
            }
            return Response(json.dumps(resp, ensure_ascii=False), content_type='application/json; charset=utf-8')
        else:
            resp = {
                'success': 'fail',
                'reason' : reason,
                'data' : ''
            }
            return Response(json.dumps(resp, ensure_ascii=False), content_type='application/json; charset=utf-8')
