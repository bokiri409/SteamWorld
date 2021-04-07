<template>
 <section class="section-show">
   <div class="container">
      <div style="background-color: none">
            <b-card title="Card Title" no-body>
              <b-card-header header-tag="nav" style="background-color: none">
                <b-nav card-header tabs>
                  <!-- <b-nav-item>'s with child routes. Note the trailing slash on the first <b-nav-item> -->
                  <b-nav-item
                    @click.prevent="loadPopular()"
                    exact
                    exact-active-class="active"
                    style=""
                    >인기 게임</b-nav-item
                  >
                  <b-nav-item @click.prevent="loadRecommendGame()" exact exact-active-class="active"
                    >게임 추천</b-nav-item
                  >
                  <!-- <b-nav-item @click.prevent="loadLikeGame()">관심 게임</b-nav-item> -->
                </b-nav>
              </b-card-header>

              <b-card-body justify-content style="background-color: none">
                <div id="recommend-contents">
                  <component :is="componentLoading()"></component>
                </div>
              </b-card-body>
            </b-card>
          </div>
    </div>
 </section>
</template>
<script>
export default {
    
}
</script>