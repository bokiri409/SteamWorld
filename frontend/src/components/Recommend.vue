<template>
  <div class="section-show">
    <div class="container" style="background-color:#00000077; margin-bottom:50px;">
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
              <b-nav-item @click.prevent="loadPopular()" exact exact-active-class="active" style=""
                >인기 게임</b-nav-item
              >
              <b-nav-item @click.prevent="loadRecommendGame()" exact exact-active-class="active"
                >게임 추천</b-nav-item
              >
              <b-nav-item @click.prevent="loadSearchGame()" exact exact-active-class="active"
                >게임 추천</b-nav-item
              >
              <!-- <b-nav-item @click.prevent="loadLikeGame()">관심 게임</b-nav-item> -->
            </b-nav>
          </b-card-header>
          <div v-if="this.active==2">
          <div style="margin-top: 30px margin-bottom:30px">
            <h3>스팀 게임 검색하기</h3>
            <div class="form-group">
              <input
                type="search"
                class="form-control form-control-lg"
                v-model="searchname"
                id="searchname"
                placeholder="게임 검색"
                @keyup.13="searchData()"
              />
            </div>
          </div>
          <div class="row">
            <div
              class="col-md-4"
              v-for="games in this.searchshowdata"
              :key="games.title"
              style="margin-bottom: 20px"
            >
              <b-card
                v-if="games.title != ''"
                :title="games.title"
                :img-src="games.thumnail"
                img-alt="Image"
                img-top
                tag="article"
                style="width: 100%; text-align:center; background-image: url('../../src/assets/img/gameboy.png'); background-color:#00000077; height: 100%"
                @click="goDetail(games.appid)"
              >
              </b-card>
            </div>
          </div>
          </div>
          <div style="text-align: center">
            <div href="javascript:void(0)" @click="changeShow(false)" v-show="firstpage == false">
              <i class="bi bi-chevron-double-left"></i>
            </div>
            <div href="javascript:void(0)" @click="changeShow(true)" v-show="resultleft == true">
              <i class="bi bi-chevron-double-right"></i>
            </div>
          </div>

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
      user: {
        token: '',
        nickname: '',
        steamid: '',
        userid: '',
      },
      active: 0,
      like: '',
      token: '',
      searchname: '',
      searchtotaldata: [{ appid: ' ', title: '', thumnail: '' }],
      searchshowdata: [{ appid: ' ', title: '', thumnail: '' }],
      startindex: 0,
      endindex: 0,
      resultleft: false,
      firstpage: true,
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
  mounted() {},
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
    loadPopular() {
      this.active = 0;
    },
    loadRecommendGame() {
      this.active = 1;
    },
    loadSearchGame() {
      this.active = 2;
    },
    searchData: function() {
      if (this.searchname.length < 2) {
        alert('최소 2글자 이상 검색이 가능합니다.');
        return;
      }
      this.startindex = 0;
      this.endindex = 0;
      this.firstpage = true;
      this.resultleft = false;
      axios
        .get(`${SERVER_URL}/game/search/name?word=` + this.searchname)
        .then((res) => {
          this.searchtotaldata = res.data.data;
          this.searchshowdata = '';
          if (this.searchtotaldata.length == 0) {
            alert('검색 결과가 없습니다.');
          } else {
            if (this.searchtotaldata.length >= this.startindex + 9) {
              this.endindex += 9;
              this.resultleft = true;
            } else this.endindex = this.searchtotaldata.length;

            for (var i = 0; i < this.endindex; i++) {
              this.searchshowdata = [
                ...this.searchshowdata,
                ...[
                  {
                    appid: this.searchtotaldata[i].appid,
                    title: this.searchtotaldata[i].name,
                    thumnail: this.searchtotaldata[i].imgsrc,
                  },
                ],
              ];
            }
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    changeShow: function(flag) {
      this.searchshowdata = [];
      if (flag) {
        if (this.searchtotaldata.length > this.endindex + 9) {
          this.endindex += 9;
          this.startindex += 9;
          this.resultleft = true;
        } else {
          this.startindex += 9;
          this.endindex = this.searchtotaldata.length;
          this.resultleft = false;
        }
        this.firstpage = false;
      } else {
        if (this.endindex == this.searchtotaldata.length) {
          var temp = this.searchtotaldata.length;
          if (temp == 0) temp = 9;
          this.endindex = this.startindex;
          this.startindex -= 9;
        } else {
          if (this.startindex - 9 >= 0) {
            this.endindex = this.startindex;
            this.startindex -= 9;
            if (this.startindex == 0) this.firstpage = true;
          }
        }
        this.resultleft = true;
      }
      for (var i = this.startindex; i < this.endindex; i++) {
        this.searchshowdata = [
          ...this.searchshowdata,
          ...[
            {
              appid: this.searchtotaldata[i].appid,
              title: this.searchtotaldata[i].name,
              thumnail: this.searchtotaldata[i].imgsrc,
            },
          ],
        ];
      }
    },
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
