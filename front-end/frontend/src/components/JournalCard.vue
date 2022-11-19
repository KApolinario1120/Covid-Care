<template>
  <div class="journal-card">
    <img src= {{ gamePhoto }}>
    <h1>{{ gameName }}</h1>
    <h3>Details:</h3>
    <ul>
      <li>Source Url: {{ sourceUrl }}</li>
      <li>Publisher Type: {{ publisherType }}</li>
      <li>Genre: {{ genre }}</li>
      <li>Mechanic: {{ mechanic }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'JournalCard',
  props: {
    gamePhoto: String,
    gameName: String,
    sourceUrl: String,
    publisherType: String,
    genre: String,
    mechanic: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
ul {
  list-style-type: none;
  padding: 0;
}
a {
  color: #42b983;
}
</style>
