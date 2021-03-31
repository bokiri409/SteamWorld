<template>

<div class="container blueArea">
    <div clss="row">

        <h2 class="typing-txt">Q1. 적들이 마구 몰려오는 상황, 당신은 어떻게 하시겠습니까? </h2>
        <p>와아오아아아아아아아</p>
        <img src="../../assets/img/bg2.gif"/>
        <hr>



        <b-button>맞서 싸운다 </b-button>
          <router-link to="/survey" class="nav-link"><b-button>일단 안전을 확보한다 </b-button></router-link>




</div>
</div>
</template>

<style scoped>

h2.typing-txt{
  position:relative;
  display: inline-block;
  height: 40px; overflow: hidden;
  animation: typingAni 4s steps(30, end) 1;
}

h2.typing-txt::after{
    position:absolute; 
  display:block;
  content:""; 
  width: 5px; 
  height: 30px;
  top : 5px;
  right:0px; 
  border-right: 3px solid rgb(252, 252, 252);
  animation: cursor 0.5s step-end infinite;
}
@keyframes typingAni {
  0%{width:0%}
  100%{width: 80%};
}
@keyframes cursor{
  0%{opacity:0;}
  50%{opacity:1;}
  100%{opacity:0;}
}
</style>

