<template>

<div class="container blueArea">
    <div clss="row">

        <h2 class="typing-txt">Q10. 지도에 퀘스트와는 상관 없는 수상한 동굴이 보인다.</h2>
        <hr>
        <img height=300px  src="../../assets/img/q10.gif"/>
        <hr>



        <router-link to="/q11" class="nav-link"><b-button @click="put1">뭐가 있을까? 일단 들어가본다 s</b-button></router-link>
        <router-link to="/q11" class="nav-link"><b-button @click="put2">  퀘스트를 먼저 깨고나서 다시 와본다. n </b-button></router-link>




</div>
</div>
</template>
<script>


export default {

  methods:{

    put1(){
           this.$store.commit('slice',9);
      this.$store.commit('putS');


    },
    put2(){
           this.$store.commit('slice',9);
     this.$store.commit('putN');
    }

  }
}
</script>

<style scoped>
h2{
  font-size:2vw;
}
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

