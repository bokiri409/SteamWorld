<template>
  <div>
    <div class="parent">
      <div class="child1-5">
        <h3>프로필 상세</h3>
      </div>
      <div class="child2">
        <br />
        <div id="all_info">
          <div id="user_info">
            <div id="login_info">
              <span style="font-size: 20px"> 아이디(이메일) </span>
            </div>
          </div>
          <br />
          <div>
            <div style="margin-top:35px">
              <div class="inpbx" style="font-size: large">
                <span style="font-size: 20px ;"> 닉네임 </span>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="child2">
        <br />
        <div id="all_info">
          <div id="user_info">
            <div id="login_info">
              <span style="font-size: 20px">{{ user.userid }}</span>
              <!-- <b-input style="font-size: 20px" :value=user.userid> </b-input> -->
            </div>
          </div>
          <br />
          <div>
            <div style="margin-top:35px">
              <div class="inpbx" style="font-size: large">
                <span v-if="!show_user" style="font-size: 20px ;">{{ user.nickname }}</span>
              <b-input v-else style="font-size: 20px" :value=user.nickname> </b-input>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="child1">
        <b-button type="primary" @click.prevent="show_update_pw()" v-if="!show">
          비밀번호 변경
        </b-button>
        <br />
        <br />
        <b-button type="primary" @click.prevent="show_update_user()" v-if="!show"
          >프로필 수정</b-button
        >
      <div v-if="show_user == true" style="margin-left:30px">
        <b-button 
        type="primary" 
        @click.prevent="show_update_pw()"
        >
          수정 완료
        </b-button>
      </div>
       <div v-if="show_pw == true" style="margin-left:30px">
        <b-button 
        type="primary" 
        @click.prevent="show_update_pw()"
        >
          변경 완료
        </b-button>
      </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import { mapState } from 'vuex';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  data() {
    return {
      show: false,
      show_pw: false,
      show_user: false,
      visible: false,
      user: {
        userid: '',
        nickname: '',
        steamid: '',
      },
    };
  },
  // components: {
  //   [Button.name]: Button,
  //   FgInput
  // },
  computed: {
    ...mapState(['loginStatus']),
  },
  created() {
    this.user.steamid = localStorage.getItem('steamid');
    this.user.nickname = localStorage.getItem('nickname');
    this.user.userid = localStorage.getItem('userid');
  },
  methods: {
    show_update_pw() {
      this.show_pw = true;
      this.show = true;
    },
    show_update_user() {
      this.show_user = true;
      this.show = true;
    },

    cancel() {
      this.show = false;
    },

    update() {
      // console.log('토큰 : ' + localStorage.getItem('token'));
      var img = document.getElementById('img');
      if (img.files.length != 0) {
        const frm = new FormData();
        frm.append('file', img.files[0]);
        axios
          .post(`${SERVER_URL}/file/upload/`, frm)
          .then((res) => {
            console.log(res.data.message);
            this.user.picture = SERVER_URL + '/file/read/' + res.data.message;
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
                  localStorage.setItem('picture', this.user.picture);
                  localStorage.setItem('region', this.user.region);
                  localStorage.setItem('nickname', this.user.nickname);
                  localStorage.setItem('phone', this.user.phone);
                } else {
                  alert('정보 수정에 실패하셨습니다.');
                }
              })
              .catch((err) => {
                console.log(err);
              });
            this.$router.push('/');
            window.location.reload();
          })
          .catch((err) => {
            console.log(err);
            alert('이미지 용량이 너무 큽니다.');
          });
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
            alert('그룹장인 경우 닉네임 변경이 불가능합니다.');
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
  components: {},
};
</script>
<style scoped>

.parent {
  display: flex;
}
.child1 {
  flex: 1;
}
.child1-5 {
  flex: 1.5;
}

.child2 {
  flex: 2;
}
</style>
