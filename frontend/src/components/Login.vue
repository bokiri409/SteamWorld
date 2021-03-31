<template>
  <div>
    <!-- ======= About Section ======= -->

    <div
      class="container"
      style="background-color:#00000077; margin-bottom:50px;"
    >
      <div class="section-title">
        <h2>Login</h2>
        <p>로그인</p>
      </div>
      <div class="text-container">
        <!-- <div>
        <b-form-group
          id="fieldset-1"
          label="아이디"
          label-for="input-1"
          valid-feedback="Thank you!"
          :invalid-feedback="invalidFeedback"
          :state="state"
          class="col-md-6"
        >
          <b-form-input
            class="input"
            id="input-1"
            v-model="id"
            :state="state"
            trim
          ></b-form-input>
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
          <b-form-input
            class="input"
            id="input-2"
            v-model="password"
            :state="statePassword"
            trim
          ></b-form-input>
        </b-form-group>
      </div> -->

        <!-- ======= Login Section ======= -->

        <div class="form-group">
          <label :invalid-feedback="invalidFeedback"
            >User ID (Email address)</label
          >
          <b-form-input
            type="email"
            class="form-control form-control-lg"
            v-model="id"
            :state="state"
            id="feedback-user"
          />
          <b-form-invalid-feedback :state="validation">
            Your user ID must be 5-12 characters long.
          </b-form-invalid-feedback>
          <b-form-valid-feedback :state="validation">
            Looks Good.
          </b-form-valid-feedback>
        </div>

        <div class="form-group">
          <label>Password</label>
          <b-form-input
            type="password"
            class="form-control form-control-lg"
            id="text-password"
            aria-describedby="password-help-block"
            v-model="password"
            :state="statePassword"
          />
          <b-form-text id="password-help-block">
            Your password must be 8-20 characters long, contain letters and
            numbers, and must not contain spaces, special characters, or emoji.
          </b-form-text>
        </div>

        <button type="submit" class="btn btn-dark btn-lg btn-block">
          로그인
        </button>
        <button class="btn btn-dark btn-lg btn-block">
          회원가입
        </button>

        <p class="forgot-password text-right mt-2 mb-4">
          <router-link to="/user/forgotpassword">Forgot password ?</router-link>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  computed: {
    state() {
      return this.id.length >= 4;
    },
    statePassword() {
      return this.password.length >= 4;
    },
    invalidFeedback() {
      if (this.id.length > 0) {
        return 'Enter at least 4 characters.';
      }
      return 'Please enter something.';
    },
    invalidFeedbackPassword() {
      if (this.password.length > 0) {
        return 'Enter at least 4 characters.';
      }
      return 'Please enter something.';
    },
  },
  data() {
    return {
      id: '',
      password: '',
    };
  },
};
</script>

<style>
span {
  color: white;
}
label {
  color: white;
}
.container {
  margin: 100px;
}
.text-container {
  padding-left: 300px;
  padding-right: 300px;
  padding-top: 100px;
  padding-bottom: 100px;
}
</style>
