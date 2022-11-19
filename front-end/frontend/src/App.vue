<template>
  <div id="app">
    <b-navbar toggleable="lg" type="light" id="nav">
        <router-link class="navbar-brand" v-bind:to="{ name: 'home' }"> Home </router-link>
        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
        <b-collapse id="nav-collapse" is-nav>
          <!-- Right aligned nav items -->
          <b-navbar-nav class="ml-auto">
        
            <b-nav-item-dropdown text="Recipes">
              <b-dropdown-item><router-link v-bind:to="{ name: 'journals' }"> *View All Journal Entries* </router-link></b-dropdown-item>
              <b-dropdown-item><router-link v-bind:to="{ name: 'create-journal' }"> Add Journal Entry </router-link></b-dropdown-item>
            </b-nav-item-dropdown>

            <router-link class="nav-link" v-bind:to="{ name: 'logout' }"> *Logout* </router-link>

          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    <router-view />
  </div>
</template>

<!-- <template>
  <div id="app">
    <img alt="Picture of Dice" src="./assets/dice.png">
    <JournalCard gameName='Game Name Goes Here' sourceUrl='www.test.com' publisherType='publisher' genre='genre' mechanic='d20'/>
    
  </div>
</template> -->

<!-- <script>
import JournalCard from './components/JournalCard.vue'

export default {
  name: 'App',
  components: {
    JournalCard
  }
}
</script> -->

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
