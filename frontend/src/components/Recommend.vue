<template>
  <section class="section-show">
    <div
      class="container"
      style="background-color:#00000077; margin-bottom:50px;"
    >
      <div class="section-title">
        <h2>Game For You</h2>
        <p>게임 추천</p>
      </div>

      <div style="margin-top: 30px">
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
      <div style="text-align: center">
        <a href="javascript:void(0)" @click="changeShow(false)" v-show="firstpage == false" ><i class="bi bi-chevron-double-left"></i></a>
        <a href="javascript:void(0)" @click="changeShow(true)" v-show="resultleft == true" ><i class="bi bi-chevron-double-right"></i></a> 
      </div>
      <div style="margin-top: 30px">
        <h3>인기 게임 목록</h3>
      </div>

      <div class="row">
        <div
          class="col-md-4"
          v-for="(games, index) in this.gamedata"
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
            <div
              v-if="isLogin"
              style="position: static; right: 0px; bottom:0px; padding-bottom: 20px; padding-right: 20px; text-align: right;"
            >
              <!-- <b-card-text>
                hi
              </b-card-text> -->
              <!-- <b-button> -->
              <b-icon
                icon="star"
                scale="1.5"
                style="color: yellow;"
                v-if="like == 0"
                @click="LikeHandler(index)"
              ></b-icon>
              <b-icon
                icon="star-fill"
                scale="1.5"
                style="color: yellow;"
                v-if="like == 1"
                @click="LikeHandler()"
              ></b-icon>
              <!-- </b-button> -->

              <!--  <b-button href="#" variant="primary">상세보기</b-button> -->
            </div>
          </b-card>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import axios from 'axios';
// import { api_url } from '../main';
import { SERVER_URL, LOCALHOST_URL } from '../main.js';

export default {
  components: {},
  data() {
    return {
      gamedata: [{ appid: '', title: '', thumnail: '' }],
      select: (el, all = false) => {
        el = el.trim();
        if (all) {
          return [...document.querySelectorAll(el)];
        } else {
          return document.querySelector(el);
        }
      },
      like: '',
      token: '',
      searchname:'',
      searchtotaldata: [{appid:' ', title: '', thumnail: ''}],
      searchshowdata: [{appid:' ', title: '', thumnail: ''}],
      startindex: 0,
      endindex: 0,
      resultleft: false,
      firstpage: true,
    };
  },
  created() {
    if (localStorage.getItem('token')) {
      this.token = localStorage.getItem('token');
      this.nickname = localStorage.getItem('nickname');
      this.steamid = localStorage.getItem('steamid');
    }
  },
  mounted() {
    axios
      .get(
        `${SERVER_URL}/game/popular?size=12&start=0` //top10 고정값으로 받아옴
        // `/a105/game/popular?size=${this.gamelist.size}&start=${this.gamelist.start}`
      )
      .then((res) => {
        var i = 0;
        for (i = 0; i < 12; i++) {
          // this.gamedata.title = res.data.data[i].name;
          // this.gamedata.thumnail = res.data.data[i].imgsrc;
          this.gamedata = [
            ...this.gamedata,
            ...[
              {
                appid: res.data.data[i].appid,
                title: res.data.data[i].name,
                thumnail: res.data.data[i].imgsrc,
              },
            ],
          ];
        }
        this.gamedata.splice(0, 1);
        // console.log(this.gamedata);
      })
      .catch((err) => {
        console.log(err);
      });
  },
  methods: {
    isLogin: function() {
      if (!this.token) {
        alert('로그인 후 이용 가능합니다!');
      } else {
        console.log('로그인중');
      }
    },
    LikeHandler: function(name) {
      if (this.like == 0) {
        this.like = 1;
        // var game = this.select('.col-md-4');
        console.log(name);
      } else {
        this.like = 0;
      }
    },
    goDetail: function(appid) {
      console.log(appid);
      this.$router.push({ path: '/detail', query: { appId: appid } });
    },
    searchData: function(){
      if(this.searchname.length < 2){
        alert('최소 2글자 이상 검색이 가능합니다.');
        return;
      }
      this.startindex = 0;
      this.endindex = 0;
      this.firstpage = true;
      this.resultleft = false;
      axios.get(
        `${SERVER_URL}/game/search/name?word=` + this.searchname).then((res) => {
            this.searchtotaldata = res.data.data;
            this.searchshowdata = ''
            if(this.searchtotaldata.length == 0){
              alert('검색 결과가 없습니다.')
            }
            else{
              if(this.searchtotaldata.length >= this.startindex + 9){
                this.endindex += 9;
                this.resultleft = true;
              }
              else
                this.endindex = this.searchtotaldata.length;

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
    changeShow: function(flag){
      this.searchshowdata = [];
      if(flag){
        if(this.searchtotaldata.length > this.endindex + 9){
          this.endindex += 9;
          this.startindex += 9;
          this.resultleft = true;
        }
        else{
          this.startindex += 9;
          this.endindex = this.searchtotaldata.length;
          this.resultleft = false;
        }
        this.firstpage = false;
      }
      else{
        if(this.endindex == this.searchtotaldata.length){
          var temp =  this.searchtotaldata.length;
          if(temp == 0) temp = 9;
          this.endindex = this.startindex;
          this.startindex -= 9;
        }
        else{
          if(this.startindex - 9 >= 0){
            this.endindex = this.startindex;
            this.startindex -= 9;
            if(this.startindex == 0)
              this.firstpage = true;
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
</style>
