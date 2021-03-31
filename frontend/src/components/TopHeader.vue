<template>
    <div>
    <b-navbar  toggleable="lg" type="dark" style="margin-top:0px; background-color:#00000099; ">
    <b-navbar-brand href="#" style="color:white; font-size:30px; font-weight:bold">Steam World!</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">


         <b-navbar-nav right>        
          <router-link to="/" class="nav-link active" href="#header">Home</router-link>
          <router-link to="/survey" class="nav-link" href="#about">내게 맞는 게임 찾기</router-link>
          <router-link to="/mypage" class="nav-link" href="#services">마이 페이지</router-link>
          <router-link to="/recommend" class="nav-link" href="#portfolio">게임 추천</router-link>
          <router-link to="/user/login" class="nav-link" href="#services">로그인</router-link>

           <router-link to="/swiper" class="nav-link" href="#services">스와이퍼</router-link>
           <span><a href="#" class=""><img src="../assets/img/steam.svg"></a>스팀 연동하기</span>
         
        
        </b-navbar-nav>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
  </div>
</template>

<script>

 export default {
    name: 'TopHeader',
    data () {
      
      return{
      bannerShow: true,
      headerShow: true,
      show: true
    }

  
    },
    methods: {
      toggle(){
        this.headerShow=true;
        this.bannerShow=false;
      },
      toggleBanner(){
        this.bannerShow=true;
        this.headerShow=false;
      }
   
    }
  }


