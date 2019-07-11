<template src="./profile.html"></template>
<style scoped src="./profile.css"></style>

<script>
    import Header from '@/components/Header/Header.vue'
    export default {
        name: "Profile",
        components: {
            Header
        },
        data() {
            return {
                oldPassword: null,
                newPassword: null
            }
        },
        methods: {
            updatePassword() {
                console.log("Update cela marche")
            },
            delAccount() {
                console.log("Youpi c'est supprimé")
            }
        }
    }
</script>

