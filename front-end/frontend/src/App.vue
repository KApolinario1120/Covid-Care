<template>
  <div id="app">
      <nav>
        <router-link id="home-link" v-bind:to="{ name: 'home-page' }"> Home </router-link>
        <router-link id="journal-list-link" v-bind:to="{ name: 'journal-list' }"> View All Journal Entries </router-link>
        <router-link id="create-journal-link" v-bind:to="{ name: 'journal-entry' }"> Add Journal Entry </router-link>
        <router-link id="find-physician-link" v-bind:to="{ name: 'find-physician' }"> Find a Physician </router-link>
      </nav>

    <router-view />
  </div>
</template>

<style>
body {
  background-color: rgb(245, 233, 208);
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

nav {
  justify-content: space-evenly;
  font-family: Georgia, Arial, Helvetica, sans-serif;
  display: flex;
  font-size: 25px;
  background-color: goldenrod;
  border-radius: 10px;
  color: white;
  padding-bottom: 10px;
  padding-top: 10px;
}

.parent {
  background-color: rgb(241, 223, 187);
  display: flex;
}
</style>
