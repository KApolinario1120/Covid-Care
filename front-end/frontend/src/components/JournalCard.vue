<template>
  <div v-on:click.prevent="routeToJournalDetails(journal)">
      <span>{{journal.journalDate}}</span>
      <span>Tested Positive? {{journal.testedPositive}}</span>
      <p>Notes: {{journal.notes}}</p>
  </div>
</template>

<script>
export default {
    name: "journal-card",
    props: {
        journal: Object
    },
    methods: {
      routeToJournalDetails(recipe){
      console.log("hit");
      this.$router.push('/journal/'+journal.journalId)
    }
  }
}
</script>

<style scoped>
span{
    font-weight: bolder;
    font-size: 150%;
    line-height: 30px;
}
p{
    padding-top: 30px;
    padding-left: 15px;
    padding-right: 15px;
    font-size: 100%;
}
img{
  width: 100%;
  max-height: 200px;
}
</style>

<!-- <template>
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
</style> -->
