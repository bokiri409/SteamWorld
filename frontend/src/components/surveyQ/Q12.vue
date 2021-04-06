<template>

<div class="container blueArea">
    <div clss="row">

        <h2 class="typing-txt">Q12. n이니 s니 </h2>
        <p>와아오아아아아아아아</p>
                 <p>   {{this.$store.state.result}}</p>
        <img src="../../assets/img/bg2.gif"/>
        <hr>



        <router-link to="/result" class="nav-link"><b-button @click="put1">ssss </b-button></router-link>
        <router-link to="/result" class="nav-link"><b-button @click="put2">nnnn </b-button></router-link>




</div>
</div>
</template>

<script>


export default {

  methods:{

    put1(){
           this.$store.commit('slice',11);
      this.$store.commit('putS');


    },
    put2(){
           this.$store.commit('slice',11);
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

