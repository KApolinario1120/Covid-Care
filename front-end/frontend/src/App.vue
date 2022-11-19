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

body {
  background-color: rgb(253, 253, 253);
   /* background-image: url('https://cdn.discordapp.com/attachments/872641665314222100/963544684028895253/wood.jpg');  */
} 



nav {
  justify-content: space-around;
  /* margin-bottom: 15%; */
  font-family: Georgia, Arial, Helvetica, sans-serif;
  display: flex;
  flex-grow: 1;
  flex-direction: row;
  font-size: 30px;
  /* border: 5px solid rgb(223, 139, 50); */
  /* background-color: rgb(62, 49, 215); */
  border-radius: 10px;
  margin: 15px 20px 15px 20px;
  color: white;
  padding-bottom: 10px;
  padding-top: 10px;
}

router-link {
  justify-content: space-around;
  background-color: rgb(84, 84, 84);;
  /* border-radius: 15px; */
  text-align: center;
  padding: 15px 20px 15px 20px;

}


.parent {
  background-color: rgb(255, 255, 255);
    display: flex;
    flex-grow: 1;
    flex-direction: row;
    border: 5px solid rgb(230, 213, 195);
    background-color: cornsilk;
    border-radius: 10px;
    margin: 15px 20px 15px 20px;

}
</style>
