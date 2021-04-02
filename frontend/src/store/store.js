import axios from 'axios'
import Vue from 'vue'
import Vuex from 'vuex'
import '../main.js'
import { api_url } from '../main.js'

Vue.use(Vuex)

export default new Vuex.Store({
    //data
    state: {
        userid: '',
        nickname: ''
    },
    getters: {
        getUserid: state => {
            return state.userid
        },
        getNickname: state => {
            return state.nickname
        }
    },
    mutations: {
        login: (state, payload) => {
            state.userid = payload.data.userid
            state.nickname = payload.data.nickname

            const userData = {
                userid: state.userid,
                nickname: state.nickname
            }
        }
    },
    actions: {
        login: (context, user) => {
            return axios.post(api_url + `/a105/user/login`, user)
                .then(res => {
                    // console.info(res.data)
                    context.commit('login', res.data)
                })
        }
    }
})