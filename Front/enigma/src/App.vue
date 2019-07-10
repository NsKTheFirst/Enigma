<template>
  <div id="app">
    <!--    <div id="nav">-->
    <!--      <router-link to="/">Home</router-link> |-->
    <!--      <router-link to="/about">About</router-link>-->
    <!--    </div>-->
    <router-view />
  </div>
</template>



<style lang="scss">
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  appearance: scrollbarbutton-up;
}

#app {
  background-color: #323232;
  height: 100vh;
}

a {
  text-decoration: none;
}
/*#nav {*/
/*  padding: 30px;*/
/*  a {*/
/*    font-weight: bold;*/
/*    color: #2c3e50;*/
/*    &.router-link-exact-active {*/
/*      color: #42b983;*/
/*    }*/
/*  }*/
/*}*/
</style>
