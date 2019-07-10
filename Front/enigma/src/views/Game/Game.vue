<template src="./game.html"></template>
<style scoped src="./game.css"></style>
<script>
import pagesServices from "@/Services/pagesService";
export default {
  name: "Game",
  data() {
    piece: [];
  },
  methods: {
    getPiece() {
      pagesServices.getPiece();
    }
  }
};
</script>

