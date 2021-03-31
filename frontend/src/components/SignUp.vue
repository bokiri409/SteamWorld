<template>
  <div>
    <div
      class="container"
      style="background-color:#00000077; margin-bottom:50px; align:center"
    >
      <div class="section-title">
        <h2>Sign Up</h2>
        <p>회원가입</p>
      </div>

      <div class="signup-container">
        <div class="form-group">
          <label>NickName</label>
          <input type="text" class="form-control form-control-lg" />
        </div>

        <div class="form-group">
          <label>ID (Email address)</label>
          <input type="email" class="form-control form-control-lg" />
        </div>

        <div class="form-group">
          <label>Password</label>
          <input type="password" class="form-control form-control-lg" />
        </div>
        <div class="form-group">
          <label>Password check</label>
          <input type="password" class="form-control form-control-lg" />
        </div>

        <button
          type="submit"
          class="btn btn-dark btn-lg btn-block"
          style="margin-bottom:30px"
        >
          회원가입
        </button>

        <p class="forgot-password text-right">
          이미 계정이 있나요?
          <router-link to="/user/login"> 로그인하러 가기</router-link>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
};
</script>

<style>
.signup-container {
  padding-left: 300px;
  padding-right: 300px;
  padding-top: 100px;
  padding-bottom: 100px;
}
</style>
