<template>
  <div style="margin-bottom:100px">
    <div class="row">
      <div class="col-md-1"></div>
      <div class="col-md-10 box" style="background-color:#00000099;">
        <div class="section-title">
          <h2>Portfolio</h2>
          <p>인생 게임 찾기</p>
          <img src="../assets/img/q1.gif" />
        </div>
        <h1>게임 추천 컴포넌트</h1>

        <div id="surveyBtn" style="background-color:#226600;  width:300px;">
          <router-link
            to="/q1"
            style="color:white;"
            class="nav-link"
            href="#about"
            >내게 맞는 게임 찾기</router-link
          >
        </div>

        <router-view> </router-view>
      </div>
    </div>
  </div>
</template>

<script></script>
