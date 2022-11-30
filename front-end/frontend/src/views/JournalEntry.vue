<template>
    <div>
        <h1 class="headline">
            Covid Care Journal
        </h1>

        <div id="feedback" class=""></div>

        <div class="p-2"></div>

        <div id="form-div">
        <form id="first-form" onsubmit="return handleData()" method="post" action="https://postman-echo.com/post">
            <p>Select all the symptoms you're experiencing today below:</p>

            <section>
                <div>
                    <h2>General Symptoms</h2>
                    <input type="checkbox" name="langs" id="langs_fatigue" value="fatigue" > <label
                        for="langs_fatigue">Tiredness or fatigue</label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_malaise" value="malaise"> <label
                        for="langs_malaise">Post-exertional malaise (Symptoms that get worse after physical or mental
                        exertion) </label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_fever" value="fever"> <label
                        for="langs_fever">Fever</label>
                </div>
            </section>

            <section>
                <h2>Respiratory and heart symptoms</h2>
                <div>
                    <input type="checkbox" name="langs" id="langs_breath" value="breath" > <label
                        for="langs_breath">Difficulty breathing or shortness of breath</label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_cough" value="cough" > <label
                        for="langs_cough">Cough</label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_chestpain" value="chestpain" > <label
                        for="langs_chestpain">Chest pain</label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_heart" value="heart" > <label
                        for="langs_heart">Heart palpitations</label>
                </div>
            </section>

            <section>
                <h2>Neurological symptoms</h2>
                <div>
                    <input type="checkbox" name="langs" id="langs_brain" value="brain" > <label
                        for="langs_brain">Brain fog</label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_heart" value="heart" > <label
                        for="langs_heart">Headache</label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_sleep" value="sleep" > <label
                        for="langs_sleep"> Sleep problems</label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_lh" value="lh" > <label
                        for="langs_lh">Dizziness or Light-headedness when standing</label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_pn" value="pn" > <label
                        for="langs_pn">Pins-and-needles feelings</label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_smell" value="smell" > <label
                        for="langs_smell">Change in smell or taste</label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_da" value="da" > <label
                        for="langs_da">Depression or anxiety</label>
                </div>
            </section>

            <section>
                <h2>Digestive symptoms</h2>
                <div>
                    <input type="checkbox" name="langs" id="langs_diarrhea" value="" > <label
                        for="langs_diarrhea">Diarrhea</label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_stomach" value="stomach" > <label
                        for="langs_stomach">Stomach pain</label>
                </div>
            </section>

            <section>
                <h2>Other symptoms</h2>
                <div>
                    <input type="checkbox" name="langs" id="langs_jm" value="jm" > <label for="langs_jm">Joint or
                        muscle pain</label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_rash" value="rash" > <label
                        for="langs_rash">Rash</label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_period" value="period" > <label
                        for="langs_period">Changes in menstrual cycles</label>
                </div>

                <div id="other">
                    <input type="checkbox" name="langs" id="langs_other" value="other" > <label
                        for="langs_other">Other</label>
                </div>
            </section>
        

            <!-- <div >
                <input id="submit" type="submit" name="submit" value="Submit" />
            </div> -->
        </form>
    </div>


        <form id="input-group-form">
            <div class="input-group">
                <textarea name="feelings" id="feelings" rows="7" class="input-item"
                    placeholder="Enter your feelings here"></textarea>
            </div>

            <!-- <div class="text-right">
                <input class="button" type="submit" id="save" value="Save">
            </div> -->
        </form>

        <label for = "start" id="date-start"> 
            <h2>Enter Date: </h2>
        </label>
        <div id="date-button">
        <input type ="date" id="start" name="date" value="2020-01-01">
        </div>
    </div>
</template>
    
    
<script>
import AuthService from '../services/AuthService.js'
export default {
    name: 'journal-entry',
    data() {
        return {
            symptomList: [],
            journalEntry: {}
        }
    },
    methods: {
        addSymptomToArray() {
            console.log(this.symptoms)
            return null;

        },

        submitJournal() {
            console.log(this.getRecipe);
            if (this.name !== '' && this.instructions !== '') {
                AuthService.addJournalEntry(this.getRecipe)
                    .then((response) => {
                        console.log(response.data);
                        this.$router.push('/recipes/' + response.data.id);
                    })
            } else {
                alert("Recipe name and instructions cannot be empty");
            }
        },

        searchIngredientList() {
            this.ingredientList = [];
            if (this.ingredient !== '') {
                console.log(this.ingredient);
                AuthService.findIngredient(this.ingredient)
                    .then((response) => {
                        response.data.forEach(element => {
                            this.ingredientList.push(element);
                        });
                    })
                console.log(this.ingredientList);
            }
        },
        searchApplianceList() {
            this.applianceList = [];
            if (this.appliance !== '') {
                AuthService.findAppliance(this.appliance)
                    .then((response) => {
                        response.data.forEach(element => {
                            this.applianceList.push(element);
                        });
                    })
                console.log(this.applianceList);
            }
        }
    },
    computed: {
        getJournal() {
            return {
                name: this.name,
                photo_url: this.recipePhoto,
                description: this.description,
                instructions: this.instructions,
                servings: Number(this.servings),
                difficulty: Number(this.difficulty),
                ingredientList: this.ingredients,
                applianceList: this.appliances
            }
        }
    }
}
</script>
    
<style scoped>
h1 {
    font-family: 'Railway', sans-serif;
    text-align: center;
}
#div-form {
    padding: 40px;
    margin: 40px, 40px, 40px, 40px;
}
#first-form {
    background-color: rgb(255, 250, 244);
    margin-left: 50px;
    margin-right: 50px;
    border-radius: 15px;
    padding-left: 75px;
    padding-top: 30px;
    margin: 40px, 40px, 40px, 40px;
}
section, p {
    padding-left: 20px;
    line-height: 25px;
}
html,
body {
    height: 100%;
    width: 100%;
    padding: 25px;
}

body {
    font-size: 25px;
    font-family: -apple-system, BlinkMacSystemFont, sans-serif;
    padding: 0;
    margin: 0;
    color: #333333;
}

#submit {
    display: flex;
    justify-content: space-around;
    padding: 7.5px;
    margin: 20px, 20px, 20px, 20px;

}

#date-start {
    padding: 20px;
}

.wrapper {
    height: 100vh;
    display: grid;
    grid-template-columns: 100%;
    padding: 3em;
    justify-content: center;
    grid-gap: 1em;
    font-family: 'Oswald', sans-serif;
}

.headline {
    font-size: 3em;
}

.subtitle {
    font-size: 2em;
}

.subtitle-secondary {
    font-size: 1.75em;
}

.input-group {
    margin-bottom: 2em;
    background-color: rgb(255, 250, 244);
    border-radius: 10px;
    padding: 40px;
    border-color: rgb(243, 219, 96);
    color: black;
}
#feelings {
    color: black;
}

.input-item {
    width: 100%;
    padding-top: 0.75em;
    font-size: 1.5em;
    font-family: 'Oswald', sans-serif;
    background: transparent;
    outline: none !important;
    border: none;
    border-radius: 0 !important;
    -webkit-appearance: none;
    border-bottom: 1px solid #979797;
    -webkit-transition: all 0.3s ease-in-out;
    -moz-transition: all 0.3s ease-in-out;
    -o-transition: all 0.3s ease-in-out;
    -ms-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
    font-weight: 400;
    color: #575757;
}

.text-right {
    text-align: right;
}

.text-capitalize {
    text-transform: capitalize;
}

.button {
    font-size: 1.5em;
    background-color: #575757;
    font-family: 'Owsald', sans-serif;
    color: #FFF;
    padding: 0.5em 1.25em;
    cursor: pointer;
    text-align: left;
}

#feedback {
    padding: 1em;
    border-radius: 0.25em;
    transition: all 0.5 ease-in-out;
}
#input-group-form {
    padding: 20px;
    padding-left: 50px;
    padding-right: 50px;
    color: black;
    font-family: Owsald;
}

#date-start {
    display: flex;
    justify-content: space-around;
    flex-direction: row;
}

#start {
    display: block;
    font: 2rem 'Raleway', serif;
    margin: .4rem 0;
    padding: 20px;
}

#date-button {
    align-items: center;
    display: flex;
    justify-content: center;
    align-items: center;
    padding-bottom: 40px;
    margin-bottom: 40px;
}

.error {
    border: 1px solid #F00;
    color: #F00;
}
#other {
    padding-bottom: 20px;
}

.success {
    border: 1px solid #018601;
    color: #018601;
}

::placeholder {
    color: black;
}

/* label {
        font-weight: bold;
        margin-left: 20px;
        font-family:"Raleway", serif;
        font-size: 23px;
        color: rgb(82, 82, 82);
    }
    .mx-auto {
        padding-top: 20px;
        margin-top: 20px;
        border: 5px solid rgb(230, 213, 195);
        background-color: cornsilk;
        border-radius: 10px;
    }

    h1 {
        text-align: center;
        font-family:"Raleway", serif;
    } */
</style>