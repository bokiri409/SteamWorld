<template>

<div class="container blueArea">
    <div clss="row">

        <h2 class="typing-txt">Q9. 게임을 하던 도중 너무 어려운 부분을 해결하지 못할 때 나는 </h2>
        <hr>
        <img height=300px  src="../../assets/img/q9.gif"/>
        <hr>



        <router-link to="/q10" class="nav-link"><b-button @click="put1">인터넷에 검색해서 공략을 본다s</b-button></router-link>
        <router-link to="/q10" class="nav-link"><b-button @click="put2">아직 시도해보지 않은 새로운 방법을 시도한다n</b-button></router-link>




</div>
</div>
</template>
<script>


export default {

  methods:{

    put1(){
           this.$store.commit('slice',8);
      this.$store.commit('putS');


    },
    put2(){
           this.$store.commit('slice',8);
     this.$store.commit('putN');
    }

  }
}
</script>
<style scoped>

h2.typing-txt{
  position:relative;
  display: inline-block;
  height: 40px; overflow: hidden;
  animation: typingAni 2s steps(15, end) 1;
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

