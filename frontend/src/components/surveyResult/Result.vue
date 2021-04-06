<template>
  <div class="container blueArea">
    <h1>당신의 인생게임은...</h1>
    <img src="../../assets/img/human.png" />

    <p>{{ this.$store.state.result }}입니다.</p>
    <button @click="showA">결과 확인하기</button>
    <button @click="getGameInfo(1046930)">게임 받아와라</button>
    <p>{{gameData}}</p>

    <h1>{{ this.result }}</h1>
    <router-link to="/result/detail">detail</router-link>
  </div>
</template>

<script>
import axios from "axios";
const SERVER_URL = process.env.VUE_APP_API_SERVER_URL;
export default {
  data() {
    return { result: "" };
  },
  methods: {
    showA() {
      this.e = 0;
      this.i = 0;
      this.n = 0;
      this.s = 0;
      this.t = 0;
      this.f = 0;
      this.j = 0;
      this.p = 0;
      this.result = "";
      this.answer = this.$store.state.result;
      for (this.step = 0; this.step < 12; this.step++) {
        if (this.answer[this.step] == "E") {
          this.e++;
        } else if (this.answer[this.step] == "I") {
          this.i++;
        } else if (this.answer[this.step] == "N") {
          this.n++;
        } else if (this.answer[this.step] == "S") {
          this.s++;
        } else if (this.answer[this.step] == "T") {
          this.t++;
        } else if (this.answer[this.step] == "F") {
          this.f++;
        } else if (this.answer[this.step] == "J") {
          this.j++;
        } else if (this.answer[this.step] == "P") {
          this.p++;
        }
      }
      if (this.e >= 2) {
        this.result += "E";
      } else {
        this.result += "I";
      }

      if (this.n >= 2) {
        this.result += "N";
      } else {
        this.result += "S";
      }

      if (this.t >= 2) {
        this.result += "T";
      } else {
        this.result += "F";
      }

      if (this.j >= 2) {
        this.result += "J";
      } else {
        this.result += "P";
      }

      this.$store.commit("putPage", this.result);
    },
    getGameInfo(appid) {
      axios
        .get(`${SERVER_URL}/game/info/search`, { params: { appid: appid } })
        .then((res) => {
          const gameData = res.data;
          if (gameData == null) {
            this.gameData =
              "https://images.unsplash.com/photo-1519400197429-404ae1a1e184?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=80";
          } else {
            this.gameData = gameData;
            console.log(gameData);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    searchGroup: function() {
      console.log("searchGroup");
      axios
        .get(`${SERVER_URL}/group/list/`, { params: this.params })
        .then((res) => {
          for (let i = 0; i < res.data.list.length; i++) {
            res.data.list[i].edate = res.data.list[i].edate.split(" ")[0];
          }
          this.groups = res.data.list;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getPicture(email) {
      axios
        .get(`${SERVER_URL}/user/profile`, { params: { email: email } })
        .then((res) => {
          const picture = res.data.User.picture;
          if (picture == null) {
            this.picture =
              "https://images.unsplash.com/photo-1519400197429-404ae1a1e184?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=80";
          } else {
            this.picture = picture;
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },

    goCreate: function() {
      // const data = [item]
      this.$router.push({ path: "./GroupCreate" });
    },
    goDetail: function(group) {
      this.$router.push({ path: "./GroupDetail", query: { gId: group.gId } });
    },
    goGroupPage: function(myGroup) {
      this.$router.push({ path: "./GroupPage", query: { gId: myGroup.gId } });
    },
    myGroupList: function() {
      axios
        .get(`${SERVER_URL}/group/member/apply/user/list`, {
          params: {
            email: this.loginStatus.email,
          },
        })
        .then((res) => {
          console.log(res);
          if (res.data.list.length != 0) {
            this.existMyGroups = true;
          }
          this.myGroups = res.data.list;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    groupList: function() {
      axios
        .get(`${SERVER_URL}/group/list/`, { params: this.params })
        .then((res) => {
          for (let i = 0; i < res.data.list.length; i++) {
            res.data.list[i].edate = res.data.list[i].edate.split(" ")[0];
          }
          this.groups = res.data.list;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    goLogIn: function() {
      this.$router.push({ path: "./login" });
    },
  },
};
</script>
