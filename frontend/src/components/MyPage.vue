<template>
  <div>
    <div class="row"></div>
    <div class="row" style="width:100%">
      <div class="col-md-1"></div>
      <div class="col-md-10 box" style="background-color:#00000077;">
        <div class="section-title">
          <h2>마이페이지</h2>
          <p>My Page</p>


        

        <h1 class="text-center typing-txt" style="align:center;">
          ㅁㅁㅁ님의 마이페이지
          
        </h1>

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
            value="http://localhost:8083"
          />
          <input
            type="hidden"
            name="openid.return_to"
            value="http://localhost:8083/mypage"
          />
          <button type="submit">Log in through Steam</button>
        </form>
        <br/>

        <div class="row">
          <div class="col-md-4">
            <b-avatar
              size="8rem"
              variant="success"
              icon="people-fill"
            ></b-avatar>
          </div>
          <div class="col-md-8" style="">
            <div class="section-title">
              <h2>닉네임</h2>
            </div>
            <h3>가락동겜돌이</h3>
            <br />
            <div class="section-title">
              <h2>이메일</h2>
            </div>
            <h3>steamworld@hello.world</h3>
            <b-button class="btn-lg">스팀 연동하기</b-button>
            <b-button class="btn-lg">프로필 수정</b-button>
            <b-icon icon="exclamation-circle-fill" variant="danger"></b-icon>
          </div>
        </div>

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
                <p>Hours Of Support</p>
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
                <p>Awards</p>
              </div>
            </div>
          </div>
        </div>

        <div>
          <b-card title="Card Title" no-body>
            <b-card-header header-tag="nav">
              <b-nav card-header tabs>
                <!-- <b-nav-item>'s with child routes. Note the trailing slash on the first <b-nav-item> -->
                <b-nav-item
                  @click.prevent="loadUpdate()"
                  exact
                  exact-active-class="active"
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

            <b-card-body justify-content>
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

        <!-- 임시로 해주는 구간 -->

        <h3>Jena Karlis</h3>

        <div class="testimonials container">

      <div class="section-title">
        <h2>Testimonials</h2>
      </div>

      <div class="testimonials-slider swiper-container swiper-container-initialized swiper-container-horizontal swiper-container-pointer-events" data-aos="fade-up" data-aos-delay="100">
        <div class="swiper-wrapper" id="swiper-wrapper-46d2a11b91e9d2b2" aria-live="off" style="transform: translate3d(-2000px, 0px, 0px); transition-duration: 600ms;"><div class="swiper-slide swiper-slide-duplicate swiper-slide-duplicate-next" role="group" aria-label="8 / 11" data-swiper-slide-index="4" style="width: 480px; margin-right: 20px;">
            <div class="testimonial-item">
              <p>
                <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                Quis quorum aliqua sint quem legam fore sunt eram irure aliqua veniam tempor noster veniam enim culpa labore duis sunt culpa nulla illum cillum fugiat legam esse veniam culpa fore nisi cillum quid.
                <i class="bx bxs-quote-alt-right quote-icon-right"></i>
              </p>
              <img src="assets/img/testimonials/testimonials-5.jpg" class="testimonial-img" alt="">
              <h3>John Larson</h3>
              <h4>Entrepreneur</h4>
            </div>
          </div>

          <div class="swiper-slide" role="group" aria-label="4 / 11" data-swiper-slide-index="0" style="width: 480px; margin-right: 20px;">
            <div class="testimonial-item">
              <p>
                <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                Proin iaculis purus consequat sem cure digni ssim donec porttitora entum suscipit rhoncus. Accusantium quam, ultricies eget id, aliquam eget nibh et. Maecen aliquam, risus at semper.
                <i class="bx bxs-quote-alt-right quote-icon-right"></i>
              </p>
              <img src="assets/img/testimonials/testimonials-1.jpg" class="testimonial-img" alt="">
              <h3>Saul Goodman</h3>
              <h4>Ceo &amp; Founder</h4>
            </div>
          </div><!-- End testimonial item -->

          <div class="swiper-slide" role="group" aria-label="5 / 11" data-swiper-slide-index="1" style="width: 480px; margin-right: 20px;">
            <div class="testimonial-item">
              <p>
                <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                Export tempor illum tamen malis malis eram quae irure esse labore quem cillum quid cillum eram malis quorum velit fore eram velit sunt aliqua noster fugiat irure amet legam anim culpa.
                <i class="bx bxs-quote-alt-right quote-icon-right"></i>
              </p>
              <img src="assets/img/testimonials/testimonials-2.jpg" class="testimonial-img" alt="">
              <h3>Sara Wilsson</h3>
              <h4>Designer</h4>
            </div>
          </div><!-- End testimonial item -->

          <div class="swiper-slide swiper-slide-prev" role="group" aria-label="6 / 11" data-swiper-slide-index="2" style="width: 480px; margin-right: 20px;">
            <div class="testimonial-item">
              <p>
                <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                Enim nisi quem export duis labore cillum quae magna enim sint quorum nulla quem veniam duis minim tempor labore quem eram duis noster aute amet eram fore quis sint minim.
                <i class="bx bxs-quote-alt-right quote-icon-right"></i>
              </p>
              <img src="assets/img/testimonials/testimonials-3.jpg" class="testimonial-img" alt="">
              <h3>Jena Karlis</h3>
              <h4>Store Owner</h4>
            </div>
          </div><!-- End testimonial item -->

          <div class="swiper-slide swiper-slide-active" role="group" aria-label="7 / 11" data-swiper-slide-index="3" style="width: 480px; margin-right: 20px;">
            <div class="testimonial-item">
              <p>
                <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                Fugiat enim eram quae cillum dolore dolor amet nulla culpa multos export minim fugiat minim velit minim dolor enim duis veniam ipsum anim magna sunt elit fore quem dolore labore illum veniam.
                <i class="bx bxs-quote-alt-right quote-icon-right"></i>
              </p>
              <img src="assets/img/testimonials/testimonials-4.jpg" class="testimonial-img" alt="">
              <h3>Matt Brandon</h3>
              <h4>Freelancer</h4>
            </div>
          </div><!-- End testimonial item -->

          <div class="swiper-slide swiper-slide-next" role="group" aria-label="8 / 11" data-swiper-slide-index="4" style="width: 480px; margin-right: 20px;">
            <div class="testimonial-item">
              <p>
                <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                Quis quorum aliqua sint quem legam fore sunt eram irure aliqua veniam tempor noster veniam enim culpa labore duis sunt culpa nulla illum cillum fugiat legam esse veniam culpa fore nisi cillum quid.
                <i class="bx bxs-quote-alt-right quote-icon-right"></i>
              </p>
              <img src="assets/img/testimonials/testimonials-5.jpg" class="testimonial-img" alt="">
              <h3>John Larson</h3>
              <h4>Entrepreneur</h4>
            </div>
          </div><!-- End testimonial item -->

        <div class="swiper-slide swiper-slide-duplicate" role="group" aria-label="4 / 11" data-swiper-slide-index="0" style="width: 480px; margin-right: 20px;">
            <div class="testimonial-item">
              <p>
                <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                Proin iaculis purus consequat sem cure digni ssim donec porttitora entum suscipit rhoncus. Accusantium quam, ultricies eget id, aliquam eget nibh et. Maecen aliquam, risus at semper.
                <i class="bx bxs-quote-alt-right quote-icon-right"></i>
              </p>
              <img src="assets/img/testimonials/testimonials-1.jpg" class="testimonial-img" alt="">
              <h3>Saul Goodman</h3>
              <h4>Ceo &amp; Founder</h4>
            </div>
          </div></div>
        <div class="swiper-pagination swiper-pagination-clickable swiper-pagination-bullets"><span class="swiper-pagination-bullet" tabindex="0" role="button" aria-label="Go to slide 1"></span><span class="swiper-pagination-bullet" tabindex="0" role="button" aria-label="Go to slide 2"></span><span class="swiper-pagination-bullet" tabindex="0" role="button" aria-label="Go to slide 3"></span><span class="swiper-pagination-bullet swiper-pagination-bullet-active" tabindex="0" role="button" aria-label="Go to slide 4"></span><span class="swiper-pagination-bullet" tabindex="0" role="button" aria-label="Go to slide 5"></span></div>
      <span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span></div>

      <div class="owl-carousel testimonials-carousel">

      </div>

    </div>

        

        <!-- 임시로 해주는 구간 -->
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import UpdateUser from "./myPage/UpdateUser";
import MyGame from "./myPage/MyGame";
import RecGame from "./myPage/RecGame";

export default {
  data() {
    return {
      user: {
        email: "",
        nickname: "",
        picture: "",
        region: "",
        phone: "",
      },
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
</style>
