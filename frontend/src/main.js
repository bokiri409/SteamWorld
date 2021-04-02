import Vue from 'vue'
import App from './App.vue'

import { router } from './router.js'

import { BootstrapVue,  CarouselPlugin, BootstrapVueIcons  } from 'bootstrap-vue'
//import bFormSlider from 'vue-bootstrap-slider';
//import {Waypoint} from "./assets/vendor/waypoints/noframework.waypoints.js"

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'bootstrap-slider/dist/css/bootstrap-slider.css'
import BootstrapIcons from './assets/vendor/bootstrap-icons//bootstrap-icons.json'
import 'aos'
import Aos from 'aos'
import axios from 'axios'


// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin

Vue.use(BootstrapVueIcons)
Vue.use(CarouselPlugin)
Vue.use(BootstrapIcons)
Vue.use(Aos)
Vue.use(axios)





Vue.config.productionTip = false



new Vue({
  render: h => h(App),
  router,
  scrollBehavior (to, from, savedPosition) {
    if (to.hash) {
      return {
        selector: to.hash
        // , offset: { x: 0, y: 10 }
      }
    }
  }
}).$mount('#app')
