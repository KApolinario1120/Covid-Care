<template>
  <div id="app">
      <nav>
        <!-- <ul>
          <li> -->
            <router-link id="home-link" v-bind:to="{ name: 'home-page' }"> Home </router-link>
          <!-- </li>
          <li> -->
            <router-link id="journal-list-link" v-bind:to="{ name: 'journal-list' }"> View All Journal Entries </router-link>
          <!-- </li>
          <li> -->
            <router-link id="create-journal-link" v-bind:to="{ name: 'journal-entry' }"> Add Journal Entry </router-link>
            <router-link id="find-physician-link" v-bind:to="{ name: 'find-physician' }"> Find a Physician </router-link>
          <!-- </li>
      </ul> -->
      </nav>
    <router-view />
    </div>
</template>
<style>

body {
  background-color: rgb(245, 233, 208);
   /* background-image: url('https://cdn.discordapp.com/attachments/872641665314222100/963544684028895253/wood.jpg');  */
} 

a {
  color: black;
  text-decoration: none;
}

a:hover { 
color: white;
}

#home-link, #journal-list-link, #create-journal-link, #find-physician-link {
  display: flex;
  flex-grow: 4;
  justify-content: center;
}

/* iframe {
  margin-left: 30px;
  margin-right: 30px;
} */

nav {

  justify-content: space-evenly;
  /* margin-bottom: 15%; */
  font-family: Georgia, Arial, Helvetica, sans-serif;
  display: flex;
  /* flex-grow: 1;  */
  /* flex-direction: row; */
  font-size: 25px;
  /* border: 5px solid rgb(223, 139, 50);  */
  /* background-color: rgb(236, 194, 111); */
  background-color: goldenrod;
  border-radius: 10px;
  /* margin: 15px 20px 15px 20px; */
  color: white;
  padding-bottom: 10px;
  padding-top: 10px;

}

.parent {
  background-color: rgb(241, 223, 187);
    display: flex;
    /* flex-grow: 1; */
    /* flex-direction: row; */
    /* border: 5px solid rgb(230, 213, 195); */
    /* background-color: cornsilk; */
    /* border-radius: 10px; */
    /* margin: 15px 20px 15px 20px; */

}
</style>
