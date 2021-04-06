<template>
  <section class="section-show">
    <div class="row" style="width:100%">
      <div class="col-md-1"></div>
      <div class="col-md-10 box" style="background-color:#00000077;">
        <div class="section-title">
          <h2>마이페이지</h2>
          <p>My Page</p>

          <h1 class=" typing-txt" style="margin-bottom:100px;">
            가락동겜돌이 님의 마이페이지
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
              <h3>가락동겜돌이</h3>
              <br />
              <div class="section-title">
                <h2>이메일</h2>
              </div>
              <h3>steamworld@hello.world</h3>
              <div class="section-title">
                <h2>스팀 아이디</h2>
              </div>
              <h3>{{sid}}</h3>
            </div>
          </div>

          <b-button class="btn-lg" style="border-radius: 10rem" @click="getUrl()">스팀 연동하기</b-button>

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
            <input
              type="hidden"
              name="openid.ns"
              value="http://specs.openid.net/auth/2.0"
            />
            <input type="hidden" name="openid.mode" value="checkid_setup" />
            <input
              type="hidden"
              name="openid.realm"
              value="http://localhost:8080"
            />
            <input
              type="hidden"
              name="openid.return_to"
              value="http://localhost:8080/mypage"
            />
            <b-button type="submit btn-large" style="border-radius: 10rem"><img src="../assets/img/steam.svg" class="steamlogo"/>스팀 로그인</b-button>
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
                  <b-nav-item
                    @click.prevent="loadMyGame()"
                    exact
                    exact-active-class="active"
                    >보유 게임</b-nav-item
                  >
                  <b-nav-item @click.prevent="loadRecGame()"
                    >추천 게임</b-nav-item
                  >
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

          <!-- 임시로 해주는 구간 -->

          <h3>Jena Karlis</h3>

          <div class="testimonials container">
            <div class="section-title">
              <h2>Testimonials</h2>
            </div>

            <div
              class="testimonials-slider swiper-container swiper-container-initialized swiper-container-horizontal swiper-container-pointer-events"
              data-aos="fade-up"
              data-aos-delay="100"
            >
              <div
                class="swiper-wrapper"
                id="swiper-wrapper-46d2a11b91e9d2b2"
                aria-live="off"
                style="transform: translate3d(-2000px, 0px, 0px); transition-duration: 600ms;"
              >
                <div
                  class="swiper-slide swiper-slide-duplicate swiper-slide-duplicate-next"
                  role="group"
                  aria-label="8 / 11"
                  data-swiper-slide-index="4"
                  style="width: 480px; margin-right: 20px;"
                >
                  <div class="testimonial-item">
                    <p>
                      <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                      Quis quorum aliqua sint quem legam fore sunt eram irure
                      aliqua veniam tempor noster veniam enim culpa labore duis
                      sunt culpa nulla illum cillum fugiat legam esse veniam
                      culpa fore nisi cillum quid.
                      <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                    </p>
                    <img
                      src="assets/img/testimonials/testimonials-5.jpg"
                      class="testimonial-img"
                      alt=""
                    />
                    <h3>John Larson</h3>
                    <h4>Entrepreneur</h4>
                  </div>
                </div>

                <div
                  class="swiper-slide"
                  role="group"
                  aria-label="4 / 11"
                  data-swiper-slide-index="0"
                  style="width: 480px; margin-right: 20px;"
                >
                  <div class="testimonial-item">
                    <p>
                      <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                      Proin iaculis purus consequat sem cure digni ssim donec
                      porttitora entum suscipit rhoncus. Accusantium quam,
                      ultricies eget id, aliquam eget nibh et. Maecen aliquam,
                      risus at semper.
                      <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                    </p>
                    <img
                      src="assets/img/testimonials/testimonials-1.jpg"
                      class="testimonial-img"
                      alt=""
                    />
                    <h3>Saul Goodman</h3>
                    <h4>Ceo &amp; Founder</h4>
                  </div>
                </div>
                <!-- End testimonial item -->

                <div
                  class="swiper-slide"
                  role="group"
                  aria-label="5 / 11"
                  data-swiper-slide-index="1"
                  style="width: 480px; margin-right: 20px;"
                >
                  <div class="testimonial-item">
                    <p>
                      <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                      Export tempor illum tamen malis malis eram quae irure esse
                      labore quem cillum quid cillum eram malis quorum velit
                      fore eram velit sunt aliqua noster fugiat irure amet legam
                      anim culpa.
                      <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                    </p>
                    <img
                      src="assets/img/testimonials/testimonials-2.jpg"
                      class="testimonial-img"
                      alt=""
                    />
                    <h3>Sara Wilsson</h3>
                    <h4>Designer</h4>
                  </div>
                </div>
                <!-- End testimonial item -->

                <div
                  class="swiper-slide swiper-slide-prev"
                  role="group"
                  aria-label="6 / 11"
                  data-swiper-slide-index="2"
                  style="width: 480px; margin-right: 20px;"
                >
                  <div class="testimonial-item">
                    <p>
                      <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                      Enim nisi quem export duis labore cillum quae magna enim
                      sint quorum nulla quem veniam duis minim tempor labore
                      quem eram duis noster aute amet eram fore quis sint minim.
                      <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                    </p>
                    <img
                      src="assets/img/testimonials/testimonials-3.jpg"
                      class="testimonial-img"
                      alt=""
                    />
                    <h3>Jena Karlis</h3>
                    <h4>Store Owner</h4>
                  </div>
                </div>
                <!-- End testimonial item -->

                <div
                  class="swiper-slide swiper-slide-active"
                  role="group"
                  aria-label="7 / 11"
                  data-swiper-slide-index="3"
                  style="width: 480px; margin-right: 20px;"
                >
                  <div class="testimonial-item">
                    <p>
                      <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                      Fugiat enim eram quae cillum dolore dolor amet nulla culpa
                      multos export minim fugiat minim velit minim dolor enim
                      duis veniam ipsum anim magna sunt elit fore quem dolore
                      labore illum veniam.
                      <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                    </p>
                    <img
                      src="assets/img/testimonials/testimonials-4.jpg"
                      class="testimonial-img"
                      alt=""
                    />
                    <h3>Matt Brandon</h3>
                    <h4>Freelancer</h4>
                  </div>
                </div>
                <!-- End testimonial item -->

                <div
                  class="swiper-slide swiper-slide-next"
                  role="group"
                  aria-label="8 / 11"
                  data-swiper-slide-index="4"
                  style="width: 480px; margin-right: 20px;"
                >
                  <div class="testimonial-item">
                    <p>
                      <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                      Quis quorum aliqua sint quem legam fore sunt eram irure
                      aliqua veniam tempor noster veniam enim culpa labore duis
                      sunt culpa nulla illum cillum fugiat legam esse veniam
                      culpa fore nisi cillum quid.
                      <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                    </p>
                    <img
                      src="assets/img/testimonials/testimonials-5.jpg"
                      class="testimonial-img"
                      alt=""
                    />
                    <h3>John Larson</h3>
                    <h4>Entrepreneur</h4>
                  </div>
                </div>
                <!-- End testimonial item -->

                <div
                  class="swiper-slide swiper-slide-duplicate"
                  role="group"
                  aria-label="4 / 11"
                  data-swiper-slide-index="0"
                  style="width: 480px; margin-right: 20px;"
                >
                  <div class="testimonial-item">
                    <p>
                      <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                      Proin iaculis purus consequat sem cure digni ssim donec
                      porttitora entum suscipit rhoncus. Accusantium quam,
                      ultricies eget id, aliquam eget nibh et. Maecen aliquam,
                      risus at semper.
                      <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                    </p>
                    <img
                      src="assets/img/testimonials/testimonials-1.jpg"
                      class="testimonial-img"
                      alt=""
                    />
                    <h3>Saul Goodman</h3>
                    <h4>Ceo &amp; Founder</h4>
                  </div>
                </div>
              </div>
              <div
                class="swiper-pagination swiper-pagination-clickable swiper-pagination-bullets"
              >
                <span
                  class="swiper-pagination-bullet"
                  tabindex="0"
                  role="button"
                  aria-label="Go to slide 1"
                ></span
                ><span
                  class="swiper-pagination-bullet"
                  tabindex="0"
                  role="button"
                  aria-label="Go to slide 2"
                ></span
                ><span
                  class="swiper-pagination-bullet"
                  tabindex="0"
                  role="button"
                  aria-label="Go to slide 3"
                ></span
                ><span
                  class="swiper-pagination-bullet swiper-pagination-bullet-active"
                  tabindex="0"
                  role="button"
                  aria-label="Go to slide 4"
                ></span
                ><span
                  class="swiper-pagination-bullet"
                  tabindex="0"
                  role="button"
                  aria-label="Go to slide 5"
                ></span>
              </div>
              <span
                class="swiper-notification"
                aria-live="assertive"
                aria-atomic="true"
              ></span>
            </div>

            <div class="owl-carousel testimonials-carousel"></div>
          </div>

          <!-- 임시로 해주는 구간 -->
        </div>
      </div>
    </div>
  </section>
</template>

<script src="../assets/js/crawl.js"></script>
<script>
// axios를 활용해 AJAX로 HTML 문서를 가져오는 함수 구현
async function getHTML() {
  try {
    return await axios.get("https://chaewonkong.github.io");
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
    const bodyList = $("ul.list--posts").children("li.item--post");

    // bodyList를 순회하며 titleList에 h2 > a의 내용을 저장
    bodyList.each(function(i, elem) {
      titleList[i] = {
        title: $(this)
          .find("h2 a")
          .text(),
      };
    });
    return titleList;
  })
  .then((res) => console.log(res)); // 저장된 결과를 출력
</script>
<script>
import UpdateUser from "./myPage/UpdateUser";
import MyGame from "./myPage/MyGame";
import RecGame from "./myPage/RecGame";

const axios = require("axios");
const cheerio = require("cheerio");

export default {
  data() {
    const axios = require("axios");
    const cheerio = require("cheerio");
    return {
      user: {
        email: "",
        nickname: "",
        picture: "",
        region: "",
        phone: "",
      },
      sid: "",
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
  methods: {
    onSlideStart(slide) {
      this.sliding = true;
    },
    onSlideEnd(slide) {
      this.sliding = false;
    },
    getUrl() {
      var link = document.location.href.split("&");
      console.log(link[3]);
      this.sid=link[3].slice(67,link[3].length);
      
    },

    componentLoading() {
      switch (this.active) {
        case 0:
          return "UpdateUser";
        case 1:
          return "MyGame";
        case 2:
          return "RecGame";
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
          "Content-Type": "application/x-www-form-urlencoded",
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,OPTIONS",
          "Access-Control-Allow-Headers":
            "Content-Type, Authorization, Content-Length, X-Requested-With",
        },
      };
      try {
        console.log(
          axios.get("https://cors-anywhere.herokuapp.com/" + url, optionAxios)
        );
        return axios
          .get("https://cors-anywhere.herokuapp.com/" + url, optionAxios)
          .then((html) => {
            let titleList = [];
            const $ = cheerio.load(html.data);
            // ul.list--posts를 찾고 그 children 노드를 bodyList에 저장
            const bodyList = $("ul.list--posts").children("li.item--post");
            console.log(bodyList);

            // bodyList를 순회하며 titleList에 h2 > a의 내용을 저장
            bodyList.each(function(i, elem) {
              titleList[i] = {
                title: $(this)
                  .find("h2 a")
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
          "Content-Type": "application/x-www-form-urlencoded",
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,OPTIONS",
          "Access-Control-Allow-Headers":
            "Content-Type, Authorization, Content-Length, X-Requested-With",
        },
      };
      axios
        .get("https://cors-anywhere.herokuapp.com/" + url, optionAxios)
        .then((response) => {
          var htmlText = response.data;

          let titleList = [];
          const $ = cheerio.load(htmlText);

          const bodyList = $("div.game_description_snippet");
          console.log("1" + bodyList);

          // bodyList를 순회하며 titleList에 h2 > a의 내용을 저장
          bodyList.each(function(i, elem) {
            titleList[i] = {
              title: $(this)
                .find("div")
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
  content: "";
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

.section-show{
  margin-top:40px;
}

.section-title{
  margin-top:20px;
}
</style>
