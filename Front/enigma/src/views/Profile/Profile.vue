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
                user: {},
                oldUserPass: null,
                newUserPass: null
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
            async updatePassword() {
                await usersService.updatePassword(this.user.id, this.newPassword)
                this.getUser()
                this.newUserPass = this.user.password
                if(this.newUserPass !== this.oldUserPass){
                    alert("Votre mot de passe à bien été modifié.")
                }
            },
            async delAccount() {
                if(confirm("Voulez vous vraiment supprimer votre compte?")){
                    let result = await usersService.deleteUser(this.user.id)
                    console.log("Youpi c'est supprimé", result)
                    this.$router.push({name: 'Home'})
                }
            }
        }
    }
</script>