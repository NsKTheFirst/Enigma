import Vue from "vue";
import Router from "vue-router";
import Home from "./views/Home/Home.vue";
import Profile from "./views/Profile/Profile.vue";
import Game from "./views/Game/Game.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "Home",
      component: Home
    },
    {
      path: "/profile",
      name: "Profile",
      component: Profile
    },
    {
      path: "/game",
      name: "Game",
      component: Game
    }
  ]
});
