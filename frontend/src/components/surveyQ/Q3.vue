<template>
  <div>
    <div class="container blueArea" id="area">
      <div clss="row">
        <h2 class="typing-txt">
          Q3.역시 혼자는 위험해! 파티를 맺고 던전을 돌때 나는
        </h2>
        <hr />
        <img height="300px" src="../../assets/img/q3.gif" />
        <hr />

        <router-link to="/q4" class="nav-link"
          ><b-button @click="put1"
            >앞에 나서서 적을 무찌르고 싶다.</b-button
          ></router-link
        >
        <router-link to="/q4" class="nav-link"
          ><b-button @click="put2"
            >팀원들을 보조하며 힐을 해주고 싶다.</b-button
          ></router-link
        >
      </div>
    </div>
  
  </div>
</template>

<script>
export default {
  methods: {
    put1() {
      this.$store.commit("slice", 2);
      this.$store.commit("putE");
    },
    put2() {
      this.$store.commit("slice", 2);
      this.$store.commit("putI");
    },
  },
};
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
h2.typing-txt::after {
  position: absolute;
  display: block;
  content: "";
  width: 5px;
  height: 30px;
  top: 5px;
  right: 0px;
  border-right: 3px solid rgb(252, 252, 252);
  animation: cursor 0.5s step-end infinite;
}
@keyframes typingAni {
  0% {
    width: 0%;
  }
  100% {
    width: 80%;
  }
}
@keyframes cursor {
  0% {
    opacity: 0;
  }
  50% {
    opacity: 1;
  }
  100% {
    opacity: 0;
  }
}
h2{
  font-size:2vw;
}
</style>
