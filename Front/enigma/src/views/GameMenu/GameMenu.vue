<template src="./gameMenu.html"></template>
<style scoped src="./gameMenu.css"></style>

<script>
    export default {
        name: "GameMenu",
        methods: {
            toGame() {
                this.$router.push({name: 'Game'})
            }
        }
    }
</script>

