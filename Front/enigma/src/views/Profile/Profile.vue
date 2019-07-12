<template src="./profile.html"></template>
<style scoped src="./profile.css"></style>

<script>
    import Header from '@/components/Header/Header.vue'
    import usersService from '@/Services/usersService'
    export default {
        name: "Profile",
        components: {
            Header
        },
        data() {
            return {
                oldPassword: null,
                newPassword: null,
                user: {}
            }
        },
        mounted(){
            this.getUser()
        },
        methods: {
            async getUser(){
                let result = await usersService.fetchUser(this.$route.params.userName)
                this.user = result.data
                console.log('user', this.user)
            },
            updatePassword() {
                console.log("Update cela marche")
            },
            delAccount() {
                console.log("Youpi c'est supprimé")
            }
        }
    }
  }
};
</script>