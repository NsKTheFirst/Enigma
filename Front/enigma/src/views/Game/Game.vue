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
                page: {},
                pointedPage: null,
                currentPage: 1,
                porte: false,
                cases: [],
                code: null,
                retry: false
            }
        },
        mounted(){
            this.getFirstPage()
            this.createCases()
        },
        methods:{
            async getFirstPage(){
                let result = await pagesService.fetchPage(1)
                console.log('page', result.data)
                this.page = result.data
            },
            async getPage(cell){
                // !this.page.back_ar ? this.currentPage = this.page.numPage : this.currentPage = this.page.back_ar
                // console.log("currentPage", this.currentPage)
                if(cell === 11 && cell ===this.page.position){
                    this.pointedPage = 2
                }
                if(cell === 16 && this.currentPage === 2){
                    this.pointedPage = 6
                }
                if(cell === 10 && cell ===this.page.position){
                    this.pointedPage = 7
                }
                if(cell === 16 && this.currentPage === 4){
                    this.pointedPage = 8
                }
                if(this.currentPage < 5 && cell !== 17 && cell === this.page.position){
                    let result = await pagesService.fetchPage(this.pointedPage)
                    console.log('page', result.data)
                    this.page = result.data
                    !this.page.back_ar ? this.currentPage = this.page.numPage : this.currentPage = this.page.back_ar
                    console.log("currentPage", this.currentPage)
                }
                if(cell === 17){
                    this.porte = true
                }
            },
            async left(){
                console.log("left")
                let result = await pagesService.fetchPage(this.page.leftAr)
                this.page = result.data
                this.currentPage = this.page.numPage
            },
            async right(){
                console.log("right")
                let result = await pagesService.fetchPage(this.page.rightAr)
                this.page = result.data
                this.currentPage = this.page.numPage
            },
            async back(){
                console.log("back")
                let result = await pagesService.fetchPage(this.page.backAr)
                this.page = result.data
                this.currentPage = this.page.numPage
            },
            createCases(){
                for(let i = 1; i <= 28; i ++){
                    this.cases.push(i)
                }
                console.log("cases", this.cases)
            },
            checkCode(){
                console.log("code", this.code)
                Number(this.code) === 536 ? this.$router.push({name: 'Bravo'}) : this.retry = true
            }
        }
    }
</script>

