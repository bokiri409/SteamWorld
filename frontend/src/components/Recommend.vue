<template>
  <div class="section-show" >
    <div
      class="container"
      style="background-color:#00000077; margin-bottom:50px;"
    >
      <div class="section-title">
        <h2>Game For You</h2>
        <p>게임 추천</p>
      </div>

    </div>
    <div class="container">
      <div style="background-color: none">
            <b-card title="Card Title" no-body>
              <b-card-header header-tag="nav" style="background-color: none">
                <b-nav card-header tabs>
                  <!-- <b-nav-item>'s with child routes. Note the trailing slash on the first <b-nav-item> -->
                  <b-nav-item
                    @click.prevent="loadPopular()"
                    exact
                    exact-active-class="active"
                    style=""
                    >인기 게임</b-nav-item
                  >
                  <b-nav-item @click.prevent="loadRecommendGame()" exact exact-active-class="active"
                    >게임 추천</b-nav-item
                  >
                  <!-- <b-nav-item @click.prevent="loadLikeGame()">관심 게임</b-nav-item> -->
                </b-nav>
              </b-card-header>

              <b-card-body justify-content style="background-color: none">
                <div id="recommend-contents">
                  <component :is="componentLoading()"></component>
                </div>
              </b-card-body>
            </b-card>
          </div>
    </div>
  </div>
</template>

<script>
import Popular from './recommend/Popular';
import RecommendGame from './recommend/RecommendGame';

import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_API_SERVER_URL;


export default {
  data() {
    return {
      user:{
        token: '',
        nickname: '',
        steamid: '',
        userid: '',
      },
      active: 0,
    };
  },
  components: {
    Popular,
    RecommendGame,
  },
  created() {
    if (localStorage.getItem('token')) {
      this.token = localStorage.getItem('token');
      this.nickname = localStorage.getItem('nickname');
      this.steamid = localStorage.getItem('steamid');
      this.userid = localStorage.getItem('userid');
    }
  },
  mounted() {
    
  },
  methods: {
    componentLoading() {
      switch (this.active) {
        case 0:
          return 'Popular';
        case 1:
          return 'RecommendGame';
        // case 2:
        //   return 'LikeGame';
      }
    },
    loadPopular(){
      this.active = 0;
    },
    loadRecommendGame(){
      this.active = 1;
    }
  },
};
</script>

<!--  <script src="../assets/js/main.js"></script>-->
<style scoped>
.card-body {
  padding: 0px;
}
/* card {
  margin-left: 20px;
  margin-right: 20px;
  border-bottom-color: red;
  background-color: #000000;
} */

.modal-content h1 {
  color: #000000;
}

.modal-content h2 {
  color: #000000;
}
.profile_wrapper {
  float: left;
  width: 100px;
  height: 100px;
  margin: 0 15px 0 36px;
  position: relative;
}
.gradation_animate {
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100px;
  height: 100px;
  border-radius: 50%;
  background: url(https://k.kakaocdn.net/dn/BQFZF/btqzu7xZvy9/p3qATq2IbK4edXbUm76pTK/img.png)
    no-repeat;
  /*  background: url("../assets/img/colorGra.png") no-repeat; */
  animation: spin 1s linear infinite;
}
.image_wrapper {
  position: relative;
  overflow: hidden;
  width: 94px;
  height: 94px;
  border-radius: 50%;
  top: 3px;
  left: 3px;
}
.image {
  position: absolute;
  top: -100%;
  left: -100%;
  right: -100%;
  bottom: -100%;
  margin: auto;
  height: 92px;
  min-width: 100%;
  min-height: 100%;
}

nav.card-header {
  background-color: none;
}

a.nav-link {
  color: rgba(255, 255, 255, 0.945);
  border-color: none;
  border-width: 3px;
  border-bottom: none;
  border-radius: 12px 12px 0px 0px;
  background-color: rgba(88, 88, 88, 0.678);
}

a.nav-link:hover {
  color: white;
  border-color: white;
  border-width: 3px;
  border-bottom: none;
  border-radius: 12px 12px 0px 0px;
}

a.nav-link:focus {
  color: #35e888;
  border-color: #35e888;
  border-width: 3px;
  border-bottom: none;
  border-radius: 12px 12px 0px 0px;
}

div.card {
  background-color: #00000000;
}

div.card-body {
  background-color: rgba(255, 255, 255, 0.08);
  border-width: 15px;
  border-color: #35e888;
}

h2.section-title {
  line-height: 0px;
  margin: 0 0 10px 0;
}

div.profile-container {
  background-color: rgba(255, 255, 255, 0.08);
}

.section-show {
  margin-top: 40px;
}

.section-title {
  margin-top: 20px;
}
</style>
