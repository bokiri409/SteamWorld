<template>
  <div class="section-show">
    <div class="row"></div>
    <div class="row" style="width:100%">
      <div class="col-md-1"></div>
      <div class="col-md-10 box" style="background-color:#00000077;">
        <div class="section-title">
          <h2>마이페이지</h2>
          <p>My Page</p>

          <h1 class=" typing-txt" style="margin-bottom:100px;">
            {{user.nickname}} 님의 마이페이지
          </h1>

          <br />

          <div class="profile-row row">
            <div class="col-md-2"></div>
            <div class="col-md-4">
              <div
                style="display:flex; justify-content:flex-end; border-color:#36e888; border-width:3px; border-radius:20px; height:250px; width:250px; display:block; overflow: hidden;"
              >
                <img
                  src="../assets/img/poster.png"
                  style="display:block; max-width:100%; min-width:100%;"
                />
              </div>
            </div>
            <div class="col-md-6" style="">
              <div class="section-title">
                <h2>닉네임</h2>
              </div>
              <h3> {{user.nickname}}</h3>
              <br />
              <div class="section-title">
                <h2>이메일</h2>
              </div>
              <h3> {{user.userid}}</h3>
              <div class="section-title">
                <h2>스팀 아이디</h2>
              </div>
              <h3>{{ sid }}</h3>
            </div>
          </div>

          <b-button class="btn-lg" style="border-radius: 10rem" @click="getUrl()"
            >스팀 연동하기</b-button
          >

          <form action="https://steamcommunity.com/openid/login" method="post">
            <input
              type="hidden"
              name="openid.identity"
              value="http://specs.openid.net/auth/2.0/identifier_select"
            />
            <input
              type="hidden"
              name="openid.claimed_id"
              value="http://specs.openid.net/auth/2.0/identifier_select"
            />
            <input type="hidden" name="openid.ns" value="http://specs.openid.net/auth/2.0" />
            <input type="hidden" name="openid.mode" value="checkid_setup" />
            <input type="hidden" name="openid.realm" value="http://localhost:8080" />
            <input type="hidden" name="openid.return_to" value="http://localhost:8080/mypage" />
            <b-button type="submit btn-large" style="border-radius: 10rem"
              ><img src="../assets/img/steam.svg" class="steamlogo" />스팀 로그인</b-button
            >
          </form>

          <div class="counts container">
            <div class="row">
              <div class="col-lg-3 col-md-6">
                <div class="count-box">
                  <i class="bi bi-controller"></i>
                  <span
                    data-purecounter-start="0"
                    data-purecounter-end="232"
                    data-purecounter-duration="0"
                    class="purecounter"
                    >32</span
                  >
                  <p>보유 게임</p>
                </div>
              </div>

              <div class="col-lg-3 col-md-6 mt-5 mt-md-0">
                <div class="count-box">
                  <i class="bi bi-emoji-heart-eyes"></i>
                  <span
                    data-purecounter-start="0"
                    data-purecounter-end="521"
                    data-purecounter-duration="0"
                    class="purecounter"
                    >24</span
                  >
                  <p>관심 게임</p>
                </div>
              </div>

              <div class="col-lg-3 col-md-6 mt-5 mt-lg-0">
                <div class="count-box">
                  <i class="bi bi-headset"></i>
                  <span
                    data-purecounter-start="0"
                    data-purecounter-end="1463"
                    data-purecounter-duration="0"
                    class="purecounter"
                    >1463</span
                  >
                  <p>총 플레이 시간</p>
                </div>
              </div>

              <div class="col-lg-3 col-md-6 mt-5 mt-lg-0">
                <div class="count-box">
                  <i class="bi bi-award"></i>
                  <span
                    data-purecounter-start="0"
                    data-purecounter-end="24"
                    data-purecounter-duration="0"
                    class="purecounter"
                    >24</span
                  >
                  <p>도전과제</p>
                </div>
              </div>
            </div>
          </div>

          <div style="background-color:none">
            <b-card title="Card Title" no-body>
              <b-card-header header-tag="nav" style="background-color:none">
                <b-nav card-header tabs>
                  <!-- <b-nav-item>'s with child routes. Note the trailing slash on the first <b-nav-item> -->
                  <b-nav-item
                    @click.prevent="loadUpdate()"
                    exact
                    exact-active-class="active"
                    style=""
                    >프로필 상세</b-nav-item
                  >
                  <b-nav-item @click.prevent="loadMyGame()" exact exact-active-class="active"
                    >보유 게임</b-nav-item
                  >
                  <b-nav-item @click.prevent="loadRecGame()">추천 게임</b-nav-item>
                </b-nav>
              </b-card-header>

              <b-card-body justify-content style="background-color:none">
                <!-- Child route gets rendered in <router-view> or <nuxt-child> -->
                <div id="mypage-contents">
                  <!-- <UpdateUser id="update" style="margin-top:0px;margin-left:0px" /> -->
                  <component :is="componentLoading()"></component>
                </div>
                <!-- Or if using Nuxt.js
      <nuxt-child></nuxt-child>
      -->
              </b-card-body>
            </b-card>
          </div>

          <button @click="test('store.steampowered.com/app/1046930')">
            <!--1046930-->
            와우버튼
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script src="../assets/js/crawl.js"></script>
<script>
// axios를 활용해 AJAX로 HTML 문서를 가져오는 함수 구현
async function getHTML() {
  try {
    return await axios.get('https://chaewonkong.github.io');
  } catch (error) {
    console.error(error);
  }
}

// getHTML 함수 실행 후 데이터에서
// body > main > div > section > ul > li > article > h2 > a
// 에 속하는 제목을 titleList에 저장
getHTML()
  .then((html) => {
    let titleList = [];
    const $ = cheerio.load(html.data);
    // ul.list--posts를 찾고 그 children 노드를 bodyList에 저장
    const bodyList = $('ul.list--posts').children('li.item--post');

    // bodyList를 순회하며 titleList에 h2 > a의 내용을 저장
    bodyList.each(function(i, elem) {
      titleList[i] = {
        title: $(this)
          .find('h2 a')
          .text(),
      };
    });
    return titleList;
  })
  .then((res) => console.log(res)); // 저장된 결과를 출력
</script>
<script>
import UpdateUser from './myPage/UpdateUser';
import MyGame from './myPage/MyGame';
import RecGame from './myPage/RecGame';
// import { SERVER_URL } from '../main';
import { mapState } from 'vuex';

const axios = require('axios');
const cheerio = require('cheerio');
const SERVER_URL = process.env.VUE_APP_API_SERVER_URL;

export default {
  data() {
    return {
      user: {
        userid: '',
        nickname: '',
        steamid: '',
      },
      sid: '',
      active: 0,
      slide: 0,
      sliding: null,
    };
  },
  components: {
    MyGame,
    RecGame,
    UpdateUser,
  },
  computed:{
    ...mapState(['loginStatus'])
  },
  created(){
    this.getUserInfo();
  },
  methods: {
    onSlideStart(slide) {
      this.sliding = true;
    },
    onSlideEnd(slide) {
      this.sliding = false;
    },
    getUrl() {
      var link = document.location.href.split('&');
      console.log(link[3]);
      this.sid = link[3].slice(67, link[3].length);
    },
    getUserInfo(){
      axios
        .get(`${SERVER_URL}/user`,{
          params:{
            userid : this.login
          }
        })
        .then((res) => {
          this.user.userid = res.data.data.userid;
          this.user.nickname = res.data.data.nickname;
          this.user.steamid = res.data.data.steamid;
        })
    },
    componentLoading() {
      switch (this.active) {
        case 0:
          return 'UpdateUser';
        case 1:
          return 'MyGame';
        case 2:
          return 'RecGame';
      }
    },

    loadUpdate() {
      this.active = 0;
    },
    loadMyGame() {
      this.active = 1;
    },
    loadRecGame() {
      this.active = 2;
    },
    getHTML(url) {
      var optionAxios = {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,OPTIONS',
          'Access-Control-Allow-Headers':
            'Content-Type, Authorization, Content-Length, X-Requested-With',
        },
      };
      try {
        console.log(axios.get('https://cors-anywhere.herokuapp.com/' + url, optionAxios));
        return axios
          .get('https://cors-anywhere.herokuapp.com/' + url, optionAxios)
          .then((html) => {
            let titleList = [];
            const $ = cheerio.load(html.data);
            // ul.list--posts를 찾고 그 children 노드를 bodyList에 저장
            const bodyList = $('ul.list--posts').children('li.item--post');
            console.log(bodyList);

            // bodyList를 순회하며 titleList에 h2 > a의 내용을 저장
            bodyList.each(function(i, elem) {
              titleList[i] = {
                title: $(this)
                  .find('h2 a')
                  .text(),
              };
            });
            return titleList;
          })
          .then((res) => console.log(res));
      } catch (error) {
        console.error(error);
      }
    },
    test(url) {
      var optionAxios = {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,OPTIONS',
          'Access-Control-Allow-Headers':
            'Content-Type, Authorization, Content-Length, X-Requested-With',
        },
      };
      axios
        .get('https://cors-anywhere.herokuapp.com/' + url, optionAxios)
        .then((response) => {
          var htmlText = response.data;

          let titleList = [];
          const $ = cheerio.load(htmlText);

          const bodyList = $('div.game_description_snippet');
          console.log('1' + bodyList);

          // bodyList를 순회하며 titleList에 h2 > a의 내용을 저장
          bodyList.each(function(i, elem) {
            titleList[i] = {
              title: $(this)
                .find('div')
                .text(),
            };
          });
          return titleList;
        })
        .then((titleList) => console.log(titleList));
    },
  },
};
</script>

<style scoped>
.typing-txt {
  position: relative;
  display: inline-block;
  height: 40px;
  overflow: hidden;
  animation: typingAni 1s steps(15, end) 1;
}

.typing-txt::after {
  position: absolute;
  display: block;
  content: '';
  width: 5px;
  height: 30px;
  top: 5px;
  right: 0px;
  border-right: 3px solid rgb(252, 252, 252);
  animation: cursor 0.5s step-end infinite;
}
@keyframes typingAni {
  0% {
    width: 0%;
  }
  100% {
    width: 30%;
  }
}
@keyframes cursor {
  0% {
    opacity: 0;
  }
  50% {
    opacity: 1;
  }
  100% {
    opacity: 0;
  }
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
</style>
