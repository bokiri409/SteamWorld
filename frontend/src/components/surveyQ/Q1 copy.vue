<template>
    <div class="blueArea">
        <h1 class="typing-txt">Q1. 적들이 마구 몰려오는 상황, 당신은 어떻게 하시겠습니까? </h1>
        <p>와아오아아아아아아아</p>
        <img src="../../assets/img/bg2.gif"/>
        <hr>



        <b-button>맞서 싸운다 </b-button>
        <b-button>일단 안전을 확보한다 </b-button>



    </div>




</template>

<style scoped>

h1.typing-txt{
  position:relative;
  display: inline-block;
  height: 50px; overflow: hidden;
  animation: typingAni 4s steps(30, end) 1;
}
p.typing-txt{display: none;}
  

.typing {  
/*       position: absolute;*/ 
     display: inline-block; 
      animation-name: cursor; 
      animation-duration: 0.3s; 
      animation-iteration-count: infinite; 
    } 
    @keyframes cursor{ 
      0%{border-right: 1px solid #fff} 
      50%{border-right: 1px solid #000} 
      100%{border-right: 1px solid #fff} 
    }
</style>

