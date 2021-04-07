<template>

<div class="container blueArea">
    <div clss="row">

        <h2 class="typing-txt">Q1. 게임을 시작하자! 캐릭터를 선택할 때 나는 </h2>
                <hr>
        <img height=300px src="../../assets/img/q1.gif"/>
        <hr>



        <router-link to="/q2" class="nav-link"><b-button @click="put1">성능보다 내가 좋아하는 캐릭터를 고른다</b-button></router-link>
        <router-link to="/q2" class="nav-link"><b-button @click="put2">성능이 가장 좋은 캐릭터를 고른다</b-button></router-link>




</div>
</div>
</template>


<script>


export default {

  methods:{

    put1(){
           this.$store.commit('slice',0);
      this.$store.commit('putF');


    },
    put2(){
           this.$store.commit('slice',0);
     this.$store.commit('putT');
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

