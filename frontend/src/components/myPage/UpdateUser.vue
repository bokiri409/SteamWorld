<template>
<div>

    <h1>프로필 상세</h1>


    <p> nickname </p>
    <p> email </p>

    <h4>ddddd</h4>


    <b-button>수정하기</b-button>
       <div id="all_info" style="margin-left:80px">
    <div id="user_info">
      <div id="login_info">
        <span style="margin-left: 150px ;font-size: 20px"> 아이디(이메일) </span>
        <span style="margin-left: 100px ; font-size: 20px">{{
          user.email
        }}</span>
        <br /><br /><br />
        <span style="margin-left:200px ;font-size: 20px "> 비밀번호 </span>
        <span
          id="fakePw"
          v-if="!show"
          style="margin-left: 100px ; font-size: 20px"
          >********</span
        >
        <UpdatePw
          v-if="show"
          v-on:cancel="cancel()"
          style="margin-left:390px;margin-top:-50px;"
        />
        <n-button
          type="primary"
          @click.prevent="show_update_pw()"
          style="margin-left: 40px ;margin-top:-6px;font-size:0.5rem;border-radius: 10rem"
          v-if="!show"
        >
          변경
        </n-button>
      </div>
    </div>
    <div>
      <div style="margin-top:35px">
        <div class="inpbx" style="font-size: large">
          <span style="margin-left:220px ;font-size: 20px ;"> 닉네임 </span>
          <fg-input
            placeholder="닉네임"
            style="margin-left : 370px ; margin-top:-44px;width : 300px"
            v-model="user.nickname"
          />
          <br />

          <div>
            
          </div>

          <span style="margin-left:175px ;font-size: 20px ;">
            프로필 사진
          </span>
          <input class="ml-5 pl-5 mb-5" type="file" id="img"><br />

          <span style="margin-left:175px ;font-size: 20px ;">
            휴대폰 번호
          </span>
          <fg-input
            style="margin-left : 370px ; margin-top:-44px;width : 300px"
            placeholder="휴대폰 번호"
            v-model="user.phone"
          /><br />

          <div style="margin-top:-10px">
            <span style="margin-left:215px ;font-size: 20px ;"> 사는 곳 </span>
            <fg-input
              placeholder=""
              v-model="user.region"
              style="margin-top:-44px ;margin-left : 370px ; width :450px"
            />
     
            <br />
   
            <!-- <input
            type="text"
            id="user-address"
            placeholder=""
            v-model="region_detail"
            style="margin-top:20px " 
          /> -->
          </div>

          <br />
        </div>
      </div>
    </div>
    </div>



</div>
    
</template>

<script>



import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  data() {
    return {
      show: false,
      visible: false,
      user: {
        email: '',
        nickname: '',
        picture: '',
        region: '',
        phone: '',
      },
    };
  },
  // components: {
  //   [Button.name]: Button,
  //   FgInput
  // },
  methods: {
    show_update_pw() {
      this.show = true;
    },

    cancel() {
      this.show = false;
    },

    update() {
      // console.log('토큰 : ' + localStorage.getItem('token'));
      var img = document.getElementById("img")
      if (img.files.length != 0) {
        const frm = new FormData()
        frm.append('file', img.files[0])
        axios.post(`${SERVER_URL}/file/upload/`, frm)
          .then(res => {
            console.log(res.data.message)
            this.user.picture = SERVER_URL + "/file/read/" + res.data.message
            axios.put(`${SERVER_URL}/user/update`, this.user, {
                headers: {
                  'x-access-token': localStorage.getItem('token'),
                },
              })
              .then((response) => {
                if (response.data.success === 'success') {
                  console.log(this.user.region);
                  alert('정보 수정에 성공하셨습니다.');
                  localStorage.setItem('picture', this.user.picture);
                  localStorage.setItem('region', this.user.region);
                  localStorage.setItem('nickname', this.user.nickname);
                  localStorage.setItem('phone', this.user.phone);
                } else {
                  alert('정보 수정에 실패하셨습니다.');
                }
              })
              .catch(err => {
                console.log(err);
              });
            this.$router.push('/');
            window.location.reload();
          })
          .catch(err => {
            console.log(err)
            alert('이미지 용량이 너무 큽니다.');
          })

      } else {
        axios
        .put(`${SERVER_URL}/user/update`, this.user, {
          headers: {
            'x-access-token': localStorage.getItem('token'),
          },
        })
        .then((response) => {
          if (response.data.success === 'success') {
            console.log(this.user.region);
            alert('정보 수정에 성공하셨습니다.');
            localStorage.setItem('region', this.user.region);
            localStorage.setItem('nickname', this.user.nickname);
            localStorage.setItem('phone', this.user.phone);
          } else alert('정보 수정에 실패하셨습니다.');
          this.$router.push('/');
          window.location.reload();
        })
        .catch(function(error) {
          alert("그룹장인 경우 닉네임 변경이 불가능합니다.");
          console.log(error);
        });
      }
    },

    handleClickButton() {
      this.visible = !this.visible;
    },
    logout() {
      console.log('로그아웃입니다');
      this.$router.push('/');
      window.location.reload();
    },
    setAddress(data) {
      this.user.region = data;
      console.log(this.user.region);
      this.hideModal();
    },
    hideModal() {
      this.$refs['addr-modal'].hide();
    },
  },
  components: {

  },

  created() {
    this.user.region = localStorage.getItem('region');
    this.user.email = localStorage.getItem('email');
    this.user.nickname = localStorage.getItem('nickname');
    this.user.phone = localStorage.getItem('phone');
    this.user.picture = localStorage.getItem('picture');
  },
};
</script>
