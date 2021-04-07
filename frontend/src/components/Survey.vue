<template>
  <section class="section-show" style="margin-bottom:100px">
    <div class="row">
      <div class="col-md-1"></div>
      <div class="col-md-10 box" style="background-color:#00000099; padding-top:20px">
        <div class="section-title">
          <h2>Portfolio</h2>
          <p>나의 게임 성향 찾기</p>
          <div class="row">
          <img height=300px src="../assets/img/q1.gif" />
          <h5>시작 버튼을 누르면 테스트를 시작합니다.</h5>

          </div>
        </div>


        <div id="surveyBtn" style="background-color:#226600;  border-radius:20px; width:500px; margin-bottom:100px">
          <router-link
            to="/q1"
            style="color:white; text-align:center;"
            class="nav-link"

            href="#about"
            >내게 맞는 게임 찾기 시작!</router-link
          >
        </div>

        <router-view> </router-view>
      </div>
    </div>
  </section>
</template>

<script></script>
