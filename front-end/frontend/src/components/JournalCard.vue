<template>
  <div v-on:click.prevent="routeToJournalDetails(journal)">
      <span>{{journal.journalDate}}</span>
      <br>
      <br>
      <span>Covid Test result: {{journal.testedPositive}}</span>
      <p>Notes: {{journal.notes}}</p>
  </div>
</template>

<script>
export default {
    name: 'journal-card',
    props: {
        journal: Object
    },
    methods: {
      routeToJournalDetails(journal){
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
