<template>

<div class="container blueArea">
    <div clss="row">

        <h2 class="typing-txt">Q4. 게임 캐릭터를 선택할 때 나는 </h2>
                <hr>
        <img height=300px src="../../assets/img/bg2.gif"/>
        <hr>



        <router-link to="/q5" class="nav-link"><b-button @click="put1">외모 커스터마이징에 몇시간을 투자한다 f</b-button></router-link>
        <router-link to="/q5" class="nav-link"><b-button @click="put2"> 대충 맘에 들면 넘어가는 편이다 t</b-button></router-link>




</div>
</div>
</template>


<script>


export default {

  methods:{

    put1(){
           this.$store.commit('slice',3);
      this.$store.commit('putF');


    },
    put2(){
           this.$store.commit('slice',3);
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

