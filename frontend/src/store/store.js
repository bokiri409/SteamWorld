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
        nickname: '',
        result: '!'
    },
    getters: {
        getUserid: state => {
            return state.userid
        },
        getNickname: state => {
            return state.nickname
        },
        getResult: state => {
            return state.result
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
        },
        logout(state) {
            state.userid = ''
            state.nickname = ''
        },
        putE(state){
            state.result = state.result+'E'
            console.log(state.result)
        },
        putI(state){
            state.result = state.result+'I'
            console.log(state.result)
        },
        putN(state){
            state.result = state.result+'N'
            console.log(state.result)
        },
        putS(state){
            state.result = state.result+'S'
            console.log(state.result)
        },
        putT(state){
            state.result = state.result+'T'
            console.log(state.result)
        },
        putJ(state){
            state.result = state.result+'J'
            console.log(state.result)
        },
        putP(state){
            state.result = state.result+'P'
            console.log(state.result)
        },
        putF(state){
            state.result = state.result+'F'
            console.log(state.result)
        },
        slice(state,index){
            state.result=state.result.substring(0,index);
        }

    },
    actions: {
        login: (context, user) => {
            return axios.post(api_url + `/a105/user/login`, user)
                .then(res => {
                    // console.info(res.data)
                    context.commit('login', res.data)
                })
        },
        logout: (context) => {
            context.commit('logout')
        }
    }
})