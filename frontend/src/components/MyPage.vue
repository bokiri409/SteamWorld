<template>
  <div>
    <b-button class="btn btn-lg">안녕</b-button>
    <div class="row"></div>
    <div class="row" style="width:100%">
      <div class="col-md-1"></div>
      <div class="col-md-10 box" style="background-color:#00000077;">
        <div class="section-title">
          <h2>마이페이지</h2>
          <p>My Page</p>
        </div>

        <h1 class="text-center" style="align:center;">ㅁㅁㅁ님의 마이페이지</h1>

        <br />

        <div class="row">
          <div class="col-md-4">
            <b-avatar
              size="8rem"
              variant="success"
              icon="people-fill"
              
            ></b-avatar>
          </div>
          <div class="col-md-8" style="background-color:blue">
            <div class="section-title">
              <h2>닉네임</h2>
            </div>
            <h3>가락동겜돌이</h3>
            <br />
            <div class="section-title">
              <h2>이메일</h2>
            </div>
            <h3>steamworld@hello.world</h3>
            <b-button class="btn-lg" @click="getUser">스팀 연동하기</b-button>
            <b-button class="btn-lg">프로필 수정</b-button>
          </div>
        </div>


        <div>
  <b-card title="Card Title" no-body>
    <b-card-header header-tag="nav">
      <b-nav card-header tabs>
        <!-- <b-nav-item>'s with child routes. Note the trailing slash on the first <b-nav-item> -->
        <b-nav-item to="/some/route/" exact exact-active-class="active">프로필 상세</b-nav-item>
        <b-nav-item to="/mypage/mygame" exact exact-active-class="active">보유 게임</b-nav-item>
        <b-nav-item to="/some/route/bar" exact exact-active-class="active">추천 게임</b-nav-item>
      </b-nav>
    </b-card-header>

    <b-card-body>
      <!-- Child route gets rendered in <router-view> or <nuxt-child> -->
      <router-view></router-view>
      <!-- Or if using Nuxt.js
      <nuxt-child></nuxt-child>
      -->
    </b-card-body>
  </b-card>
</div>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      slide: 0,
      sliding: null,
    };
  },
  methods: {
    onSlideStart(slide) {
      this.sliding = true;
    },
    onSlideEnd(slide) {
      this.sliding = false;
    },
    getUSer() {},
  },
};
</script>
