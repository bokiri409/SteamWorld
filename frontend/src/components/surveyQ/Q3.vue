<template>

<div class="container blueArea">
    <div clss="row">

        <h2 class="typing-txt">Q3. 팀과 함께하는 게임을 할 때 나는 </h2>
        <p>와아오아아아아아아아</p>
         <p>   {{this.$store.state.result}}</p>
        <img src="../../assets/img/q3.gif"/>
        <hr>



        <router-link to="/q4" class="nav-link"><b-button @click="put1">앞에 나서서 적을 무찌르고 싶다 e </b-button></router-link>
        <router-link to="/q4" class="nav-link"><b-button @click="put2">팀원들을 보조하며 힐을 해주고 싶다 i</b-button></router-link>




</div>
</div>
</template>



<script>


export default {

  methods:{
   
  put1(){
          this.$store.commit('slice',2);
      this.$store.commit('putE');


    },
    put2(){
     this.$store.commit('slice',2);
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

