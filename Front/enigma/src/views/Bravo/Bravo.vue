<template src="./bravo.html"></template>
<style scoped src="./bravo.css"></style>
<script>
    import Header from '@/components/Header/Header.vue'

    export default {
        name: "Bravo",
        components: {
            Header
        },
        data(){
            return {
                time: null
            }

        },
        mounted(){
            this.time = localStorage.time
            console.log('time', this.time)
        }
    }
</script>

