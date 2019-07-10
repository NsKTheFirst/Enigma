<template src="./home.html"></template>
<style scoped src="./home.css"></style>
<script>
import usersServices from "@/Services/usersService";
export default {
  name: "Home",
  data() {
    return {
      userName: null,
      password: null
    };
  },
  methods: {
    createUser() {
      event.preventDefault();
      usersServices.createUser({
        username: this.userName,
        password: this.password
      });
    },
    logUser() {
      event.preventDefault();
      usersServices.logUser(this.password, this.userName);
    }
  },
  redirect() {}
};
</script>

