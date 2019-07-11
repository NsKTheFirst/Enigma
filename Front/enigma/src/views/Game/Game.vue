<template src="./game.html"></template>
<style scoped src="./game.css"></style>

<script>
    import Header from '@/components/Header/Header.vue'
    export default {
        name: "Game",
        components: {
            Header
        },
        data(){
            return {
                page: {
                    imageUrl: "https://zupimages.net/up/19/28/s5mb.png"
                }
            }
        }
    }
</script>

