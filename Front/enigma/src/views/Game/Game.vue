<template src="./game.html"></template>
<style scoped src="./game.css"></style>

<script>
    import Header from '@/components/Header/Header.vue'
    import pagesService from '@/Services/pagesService'
    export default {
        name: "Game",
        components: {
            Header
        },
        data(){
            return {
                page: {}
            }
        },
        mounted(){
            this.getPage()
        },
        methods:{
            async getPage(){
                let result = await pagesService.fetchPage(1)
                console.log('page', result.data)
                this.page = result.data
            }
        }
    }
</script>

