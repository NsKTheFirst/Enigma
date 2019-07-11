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
                },
                page1: {
                    id: 1,
                    nom: "Porte",
                    imageUrl : "https://imgur.com/juwrHV3",
                    text :  "J’y suis… Je ne réalise toujours pas que l’on me donne accès à la tristement célèbre maison d’Amityville pour un article.",
                    left : null,
                    right : null,
                    back : null,
                    clue : null,
                    position : 11
                },
            }
        }
    }
</script>

