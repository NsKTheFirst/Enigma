<template src="./home.html"></template>
<style scoped src="./home.css"></style>
<script>
import usersServices from "@/Services/usersService";
export default {
  name: "Home",
  data() {
    return {
      userName: null,
      password: null,
      user: {}
    };
  },
  methods: {
    async createUser() {
      event.preventDefault();
      let response = await usersServices.createUser({
        username: this.userName,
        password: this.password
      })
        console.log('res', response.config.data)
      this.user = JSON.parse(response.config.data)
        console.log("user", this.user)
      localStorage.setItem('userName', this.user.username)
      if(localStorage.userName){
        this.$router.push({name: 'GameMenu'})
      }
    },
     async logUser() {
      event.preventDefault();
      let response =  await usersServices.logUser(this.password, this.userName);
      console.log("response", response)
      // response.then(data => {
      //   console.log('user :', data.data.username)
      // })
      this.user = response.data
      localStorage.setItem('userName', this.user.username)
      if(localStorage.userName){
          this.$router.push({name: 'GameMenu'})
      }
    }
  }
};
</script>

