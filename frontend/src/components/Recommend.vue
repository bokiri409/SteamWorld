<template>
    <div>
      <div class="row">
         <div class="col-md-1"></div>
            <div class="col-md-10 box" style="padding-left:50px; background-color:#000000cc;">

        

        <div class="section-title">
        <h2>Portfolio</h2>
        <p>게임 추천</p>
      </div>


      <div>


  <b-card
  v-b-modal.modal-1
    no-body
    style="max-width: 20rem; background-color:black; border-width:1px; border-color:white"
    img-src="https://cdn.cloudflare.steamstatic.com/steam/apps/477160/header.jpg"
    img-alt="Image"
    img-top
  >
    <b-card-body>
      <b-card-title>Card Title</b-card-title>
      <b-card-sub-title class="mb-2"><b-badge variant="primary">경쟁</b-badge>
      <b-badge variant="danger">멀티플레이</b-badge>
      <b-badge variant="success">파티플레이</b-badge></b-card-sub-title>
      <b-card-text>
        간단 설명간단 설명간단 설명간단 설명간단 설명간단 설명
      </b-card-text>
    </b-card-body>

    <b-card-body>
      <a href="https://store.steampowered.com/app/477160/Human_Fall_Flat/" class="card-link">상점 바로가기</a>
    </b-card-body>
  </b-card>
</div>

      <div class="row portfolio-container"  style="width:100%">
        <!--477160-->

          <b-card-group deck>

        <b-card v-b-modal.modal-1  bg-variant="dark" text-variant="white" class="col-lg-4 col-md-6 text-center" >
        
            <img src="https://cdn.cloudflare.steamstatic.com/steam/apps/477160/header.jpg" class="img-fluid">
           <!-- <video src="https://cdn.cloudflare.steamstatic.com/steam/apps/256821808/movie480_vp9.webm?t=1613037587" controls class="img-fluid" alt=""></video>-->
            <div class="portfolio-info">
              <h4>Human Fall Flat</h4>
              <p>경쟁, 파티, 멀티플레이!!</p>
              <div class="portfolio-links">
                <a href="assets/img/portfolio/portfolio-1.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="App 1"><i class="bx bx-plus"></i></a>
                <a href="portfolio-details.html" data-gallery="portfolioDetailsGallery" data-glightbox="type: external" class="portfolio-details-lightbox" title="Portfolio Details"><i class="bx bx-link"></i></a>
              </div>
            </div>

           <b-modal modal-tall id="modal-1" size="xl" title="Extra Large Modal">
             <h1>게임 상세보기</h1>
             <div class="row">
              <div class="col-md-8">
               <img src="https://cdn.cloudflare.steamstatic.com/steam/apps/477160/header.jpg" class="img-fluid" style="width:100%">
              </div>
              <div class="col-md-4">
                <h1>휴먼 폴 플랫</h1>
                <h2>dddd 파티플레이 경쟁</h2>
                

                
              </div>

              <div class="interests container">

      <div class="section-title">
        <h2>Interests</h2>
      </div>

      <div class="row">
        <div class="col-lg-3 col-md-4">
          <div class="icon-box">
            <i class="ri-store-line" style="color: #ffbb2c;"></i>
            <h3>Lorem Ipsum</h3>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 mt-4 mt-md-0">
          <div class="icon-box">
            <i class="ri-bar-chart-box-line" style="color: #5578ff;"></i>
            <h3>Dolor Sitema</h3>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 mt-4 mt-md-0">
          <div class="icon-box">
            <i class="ri-calendar-todo-line" style="color: #e80368;"></i>
            <h3>Sed perspiciatis</h3>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 mt-4 mt-lg-0">
          <div class="icon-box">
            <i class="ri-paint-brush-line" style="color: #e361ff;"></i>
            <h3>Magni Dolores</h3>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 mt-4">
          <div class="icon-box">
            <i class="ri-database-2-line" style="color: #47aeff;"></i>
            <h3>Nemo Enim</h3>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 mt-4">
          <div class="icon-box">
            <i class="ri-gradienter-line" style="color: #ffa76e;"></i>
            <h3>Eiusmod Tempor</h3>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 mt-4">
          <div class="icon-box">
            <i class="ri-file-list-3-line" style="color: #11dbcf;"></i>
            <h3>Midela Teren</h3>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 mt-4">
          <div class="icon-box">
            <i class="ri-price-tag-2-line" style="color: #4233ff;"></i>
            <h3>Pira Neve</h3>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 mt-4">
          <div class="icon-box">
            <i class="ri-anchor-line" style="color: #b2904f;"></i>
            <h3>Dirada Pack</h3>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 mt-4">
          <div class="icon-box">
            <i class="ri-disc-line" style="color: #b20969;"></i>
            <h3>Moton Ideal</h3>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 mt-4">
          <div class="icon-box">
            <i class="bi-base-station-line" style="color: #ff5828;"></i>
            <h3>Verdo Park</h3>
          </div>
        </div>
        <div class="col-lg-3 col-md-4 mt-4">
          <div class="icon-box">
            <i class="ri-fingerprint-line" style="color: #29cc61;"></i>
            <h3>Flavor Nivelanda</h3>
          </div>
        </div>
      </div>

    </div>
    

    <div id="game_area_description" class="game_area_description">
							<h2>게임에 대해</h2>
							<img src="https://cdn.cloudflare.steamstatic.com/steam/apps/1097150/extras/About_This_Game_1.gif?t=1617013849"><br><br>Fall Guys: Ultimate Knockout는 한 명의 승자가 나올 때까지 혼란스러운 라운드를 이어가는 정신 나간 60인 멀티플레이 파티 게임입니다. 기괴한 장애물과 싸우고, 무자비한 경쟁자를 쓰러뜨리고, 대단한 물리 엔진을 극복하세요. 품위는 내던지고 승자의 왕관을 위해 우스꽝스러운 실패에 대비하세요!<br><br><br><img src="https://cdn.cloudflare.steamstatic.com/steam/apps/1097150/extras/Massive_Online_Pandemonium_1.gif?t=1617013849"><br>거대한 온라인 수라장: 다른 온라인 경쟁자들과 함께 우스꽝스러운 도전과 거친 장애물 코스에 빠져보세요.<br><br><br><br><img src="https://cdn.cloudflare.steamstatic.com/steam/apps/1097150/extras/Competitive_Coopertative_1.gif?t=1617013849"><br>경쟁 &amp; 협력: 패배하는 팀이 모두 제거되는 경쟁적인 도전과 난투전 사이를 오고 가세요!!<br><br><br><br><img src="https://cdn.cloudflare.steamstatic.com/steam/apps/1097150/extras/Comically_Physical.gif?t=1617013849"><br>웃긴 물리 엔진: 경쟁자들이 우스꽝스러운 모습으로 실패하고, 튀고, 부딪히는 걸 즐겁게 지켜보세요!<br><br><br><br><img src="https://cdn.cloudflare.steamstatic.com/steam/apps/1097150/extras/Delightfully_Customizable.gif?t=1617013849"><br>유쾌한 커스터마이징: 세련된 파인애플 쿠튀르부터 최신 토끼모자까지. Fall Guys에는 다양한 디자인을 커스터마이징할 수 있습니다.						</div>
             </div>

  
            
           </b-modal>
        </b-card>


        
        <b-card  bg-variant="dark" text-variant="white" class="col-lg-4 col-md-6 text-center" >
          <div v-b-modal.modal-1  >
            <img src="https://cdn.cloudflare.steamstatic.com/steam/apps/477160/header.jpg" class="img-fluid">
           <!-- <video src="https://cdn.cloudflare.steamstatic.com/steam/apps/256821808/movie480_vp9.webm?t=1613037587" controls class="img-fluid" alt=""></video>-->
            <div class="portfolio-info">
              <h4>Human Fall Flat</h4>
              <p>경쟁, 파티, 멀티플레이</p>
              <div class="portfolio-links">
                <a href="assets/img/portfolio/portfolio-1.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="App 1"><i class="bx bx-plus"></i></a>
                <a href="portfolio-details.html" data-gallery="portfolioDetailsGallery" data-glightbox="type: external" class="portfolio-details-lightbox" title="Portfolio Details"><i class="bx bx-link"></i></a>
                
              
              
              </div>
            </div>
          </div>
        </b-card>

                
        <b-card  bg-variant="dark" text-variant="white" class="col-lg-4 col-md-6 text-center" >
          <div v-b-modal.modal-1  >
            <img src="https://cdn.cloudflare.steamstatic.com/steam/apps/477160/header.jpg" class="img-fluid">
           <!-- <video src="https://cdn.cloudflare.steamstatic.com/steam/apps/256821808/movie480_vp9.webm?t=1613037587" controls class="img-fluid" alt=""></video>-->
            <div class="portfolio-info">
              <h4>Human Fall Flat</h4>
              <p>경쟁, 파티, 멀티플레이</p>
              <div class="portfolio-links">
                <a href="assets/img/portfolio/portfolio-1.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="App 1"><i class="bx bx-plus"></i></a>
                <a href="portfolio-details.html" data-gallery="portfolioDetailsGallery" data-glightbox="type: external" class="portfolio-details-lightbox" title="Portfolio Details"><i class="bx bx-link"></i></a>
              </div>
            </div>
          </div>
        </b-card>

                
        <b-card  bg-variant="dark" text-variant="white" class="col-lg-4 col-md-6 text-center" >
          <div v-b-modal.modal-1  >
            <img src="https://cdn.cloudflare.steamstatic.com/steam/apps/477160/header.jpg" class="img-fluid">
           <!-- <video src="https://cdn.cloudflare.steamstatic.com/steam/apps/256821808/movie480_vp9.webm?t=1613037587" controls class="img-fluid" alt=""></video>-->
            <div class="portfolio-info">
              <h4>Human Fall Flat</h4>
              <p>경쟁, 파티, 멀티플레이</p>
              <div class="portfolio-links">
                <a href="assets/img/portfolio/portfolio-1.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="App 1"><i class="bx bx-plus"></i></a>
             
              </div>
            </div>
          </div>
        </b-card>
        

          </b-card-group>

        <div class="col-lg-4 col-md-6 portfolio-item filter-web">
          <div class="portfolio-wrap">
            <img src="../assets/img/portfolio/portfolio-2.jpg" alt="">
            <div class="portfolio-info">
              <h4>Web 3</h4>
              <p>Web</p>
              <div class="portfolio-links">
                <a href="assets/img/portfolio/portfolio-2.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Web 3"><i class="bx bx-plus"></i></a>
                <a href="portfolio-details.html" data-gallery="portfolioDetailsGallery" data-glightbox="type: external" class="portfolio-details-lightbox" title="Portfolio Details"><i class="bx bx-link"></i></a>
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-item filter-app">
          <div class="portfolio-wrap">
            <img src="../assets/img/portfolio/portfolio-3.jpg" class="img-fluid" alt="">
            <div class="portfolio-info">
              <h4>App 2</h4>
              <p>App</p>
              <div class="portfolio-links">
                <a href="assets/img/portfolio/portfolio-3.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="App 2"><i class="bx bx-plus"></i></a>
                <a href="portfolio-details.html" data-gallery="portfolioDetailsGallery" data-glightbox="type: external" class="portfolio-details-lightbox" title="Portfolio Details"><i class="bx bx-link"></i></a>
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-item filter-card">
          <div class="portfolio-wrap">
            <img src="../assets/img/portfolio/portfolio-4.jpg" class="img-fluid" alt="">
            <div class="portfolio-info">
              <h4>Card 2</h4>
              <p>Card</p>
              <div class="portfolio-links">
                <a href="assets/img/portfolio/portfolio-4.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Card 2"><i class="bx bx-plus"></i></a>
                <a href="portfolio-details.html" data-gallery="portfolioDetailsGallery" data-glightbox="type: external" class="portfolio-details-lightbox" title="Portfolio Details"><i class="bx bx-link"></i></a>
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-item filter-web">
          <div class="portfolio-wrap">
            <img src="../assets/img/portfolio/portfolio-5.jpg" class="img-fluid" alt="">
            <div class="portfolio-info">
              <h4>Web 2</h4>
              <p>Web</p>
              <div class="portfolio-links">
                <a href="assets/img/portfolio/portfolio-5.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Web 2"><i class="bx bx-plus"></i></a>
                <a href="portfolio-details.html" data-gallery="portfolioDetailsGallery" data-glightbox="type: external" class="portfolio-details-lightbox" title="Portfolio Details"><i class="bx bx-link"></i></a>
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-item filter-app">
          <div class="portfolio-wrap">
            <img src="../assets/img/portfolio/portfolio-6.jpg" class="img-fluid" alt="">
            <div class="portfolio-info">
              <h4>App 3</h4>
              <p>App</p>
              <div class="portfolio-links">
                <a href="assets/img/portfolio/portfolio-6.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="App 3"><i class="bx bx-plus"></i></a>
                <a href="portfolio-details.html" data-gallery="portfolioDetailsGallery" data-glightbox="type: external" class="portfolio-details-lightbox" title="Portfolio Details"><i class="bx bx-link"></i></a>
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-item filter-card">
          <div class="portfolio-wrap">
            <img src="../assets/img/portfolio/portfolio-7.jpg" class="img-fluid" alt="">
            <div class="portfolio-info">
              <h4>Card 1</h4>
              <p>Card</p>
              <div class="portfolio-links">
                <a href="assets/img/portfolio/portfolio-7.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Card 1"><i class="bx bx-plus"></i></a>
                <a href="portfolio-details.html" data-gallery="portfolioDetailsGallery" data-glightbox="type: external" class="portfolio-details-lightbox" title="Portfolio Details"><i class="bx bx-link"></i></a>
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-item filter-card">
          <div class="portfolio-wrap">
            <img src="../assets/img/portfolio/portfolio-8.jpg" class="img-fluid" alt="">
            <div class="portfolio-info">
              <h4>Card 3</h4>
              <p>Card</p>
              <div class="portfolio-links">
                <a href="assets/img/portfolio/portfolio-8.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Card 3"><i class="bx bx-plus"></i></a>
                <a href="portfolio-details.html" data-gallery="portfolioDetailsGallery" data-glightbox="type: external" class="portfolio-details-lightbox" title="Portfolio Details"><i class="bx bx-link"></i></a>
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-item filter-web">
          <div class="portfolio-wrap">
            <img src="../assets/img/portfolio/portfolio-9.jpg" class="img-fluid" alt="">
            <div class="portfolio-info">
              <h4>Web 3</h4>
              <p>Web</p>
              <div class="portfolio-links">
                <a href="assets/img/portfolio/portfolio-9.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Web 3"><i class="bx bx-plus"></i></a>
                <a href="portfolio-details.html" data-gallery="portfolioDetailsGallery" data-glightbox="type: external" class="portfolio-details-lightbox" title="Portfolio Details"><i class="bx bx-link"></i></a>
              </div>
            </div>
          </div>
        </div>

      </div>
            </div>

            </div>

    </div>

</template>
<script>


 export default {
 
        components : {

            
        },
 
        mounted() {
            console.log('Component mounted.')
        }

 }
</script>

<!--  <script src="../assets/js/main.js"></script>-->
<style scoped>
.card-body{
  padding:0px;
}
card{
  margin-left:20px;
  margin-right:20px;
  border-bottom-color: red;
  background-color:#000000;
}

.modal-content h1{
  color:#000000;
}

.modal-content h2{
  color:#000000;
}
</style>


