<template>
  <div id="app">

    <nav>
      <router-link v-bind:to="{ name: 'home' }"> Home </router-link>
      <router-link v-bind:to="{ name: 'journals' }"> *View All Journal Entries* </router-link>
      <router-link v-bind:to="{ name: 'create-journal' }"> Add Journal Entry </router-link>
    </nav>

  </div>
</template>

<style>
body{
  background-image: url('https://cdn.discordapp.com/attachments/872641665314222100/963544684028895253/wood.jpg');
}
#nav {
  margin-bottom: 5%;
  background-color: cornsilk;
}
.parent {
    border: 5px solid rgb(230, 213, 195);
    background-color: cornsilk;
    border-radius: 10px;
}
</style>
