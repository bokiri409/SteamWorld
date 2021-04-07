<template>

<div class="container blueArea">
    <div clss="row">

        <h2 class="typing-txt">Q11. 어쩌구 저쩌구 씨부렁씨부렁 </h2>
        <hr>
        <img height=300px  src="../../assets/img/bg2.gif"/>
        <hr>



        <router-link to="/q12" class="nav-link"><b-button @click="put1">JJJJJ </b-button></router-link>
        <router-link to="/q12" class="nav-link"><b-button @click="put2">PPPPP</b-button></router-link>




</div>
</div>
</template>

<script>


export default {

  methods:{

    put1(){
           this.$store.commit('slice',10);
      this.$store.commit('putJ');


    },
    put2(){
           this.$store.commit('slice',10);
     this.$store.commit('putP');
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

