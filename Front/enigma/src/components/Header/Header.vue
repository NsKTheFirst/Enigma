<template src="./header.html"></template>
<style scoped src="./header.css"></style>
<script>
    export default {
        name: "Header",
        data(){
            return {
                userName: null
            }
        },
        mounted(){
           this.userName = localStorage.userName
            console.log('user', this.userName)
        },
        methods:{
            // toProfile(){
            //     let userName = this.userName
            //     this.$router.push({name: 'UserProfile', params: {userName}})
            // }
        }
    }
</script>

