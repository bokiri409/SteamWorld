<template>
  <section class="section-show">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 style="margin-left:15px;">{{ gameInfo.data.game.name }}</h1>
         
        </div>

        <div class="col-md-8">
          <img :src="headerUrl" style="width:100%" />
        </div>

        <div class="col-md-4 col-sm-12">
           <span style="margin-right:10px;" v-for="(genre, idx) in genreList"
          :key="idx">
          <b-badge style="height:30px; font-size:1rem; font-weight:normal; border-radius:10px;" variant="primary">{{genre.genre}}</b-badge></span>
          <table style="width:100%">
            
            <tr>
              <td><h4>제작사:</h4></td>
              <td style="text-align:right; width:60%">
                <h5>{{ gameInfo.data.game.dev }}</h5>
              </td>
            </tr>
            <tr>
              
            </tr>
            <tr>
              <td><h4>평가:</h4></td>
              <td style="text-align:right; width:60%">
                <h5>{{ gameInfo.data.game.score }}</h5>
              </td>
            </tr>
          </table>

          <!--
              <i class="bi bi-star"></i>
              <i class="bi bi-star-fill"></i>
              -->
          <button
            type="button"
            class="btn btn-secondary"
            style="width:100%; height: 50px; margin-bottom:20px;"
          >
            <i class="bi bi-star-fill" style="color:yellow"></i>
            <!--컬러 회색 #6c757d하고 노란색 #ffc107-->
            관심 게임 추가하기
          </button>

          <a :href="gameInfo.data.game.storelink" target="_blank"
            ><button
              style="width:100%; height: 50px;"
              type="button"
              class="btn btn-primary"
            >
              <img src="../assets/img/steam.svg" style="width:30px"/>
              스팀 상점 바로가기
            </button></a
          >
        </div>
      </div>
      <div class="col-md-12 section-title">
        <h2>게임 간단 설명</h2>
        <h5>{{ gameInfo.data.game.shortDes}}</h5>
      </div>
      <div class="row"></div>

      <div class="row">
        <div class="col-md-12 section-title">
          <h2>관련 영상</h2>
          <video :src="videoUrl" controls autoplay/>
<!--
          <div class="col-12 col-sm-6 col-md-4 col-lg-4"
           v-for="(gamelink, idx) in gameData.data.gamelinks"
          :key="idx"
        ><video :src="gamelink.url" controls />
        <img :src="gamelink.url"/>
        
        </div>
   -->
        </div>
      </div>

      <div class="row">
        <div class="col-md-12 section-title">
          <h2>게임 상세 설명</h2>

          <div v-html="this.gameDes" style="width:100%; padding: 5px;" ></div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import axios from "axios";
const SERVER_URL = process.env.VUE_APP_API_SERVER_URL;
export default {
  data() {
    return { result: "",
     headerUrl: "", 
     linkUrls: [], 
     videoUrl: "",
     gameDes: "",
     genreList: [],
     gameInfo: null 
     };
  },
  created() {
    this.getGameInfo(381210);
    var img = document.getElementById("headerImg");

    img.src;
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
          const gameData = res.data;

          this.gameData = gameData;
          this.gameInfo = gameData;
          this.headerUrl =
            "https://cdn.cloudflare.steamstatic.com/steam/apps/" +
            gameData.data.appid +
            "/header.jpg";

          console.log(gameData.data);
          console.log(this.headerUrl);


          this.linkUrls=gameData.data.gamelinks;
          console.log(this.linkUrls[0].url);

         // for(gameData.data.gamelinks)
         const gameDes="";

          this.videoUrl=this.linkUrls[0].url;
          this.gameDes = this.gameData.data.game.fullDes;
     


          for (var i = 0; i < 3; ++i) {
            this.genreList.push(this.gameData.data.gametags[i]);
          }
          console.log(this.genreList)




        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style scoped>
.section-title {
  padding-top: 20px;
}

h2 {
  color: white;
  font-weight: bold;
}

.game_area_description {
  color: white;
}

#text{
  color: white;
}

body{
  color: white !important;
}

.game_area_description #game_area_description{
   color: white;
}

.bb_tag{
  margin-top:30px;
}
* >>> img, video{
  width:100%;
}
* >>>{
  color:white;
}
</style>
