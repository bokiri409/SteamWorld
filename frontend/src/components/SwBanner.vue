<template>
  <div>
    <!-- ======= Header ======= -->
    <!--
    <b-navbar  v-if="show" toggleable="lg" type="dark" style="margin-top:0px; background-color:#00000099; ">
    <b-navbar-brand href="/" style="color:white; font-size:30px; font-weight:bold">Steam World!</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>

      <b-navbar-nav class="ml-auto">


         <b-navbar-nav right>        
          <router-link to="/" class="nav-link active" href="#header" @click="show=!show">Home</router-link>
          <router-link to="/survey" class="nav-link" href="#about" @click="toggle">내게 맞는 게임 찾기</router-link>
          <router-link to="/mypage" class="nav-link" href="#services" @click="toggle">마이 페이지</router-link>
          <router-link to="/recommend" class="nav-link" href="#portfolio" @click="toggle">게임 추천</router-link>
          <router-link to="/user/login" class="nav-link" href="#services" @click="toggle">로그인</router-link>

           <router-link to="/swiper" class="nav-link" href="#services" @click="toggle">스와이퍼</router-link>
           <span><a href="#" class=""><img src="../assets/img/steam.svg"></a>스팀 연동하기</span>
         
        
        </b-navbar-nav>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar> -->

    <!-- <transition name="slide" mode="out-in"> -->
    <!-- <router-view></router-view> -->
    <!-- </transition> -->

    <transition>
      <header id="header">
        <div class="container">
          <h1>Steam World!</h1>
          <!-- Uncomment below if you prefer to use an image logo -->
          <!-- <a href="index.html" class="mr-auto"><img src="../assets/img/logo.png" alt="" class="img-fluid"></a> -->
          <h2>세상에서 가장 <span>편리한</span> 게임 추천 서비스</h2>
          <!-- <i class="addBtn fas fa-plus" aria-hidden="true"></i> -->

          <nav id="navbarMain" class="navbarMain">
            <ul>
              <li @click="toggleBanner">
                <router-link to="/" class="nav-link active" href="#header"
                  >Home</router-link
                >
              </li>
              <li @click="clickHandler()">
                <router-link
                  to="/survey"
                  class="nav-link"
                  href="#about"
                  id="menu-game"
                  >내게 맞는 게임 찾기</router-link
                >
              </li>
              <li @click="clickHandler()">
                <router-link
                  to="/mypage"
                  class="nav-link"
                  href="#services"
                  id="menu-mypage"
                  >마이 페이지</router-link
                >
              </li>
              <li @click="clickHandler()">
                <router-link
                  to="/recommend"
                  class="nav-link"
                  href="#portfolio"
                  id="menu-recomm"
                  >게임 추천</router-link
                >
              </li>
              <li @click="clickHandler()">
                <router-link
                  to="/user/login"
                  class="nav-link"
                  href="#services"
                  id="menu-login"
                  >로그인</router-link
                >
              </li>
              <li @click="clickHandler2()">
                <router-link
                  to="/user/signup"
                  class="nav-link"
                  href="#signup"
                  id="menu-signup"
                  >회원가입</router-link
                >
              </li>
              <li @click="clickHandler()">
                <a href="#" class=""
                  ><img src="../assets/img/steam.svg" />스팀 연동하기</a
                >
              </li>
            </ul>
            <div class="social-links"></div>
          </nav>
          <!-- .navbar -->

          <div class="social-links">
            <a href="#" class="twitter"><b-icon-twitter></b-icon-twitter></a>

            <a href="#" class="facebook"
              ><img src="../assets/img/steam.svg"
            /></a>
            <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
            <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
          </div>
        </div>
      </header>
      <!-- End Banner -->
    </transition>
    <!-- <keep-alive> -->
    <router-view></router-view>
    <!-- </keep-alive> -->
  </div>
</template>

<script>
export default {
  name: 'SwBanner',
  data() {
    return {
      bannerShow: true,
      headerShow: true,
      show: true,
      lineshow: '',
    };
  },
  methods: {
    clickHandler: function() {
      // setTimeout(function() {
      const scrollto = () => {
        window.scrollTo({
          top: 0,
          behavior: 'smooth',
        });
      };
      const select = (el, all = false) => {
        el = el.trim();
        if (all) {
          return [...document.querySelectorAll(el)];
        } else {
          return document.querySelector(el);
        }
      };
      var header = select('#header');
      if (!header.classList.contains('header-top')) {
        header.classList.add('header-top');
      }

      var greenline = select('.nav-link');
      if (!this.lineshow === '') {
        greenline.classList.add('active');
      } else {
        greenline.contains.remove('active');
      }
      //var menu = select('#menu-login');
      var menu = select('.nav-link');
      // console.log(menu.substring('#', -1));
      // console.log(menu.split('#'));
      console.log(menu);

      scrollto();
      // }, 0);
    },
    clickHandler2: function() {
      const scrollto = () => {
        window.scrollTo({
          top: 0,
          behavior: 'smooth',
        });
      };
      const select = (el, all = false) => {
        el = el.trim();
        if (all) {
          return [...document.querySelectorAll(el)];
        } else {
          return document.querySelector(el);
        }
      };
      var header = select('#header');
      if (!header.classList.contains('header-top')) {
        header.classList.add('header-top');
      }
      var menu = select('.nav-link');
      // console.log(menu.substring('#', -1));
      // console.log(menu.split('#'));
      console.log(menu);

      scrollto();
    },
    toggleBanner: function() {
      const select = (el, all = false) => {
        el = el.trim();
        if (all) {
          return [...document.querySelectorAll(el)];
        } else {
          return document.querySelector(el);
        }
      };
      console.log('home');
      var header = select('#header');
      header.classList.remove('header-top');
    },
  },
};
</script>

<style>
.slide-leave-active {
  transition: opacity 0.3s ease;
  opacity: 0;
  animation: slide-out 0.3s ease-out forwards;
}

.slide-leave {
  opacity: 1;
  transform: translateX(0);
}

.slide-enter-active {
  animation: slide-in 1s ease-out forwards;
}

@keyframes slide-out {
  0% {
    transform: translateY(0);
  }
  100% {
    transform: translateY(-10px);
  }
}

@keyframes slide-in {
  0% {
    transform: translateY(-10px);
  }
  100% {
    transform: translateY(0);
  }
}
v-enter-active,
v-leave-active {
  transition: 0.5s;
}

v-enter,
v-leave-to {
  opacity: 0;
  transform: translateY(100px);
}
</style>
