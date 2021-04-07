<template>


<div class="container blueArea">
    <div clss="row">


        <h2 class="typing-txt">Q1. 적들이 마구 몰려오는 상황, 당신은 어떻게 하시겠습니까? </h2>
        <hr>
        <img height=300px src="../../assets/img/bg2.gif"/>
        <hr>

        <router-link to="/q2" class="nav-link"><b-button @click="put1">돌격하여 적을 쳐부수자! e</b-button></router-link>
        <router-link to="/q2" class="nav-link"><b-button @click="put2">일단 안전을 확보한다 i</b-button></router-link>




</div>
</div>

</template>

<script>


export default {

  methods:{
      updated(){
      console.log(this.$store.state.result);
      this.$store.dispatch('slice',0);
    },

    put1(){
      this.$store.commit('slice',0);
      this.$store.commit('putE');


    },
    put2(){
      this.$store.commit('slice',0);
     this.$store.commit('putI');
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
  animation: cursor 0.3s step-end infinite;
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

