<template>
  <div id="app">
    <img alt="Picture of Dice" src="./assets/dice.png">
    <GameCard gameName='Game Name Goes Here' sourceUrl='www.test.com' publisherType='publisher' genre='genre' mechanic='d20'/>
    
  </div>
</template>

<script>
import GameCard from './components/GameCard.vue'

export default {
  name: 'App',
  components: {
    GameCard
  }
}
</script>

<style>
/* body {
  background-image: url("./assets/resizedBackground.png");
} */
</style>
