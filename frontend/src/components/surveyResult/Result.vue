<template>
  <div class="container blueArea">
    
    <h1>당신의 인생게임은...</h1>
    <img src="../../assets/img/human.png">

    <p>{{ this.$store.state.result }}입니다.</p>
    <button @click="showA">결과 확인하기</button>

    <h1>{{ this.result }}</h1>
    <router-link to="/result/detail">detail</router-link>
  </div>
</template>

<script>
export default {
    data(){
        return{result: ''}
    },
  methods: {
    showA() {
        this.e=0;
        this.i=0;
        this.n=0;
        this.s=0;
        this.t=0;
        this.f=0;
        this.j=0;
        this.p=0;
        this.result='';
      this.answer = this.$store.state.result;
      for (this.step = 0; this.step < 12; this.step++){
        if(this.answer[this.step]=='E'){
            this.e++;
        }else if(this.answer[this.step]=='I'){
            this.i++;
        }else if(this.answer[this.step]=='N'){
            this.n++;
        }else if(this.answer[this.step]=='S'){
            this.s++;
        }else if(this.answer[this.step]=='T'){
            this.t++;
        }else if(this.answer[this.step]=='F'){
            this.f++;
        }else if(this.answer[this.step]=='J'){
            this.j++;
        }else if(this.answer[this.step]=='P'){
            this.p++;
        }
      }
      if(this.e>=2){
          this.result+='E'
      }else{  this.result+='I'}

        if(this.n>=2){
          this.result+='N'
      }else{  this.result+='S'}

        if(this.t>=2){
          this.result+='T'
      }else{  this.result+='F'}

        if(this.j>=2){
          this.result+='J'
      }else{  this.result+='P'}


      this.$store.commit('putPage',this.result);


    },
  },
};
</script>
