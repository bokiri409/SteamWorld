from flask import Flask
from CBF.CBF import ContentsBasedFiltering
from CF.CF import CollaborativeFiltering
from flask_cors import CORS
import werkzeug
werkzeug.cached_property = werkzeug.utils.cached_property
import time

app = Flask(__name__)
CORS(app, resources={r'*': {'origins': '*'}})


@app.route('/')
def index():
    return "hello, world!"


@app.route('/CBF', methods=['GET'])
def cbf():
    data = ContentsBasedFiltering(0.9, {'Dungreed': 3})
    data.refine()
    data.makePoint()
    data.simEval()
    return data.result(20)


@app.route('/CF', methods=['GET'])
def cf():
    Time = time.time()
    data = CollaborativeFiltering(76561198406547455)
    data.getUserData()
    data.refine()
    already_rated, predictions = data.recommend_games(30)
    print(time.time() - Time)
    return predictions


@app.route('/info')
def info():
    return 'Info'


@app.route('/get', methods=['GET'])
def recommend():
    return "get"