<template src="./header.html"></template>
<style scoped src="./header.css"></style>
<script>
    export default {
        name: "Header",
        data(){
            return {
                id_user: 2
            }
        },
        mounted(){

        },
        methods:{
            // toProfile(){
            //     let userId = this.localStorage.idUser
            //     this.$router.push({name: 'UserProfile', params: {userId}})
            // }
        }
    }
</script>

