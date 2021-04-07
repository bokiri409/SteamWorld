<template>
    <div class="container blueArea">
    <h1>당신의 게임 유형은</h1>
    <h1>평화로운 방랑자입니다.</h1>

    <p>추천게임</p>
    <h3>스타듀밸리 저니</h3>
    <div class="row">
      <div class="col-md-1"></div>
      <b-card
        class="col-md-5"
        :title="this.gamedata1.data.game.name"
        :img-src="this.gamedata1.data.game.imgsrc"
        @click="goDetail(gamedata1.data.appid)"
        img-alt="Image"
        img-top
        tag="article"
        style="width: 100%; padding:0 0 0 0; text-align:center; background-image: url('../../src/assets/img/gameboy.png'); background-color:#00000077; height: 100%"
      >
      </b-card>

      <b-card
        class="col-md-5"
        :title="this.gamedata2.data.game.name"
        :img-src="this.gamedata2.data.game.imgsrc"
        @click="goDetail(gamedata2.data.appid)"
        img-alt="Image"
        img-top
        tag="article"
        style="width: 100%; margin-left:20px; padding:0 0 0 0;text-align:center; background-image: url('../../src/assets/img/gameboy.png'); background-color:#00000077; height: 100%"
      >
      </b-card>
    </div>
  </div>
</template>

<script>
import axios from "axios";
const SERVER_URL = process.env.VUE_APP_API_SERVER_URL;
export default {
  data() {
    return {
      result: "",
      headerUrl: "",
      linkUrls: [],
      videoUrl: "",
      gameDes: "",
      genreList: [],
      gameInfo: null,
      appId: "",
      gamedata1: "",
      gamedata2: "",
    };
  },

  created() {
    const appId = this.$route.query.appId;
    console.log("!!!!!" + this.$route.query.appId);
    this.getGameInfos(433340, 638230);
    var img = document.getElementById("headerImg");

    console.log(this.headerUrl);
    document.getElementById("headerImg").innerHTML =
      "<img src=" + this.headerUrl + "/>";
    img.src = this.headerUrl;
  },
  methods: {
    getGameInfo(appid) {
      axios
        .get(`${SERVER_URL}/game/info/search`, { params: { appid: appid } })
        .then((res) => {
          const gamedata = res.data;
          this.gamedata = gamedata;
          console.log(gamedata.data);
          this.linkUrls = gamedata.data.gamelinks;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getGameInfos(appid1, appid2) {
      axios
        .get(`${SERVER_URL}/game/info/search`, { params: { appid: appid1 } })
        .then((res) => {
          const gamedata1 = res.data;
          this.gamedata1 = gamedata1;
          console.log(gamedata1.data);
          this.linkUrls = gamedata1.data.gamelinks;
        })
        .catch((err) => {
          console.log(err);
        });

      axios
        .get(`${SERVER_URL}/game/info/search`, { params: { appid: appid2 } })
        .then((res) => {
          const gamedata2 = res.data;
          this.gamedata2 = gamedata2;
          console.log(gamedata2.data);
          this.linkUrls = gamedata2.data.gamelinks;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    goDetail: function(appid) {
      this.$router.push({ path: "/detail", query: { appId: appid } });
    },
  },
};
</script>
