<template>

<div class="container blueArea">
    <div clss="row">

        <h2 class="typing-txt">Q5. 출구를 찾다가 양갈래 길이 나왔다. 어디로 가야하지? </h2>
        <p>와아오아아아아아아아</p>
                 <p>   {{this.$store.state.result}}</p>
        <img src="../../assets/img/bg2.gif"/>
        <hr>



        <router-link to="/q6" class="nav-link"><b-button @click="put1">정확히 방향을 찾고 어느 길이 출구에 가까울지 계산하여 선택한다 t </b-button></router-link>
        <router-link to="/q6" class="nav-link"><b-button @click="put2">아! 모르겠다! 그냥 그때 끌리는 길로 간다.f </b-button></router-link>




</div>
</div>
</template>


<script>


export default {

  methods:{

    put1(){
           this.$store.commit('slice',4);
      this.$store.commit('putF');


    },
    put2(){
           this.$store.commit('slice',4);
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

