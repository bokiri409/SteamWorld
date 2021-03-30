<template>
 <div>
    <!-- ======= About Section ======= -->

    <div class="container" style="background-color:#00000077; margin-bottom:50px;">

      <div class="section-title">
        <h2>Login</h2>
        <p>로그인</p>
      </div>
      <div>
   
      </div>



       <div>
    <b-form-group
      id="fieldset-1"
      label="아이디"
      label-for="input-1"
      valid-feedback="Thank you!"
      :invalid-feedback="invalidFeedback"
      :state="state"
      class="col-md-6"
    >
      <b-form-input class="input" id="input-1" v-model="id" :state="state" trim></b-form-input>
    </b-form-group>
  </div>


        <div>
    <b-form-group
      id="fieldset-2"
      label="비밀번호"
      label-for="input-2"
      valid-feedback="Thank you!"
      :invalid-feedback="invalidFeedbackPassword"
      :state="statePassword"  
      class="col-md-6"
    >
      <b-form-input class="input" id="input-2" v-model="password" :state="statePassword" trim></b-form-input>
    </b-form-group>
  </div>

    </div>

     

  </div>
</template>



<script>
  export default {  
    computed: {
      state() {
        return this.id.length >= 4
      },
      statePassword() {
        return this.password.length >= 4
      },
      invalidFeedback() {
        if (this.id.length > 0) {
          return 'Enter at least 4 characters.'
        }
        return 'Please enter something.'
      },
      invalidFeedbackPassword() {
        if (this.password.length > 0) {
          return 'Enter at least 4 characters.'
        }
        return 'Please enter something.'
      }
    },
    data() {
      return {
        id: '',
        password: ''
      }
    }
  }
</script>


<style>
span{
    color:white;
}
label{
    color:white;
}


</style>
