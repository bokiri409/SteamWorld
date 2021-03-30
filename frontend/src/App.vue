<template>
  <div id="app">  
    <TopHeader/>
    <SwBanner/>
  </div>
</template>
<script>

import SwBanner from './components/SwBanner.vue'
import TopHeader from './components/TopHeader.vue'

export default {
  name: 'App',
  components: {
    SwBanner,TopHeader
  }
}
</script>

<style>
  h1,h2,h3,h4,h5,p{
    color:white;
  }
  @import "./assets/css/style.css";
</style>





