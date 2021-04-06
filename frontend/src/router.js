import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from './components/Main.vue'
import Login from './components/Login.vue'
import SignUp from './components/SignUp.vue'
import Recommend from './components/Recommend.vue'
import MyPage from './components/MyPage.vue'
import Survey from './components/Survey.vue'
import Result from './components/surveyResult/Result.vue'
import Q1 from './components/surveyQ/Q1.vue'
import Q2 from './components/surveyQ/Q2.vue'
import Q3 from './components/surveyQ/Q3.vue'
import Q4 from './components/surveyQ/Q4.vue'
import Q5 from './components/surveyQ/Q5.vue'
import Q6 from './components/surveyQ/Q6.vue'
import Q7 from './components/surveyQ/Q7.vue'
import Q8 from './components/surveyQ/Q8.vue'
import Q9 from './components/surveyQ/Q9.vue'
import Q10 from './components/surveyQ/Q10.vue'
import Q11 from './components/surveyQ/Q11.vue'
import Q12 from './components/surveyQ/Q12.vue'
import MyGame from './components/myPage/MyGame.vue'


Vue.use(VueRouter);

export const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/',
            component: Main
        },
        {
            path: '/user/login',
            component: Login
        },
        {
            path: '/user/signup',
            component: SignUp
        },
        {
            path: '/survey',
            component: Survey
        },
        {
            path: '/recommend',
            component: Recommend
        },
        {
            path: '/mypage',
            component: MyPage
        },
        {
            path: '/result',
            component: Result
        },
        {
            path: '/q1',
            component: Q1
        },
        {
            path: '/q2',
            component: Q2
        },
        {
            path: '/q3',
            component: Q3
        },
        {
            path: '/q4',
            component: Q4
        },
        {
            path: '/q5',
            component: Q5
        },
        {
            path: '/q6',
            component: Q6
        },
        {
            path: '/q7',
            component: Q7
        },
        {
            path: '/q8',
            component: Q8
        },
        {
            path: '/q9',
            component: Q9
        },
        {
            path: '/q10',
            component: Q10
        },
        {
            path: '/q11',
            component: Q11
        },
        {
            path: '/q12',
            component: Q12
        },
        {
            path: '/result',
            component: Result
        },
        {
            path: 'mypage/mygame',
            component: MyGame

        }
    ]
})  