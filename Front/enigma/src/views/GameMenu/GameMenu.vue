<template src="./gameMenu.html"></template>
<style scoped src="./gameMenu.css"></style>

<script>
    import Header from '@/components/Header/Header.vue'
    export default {
        name: "GameMenu",
        components: {
            Header
        },
        methods: {
            toGame() {
                this.$router.push({name: 'Game'})
            }
        }
    }
</script>

