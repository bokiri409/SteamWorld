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
    no-body
    style="max-width: 20rem; background-color:black; border-width:1px; border-color:white"
    img-src="https://placekitten.com/380/200"
    img-alt="Image"
    img-top
  >
    <template #header>
      <h4 class="mb-0">Hello World</h4>
    </template>

    <b-card-body>
      <b-card-title>Card Title</b-card-title>
      <b-card-sub-title class="mb-2">Card Sub Title</b-card-sub-title>
      <b-card-text>
        Some quick example text to build on the card title and make up the bulk of the card's
        content.
      </b-card-text>
    </b-card-body>

    <b-card-body>
      <a href="#" class="card-link">Card link</a>
      <a href="#" class="card-link">Another link</a>
    </b-card-body>

    <b-card-footer>This is a footer</b-card-footer>

    <b-card-img src="https://placekitten.com/480/210" alt="Image" bottom></b-card-img>
  </b-card>
</div>


      <div>
  <b-button v-b-modal.modal-1>Launch demo modal</b-button>

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


