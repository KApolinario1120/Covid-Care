<template>
  <div id="app">
      <nav>
        <router-link v-bind:to="{ name: 'home-page' }"> Home </router-link>
        <router-link v-bind:to="{ name: 'journal-list' }"> View All Journal Entries </router-link>
        <router-link v-bind:to="{ name: 'create-journal' }"> Add Journal Entry </router-link>
      </nav>
    <router-view />
    </div>
</template>
<style>

/* body {
   background-image: url('https://cdn.discordapp.com/attachments/872641665314222100/963544684028895253/wood.jpg'); 
} */

router-link {
  justify-content: space-around;
}

nav {
  justify-content: space-around;
  /* margin-bottom: 15%; */
  background-color: cornsilk;
  font-family: Arial, Helvetica, sans-serif;
  display: flex;
  flex-grow: 1;
  flex-direction: row;
  font-size: 30px;
  /* border: 5px solid rgb(223, 139, 50); */
  background-color: rgb(219, 136, 27);
  border-radius: 10px;
  margin: 15px 20px 15px 20px;
  color: white;
  padding-bottom: 10px;
  padding-top: 10px;
}
.parent {
    display: flex;
    flex-grow: 1;
    flex-direction: row;
    border: 5px solid rgb(230, 213, 195);
    background-color: cornsilk;
    border-radius: 10px;
    margin: 15px 20px 15px 20px;

}
</style>
