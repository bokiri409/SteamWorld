<template>

<div class="container blueArea">
    <div clss="row">

     

        <h2 class="typing-txt">Q2. 게임에서 상대방이 나의 캐릭터를 죽였다 나는 </h2>
        <p>   {{this.$store.state.result}}</p>
        <img src="../../assets/img/q2.gif"/>
        <hr>



        <router-link to="/q3" class="nav-link"><b-button @click="put1">너무 화가나고 어떻게든 복수하고 싶다 e </b-button></router-link>
        <router-link to="/q3" class="nav-link"><b-button @click="put2">끔찍하다. 다시는 마주치지 않고 싶다 i</b-button></router-link>




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
          this.$store.commit('slice',1);
      this.$store.commit('putE');


    },
    put2(){
                this.$store.commit('slice',1);
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

