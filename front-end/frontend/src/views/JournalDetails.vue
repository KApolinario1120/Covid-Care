<template>
    <div>
      <div class="details-container">

        <div class="namedesc">
          <span>{{journal.journalDate}}</span>
          <br>
          <span>Tested Positive? {{journal.testedPositive}}</span>
          <br>
          <p>{{journal.notes}}</p>
        </div>
  
        <div id="buttons">
          <span id="span" v-on:click.prevent="editJournal(journal)"> <a href=""></a> </span>
          <span id="delete" v-on:click.prevent="deleteJournal(journal)"><i class="fa fa-trash-o"></i></span>
        </div>
  
      </div>
    </div>
</template>

<script>
import RequestService from '../services/RequestService.js'
export default {
    name: "journal-details",
    data () {
    return{
        journal: null 
    }
},
    created() {
    RequestService.createJournalEntry(this.$route.params.id)
    .then((response) => {
        console.log(response.data);
        this.journal = response.data;
    })
},
methods: {
    editJournal(journal){
    console.log("hit");
    this.$router.push('/journal/edit/'+journal.journalId)
    },
    deleteJoural(journal){
    console.log(journal);
    RequestService.deleteJournal(journal)
    .then(() => {
        this.$router.push('/Journals');
    })
    }
}
}
</script>

<style scoped>
.details-container{
    display: flex;
    gap: 10px 10px;
    flex-wrap: wrap;
    justify-content: center;
    height: 100%;
    width: 100%;
    /* padding-left: 10vw;
    padding-right: 10vw; */
    /* margin-top: 45px;
    border: 5px solid rgb(230, 213, 195);
    background-color: cornsilk;
    border-radius: 10px; */
}
.details-container div {
    border: 5px solid rgb(230, 213, 195);
    background-color: cornsilk;
    border-radius: 10px;
    /* height: 300px;
    width: 300px; */
}
.namedesc {
    color: black;
    flex-basis: 40%;
    flex-grow: 0;
    flex-shrink: 0;
    text-align: left;
    padding: 10px;
    min-width: 0;
    min-height: 30vh;
    overflow: hidden;
}
.namedesc span {
    color: black;
    font-size: 2vw;
    font-weight: bold;
}
.namedesc p {
    font-size: 100%;
    margin-top: 20px;
    
}
.instructions, .ingredient-container{
    flex-basis: 47.5%;
    flex-grow: 0;
    flex-shrink: 0;
    min-height: 55vh;
    overflow-y: auto;
    padding: 10px 10px 10px 10px;
}
/* This section of CSS defines the EDIT button */
#span {
position: relative;
display: inline-flex;
width: 180px;
height: 55px;
margin: 20px;
perspective: 1000px;
float: right;
}
#span a{
font-size: 19px;
letter-spacing: 1px;
transform-style: preserve-3d;
transform: translateZ(-25px);
transition: transform .25s;
font-family: 'Montserrat', sans-serif;

}
#span a:before,
#span a:after{
position: absolute;
content: "EDIT";
height: 55px;
width: 180px;
display: flex;
align-items: center;
justify-content: center;
border: 5px solid black;
box-sizing: border-box;
border-radius: 5px;
}
#span a:before{
color: #fff;
background: #000;
transform: rotateY(0deg) translateZ(25px);
}
#span a:after{
color: #000;
background: #fff;
border: 5px solid cornsilk;
transform: rotateX(90deg) translateZ(25px);
}
#span a:hover{
transform: translateZ(-25px) rotateX(-90deg);
}
#delete {
float: right;
background-color: rgb(146, 4, 4);
width: 50px;
height: 50px;
text-align: center;
border-radius: 5px;
margin: 20px;
}
#delete i{
position: relative;
color: white;
font-size: 30px;
margin: 0;
top:20%;
}
</style>