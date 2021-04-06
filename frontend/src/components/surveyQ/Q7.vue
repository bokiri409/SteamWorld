<template>

<div class="container blueArea">
    <div clss="row">

        <h2 class="typing-txt">Q7.눈앞에 강해보이는 몬스터가 나타났다!  jp 나의 선택은?</h2>
        <p>와아오아아아아아아아</p>
                 <p>   {{this.$store.state.result}}</p>
        <img src="../../assets/img/bg2.gif"/>
        <hr>



        <router-link to="/q8" class="nav-link"><b-button @click="put1">나보다 압도적으로 강할 것 같다. 자리를 피한다.  j</b-button></router-link>
        <router-link to="/q8" class="nav-link"><b-button @click="put2">내가 이길 수 있다. 좋은 아이템을 위해 사냥한다. p</b-button></router-link>




</div>
</div>
</template>


<script>


export default {

  methods:{

    put1(){
           this.$store.commit('slice',6);
      this.$store.commit('putJ');


    },
    put2(){
           this.$store.commit('slice',6);
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

