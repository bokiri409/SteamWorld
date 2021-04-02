import Vue from 'vue'
import App from './App.vue'
import { router } from './router.js'
import store from './store/store.js'
import axios from 'axios'

import { BootstrapVue,  CarouselPlugin, BootstrapVueIcons  } from 'bootstrap-vue'
//import bFormSlider from 'vue-bootstrap-slider';
//import {Waypoint} from "./assets/vendor/waypoints/noframework.waypoints.js"

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'bootstrap-slider/dist/css/bootstrap-slider.css'

export const api_url = "http://localhost:8080"
// export const api_url = "http://j4a105.p.ssafy.io:8080/a105/"

Vue.prototype.$api_url = api_url

// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin

Vue.use(BootstrapVueIcons)
Vue.use(CarouselPlugin)

Vue.config.productionTip = false
Vue.prototype.$Axios = axios



new Vue({
  render: h => h(App),
  router,
  store,
  scrollBehavior (to, from, savedPosition) {
    if (to.hash) {
      return {
        selector: to.hash
        // , offset: { x: 0, y: 10 }
      }
    }
  }
}).$mount('#app')
