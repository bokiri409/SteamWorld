<template>
  <section class="section-show">
    <div class="container">
      <b-button @click.prevent="recommendWish()">
        추천 시작!
      </b-button>
    </div>

    <div v-if="this.resultShow ==true">
      <div class="container">
        <div style="margin-top: 30px">
          <h3>추천 결과</h3>
        </div>
      </div>
      <div style="background-color: none">
        <div id="row">
          <div class="items">
              <div class="row">
        <div
          class="col-md-4"
          v-for="games in this.gameData"
          :key="games.name"
          style="margin-bottom: 20px"
        >
          <b-card
            v-if="games.name != ''"
            :title="games.name"
            :img-src="games.imgsrc"
            img-alt="Image"
            img-top
            tag="article"
            style="width: 100%; text-align:center; background-image: url('../../src/assets/img/gameboy.png');background-color:#00000077; height: 100%"
            @click="goDetail(games.appid)"
          >
            <div style="padding-bottom: 20px">
              <!-- <b-card-text>
            </b-card-text> -->

              <!--  <b-button href="#" variant="primary">상세보기</b-button> -->
            </div>
          </b-card>
        </div>
      </div>
          </div>
        </div>
      </div>
    </div>
    
    <div>
      <div class="container">
        <div style="margin-top: 30px">
          <h3>보유 게임</h3>
        </div>
      </div>
      <div style="background-color: none">
        <div id="row">
          <div class="items">
            <my-game></my-game>
          </div>
        </div>
      </div>
    </div>

    <div>
      <div class="container">
        <div style="margin-top: 30px">
          <h3>관심 게임</h3>
        </div>
      </div>
      <div style="background-color: none">
        <div id="row">
          <div class="items">
            <like-game></like-game>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import MyGame from '../myPage/MyGame';
import LikeGame from '../myPage/LikeGame';

const axios = require('axios');
const SERVER_URL = process.env.VUE_APP_API_SERVER_URL;
const REC_SERVER_URL = process.env.VUE_APP_REC_SERVER_URL;

export default {
  components: {
    MyGame,
    LikeGame,
  },
  data() {
    return {
      inputList: {},
      appids: [],
      user: {
        userid: '',
        nickname: '',
        steamid: '',
      },
      resultList: [],
      itemList: [],
      gameData:[],
      resultShow: false
    };
  },
  async created() {
    if (localStorage.getItem('token')) {
      this.user.token = localStorage.getItem('token');
      this.user.nickname = localStorage.getItem('nickname');
      this.user.steamid = localStorage.getItem('steamid');
      this.user.userid = localStorage.getItem('userid');
      await this.getResult();
      if(this.resultList.length != 0){
          await this.getGame();
          console.log("resultList :", this.resultList)
          this.resultShow = true;
      }
      await this.getItem();
      
    }
  },
  methods: {
    async recommendWish(){
        this.inputList ={
            itemList:this.itemList,
            steamid:this.user.steamid
        }
        console.log(this.inputList);
        await axios
            .post(`${REC_SERVER_URL}/wish`, this.inputList)
            .then((res)=>{
                console.log(res);
                // this.resultList = res.data;
            })
            .catch((res) =>{
                alert('error : ' + res);
            })
    },
    async addResult(){
        await axios
            .post(`${SERVER_URL}/result/add`, this.resultList)
            .then((res) => {
                if(res.data.success == "fail"){                    
                    console.log("err : " + res)
                }
            })
            .catch((res) =>{
                console.log("err : " + res)
            })

    },
    async getResult(){
        await axios
            .get(`${SERVER_URL}/result/list`,{
            params:{
                userid:this.user.userid
            }})
            .then((res) => {
                this.resultList = res.data.data;
            })
            .catch((res) =>{
                console.log("err : " + res)
            })
    },
    async getItem() {
        // console.log("userid : ",this.user.userid)
      await axios
        .get(`${SERVER_URL}/item/list`, { params: { userid: this.user.userid, issteam: '1' } })
        .then((res) => {
            // console.log("res :", res)
          this.itemList = res.data.data;
        //   console.log("itemList @@: ",this.itemList)
        })
        .catch((res) => {
          console.log('err : ' + res);
        });
    },
    async getGame() {
      //   console.log("itemList @@: ",this.itemList)
      for (var app of this.resultList) {
        await axios
          .get(`${SERVER_URL}/game/search`, { params: { appid: app.appid } })
          .then((res) => {
            if (res.data.data != null) {
              // console.log("data : ", res.data.data);
              this.gameData.push(res.data.data);
            }
          })
          .catch((res) => {
            console.log('err : ' + res);
          });
      }
    },
  },
};
</script>
<style scoped>
body {
  margin: 50px auto;
  width: 600px;
}
#row {
  /* white-space: nowrap;  */
  /* ?가로스크롤시 중요한 속성  */
  overflow-x: auto;
  overflow-y: hidden;
  /* padding: 10px 10px 5px; */
  /* background: #f7be98; */
  /* width: 600px; */
}

/* #row .items {
  display: inline-block;
  margin-left: 10px;
  width: 1100px;
  max-width: 100%;
} */

/* #row .items:first-child {
  margin-left: 0;
} */

/* #row .items p {
  margin-bottom: 8px;
  text-indent: 7px;
} */

#row .items div {
  height: 300px;
  overflow-y: scroll;
  /* text-align: left; */
}
</style>
