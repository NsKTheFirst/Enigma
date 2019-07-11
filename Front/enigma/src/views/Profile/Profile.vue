<template src="./profile.html"></template>
<style scoped src="./profile.css"></style>

<script>
import usersServices from "@/Services/usersService";

import Header from "@/components/Header/Header.vue";
export default {
  name: "Profile",
  components: {
    Header
  },
  methods: {
    getUser() {
      event.preventDefault();
      usersServices.getProfile();
    }
  }
};
</script>