<template>
    <div>

        
        <b-button class="btn btn-lg">안녕</b-button>
        <div class="row">
            
        </div>
        <div class="row" style="width:100%">
            
            <div class="col-md-1"></div>
            <div class="col-md-10 box" style="background-color:#00000077;">
                      <div class="section-title">
        <h2>마이페이지</h2>
        <p>My Page</p>
      </div>
                <h1 class="text-center" style="align:center;">ㅁㅁㅁ님의 마이페이지</h1>
                <rect width="100%" height="100%" fill="#fff"></rect>
                    <b-avatar size="8rem" variant="success" icon="people-fill"></b-avatar>
                    <b-button class="btn-lg">스팀 연동하기</b-button>
                        <h3>닉네임:블라블라</h3>
                        <h3>이메일:헬로월드 네이버</h3>

                <div class="box" style="background-color:#00337777; border-radius:30px; height:500px">
                    <h3 class="text-center" style="align:center;">보유 게임 목록</h3>


                     <div>
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333;"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
      <!-- Text slides with image -->
      <b-carousel-slide
        caption="First slide"
        text="Nulla vitae elit libero, a pharetra augue mollis interdum."
        img-src="https://picsum.photos/1024/480/?image=52"
      ></b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=54">
        <h1>Hello world!</h1>
      </b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=58"></b-carousel-slide>

      <!-- Slides with img slot -->
      <!-- Note the classes .d-block and .img-fluid to prevent browser default image alignment -->
      <b-carousel-slide>
        <template #img>
          <img
            class="d-block img-fluid w-100"
            width="1024"
            height="480"
            src="https://picsum.photos/1024/480/?image=55"
            alt="image slot"
          >
        </template>
      </b-carousel-slide>

      <!-- Slide with blank fluid image to maintain slide aspect ratio -->
      <b-carousel-slide caption="Blank Image" img-blank img-alt="Blank image">
        <p>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse eros felis, tincidunt
          a tincidunt eget, convallis vel est. Ut pellentesque ut lacus vel interdum.
        </p>
      </b-carousel-slide>
    </b-carousel>

    <p class="mt-4">
      Slide #: {{ slide }}<br>
      Sliding: {{ sliding }}
    </p>
  </div>




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
        sliding: null
      }
    },
    methods: {
      onSlideStart(slide) {
        this.sliding = true
      },
      onSlideEnd(slide) {
        this.sliding = false
      }
    }
  }
</script>
