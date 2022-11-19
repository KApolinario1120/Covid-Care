<template>
    <div>
        <h1 class="headline">
            Covid Care Journal
        </h1>

        <div id="feedback" class=""></div>

        <div class="p-2"></div>

        <form onsubmit="return handleData()" method="post" action="https://postman-echo.com/post">
            <p>Select all the symptoms you're experiencing today below:</p>

            <section>
                <div>
                    <h2>General Symptoms</h2>
                    <input type="checkbox" name="langs" id="langs_fatigue" value="fatigue" > <label
                        for="langs_fatigue">Tiredness or fatigue</label>
                </div>

                <div>
                    <input type="checkbox" name="langs" id="langs_malaise" value="malaise"> <label
                        for="langs_malaise">Post-exertional malaise(Symptoms that get worse after physical or mental
                        effort) </label>
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
                        for="langs_lh">Lightheadedness when standing up</label>
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

                <div>
                    <input type="checkbox" name="langs" id="langs_other" value="other" > <label
                        for="langs_other">Other</label>
                </div>
            </section>

            <div>
                <input type="submit" name="submit" value="Submit" />
            </div>
        </form>


        <form>
            <div class="input-group">
                <label for="feelings">How are you feeling or what other symptoms are you experiencing today?</label>
                <textarea name="feelings" id="feelings" rows="7" class="input-item"
                    placeholder="Enter your feelings here"></textarea>
            </div>

            <div class="text-right">
                <input class="button" type="submit" id="save" value="Save">
            </div>
        </form>

        <div id="calanderholder">
            <h2 class="subtitle">Most recent entry</h2>

            <div class="container col-sm-4 col-md-7 col-lg-4 mt-5">
                <div class="card">
                    <h3 class="card-header" id="monthAndYear"></h3>

                    <table class="table table-bordered table-responsive-sm" id="calendar">
                        <thead>
                            <tr>
                                <th>Sun</th>
                                <th>Mon</th>
                                <th>Tue</th>
                                <th>Wed</th>
                                <th>Thu</th>
                                <th>Fri</th>
                                <th>Sat</th>
                            </tr>
                        </thead>

                        <tbody id="calendar-body"></tbody>
                    </table>

                    <div class="form-inline">

                        <button class="btn btn-outline-primary col-sm-6" id="previous"
                            onclick="previous()">Previous</button>

                        <button class="btn btn-outline-primary col-sm-6" id="next" onclick="next()">Next</button>
                    </div>

                    <br />

                    <form class="form-inline">
                        <label class="lead mr-2 ml-2" for="month">Jump To: </label>

                        <select class="form-control col-sm-4" name="month" id="month" onchange="jump()">
                            <option value=0>Jan</option>
                            <option value=1>Feb</option>
                            <option value=2>Mar</option>
                            <option value=3>Apr</option>
                            <option value=4>May</option>
                            <option value=5>Jun</option>
                            <option value=6>Jul</option>
                            <option value=7>Aug</option>
                            <option value=8>Sep</option>
                            <option value=9>Oct</option>
                            <option value=10>Nov</option>
                            <option value=11>Dec</option>
                        </select>

                        <label for="year"></label><select class="form-control col-sm-4" name="year" id="year"
                            onchange="jump()">
                            <option value=1990>1990</option>
                            <option value=1991>1991</option>
                            <option value=1992>1992</option>
                            <option value=1993>1993</option>
                            <option value=1994>1994</option>
                            <option value=1995>1995</option>
                            <option value=1996>1996</option>
                            <option value=1997>1997</option>
                            <option value=1998>1998</option>
                            <option value=1999>1999</option>
                            <option value=2000>2000</option>
                            <option value=2001>2001</option>
                            <option value=2002>2002</option>
                            <option value=2003>2003</option>
                            <option value=2004>2004</option>
                            <option value=2005>2005</option>
                            <option value=2006>2006</option>
                            <option value=2007>2007</option>
                            <option value=2008>2008</option>
                            <option value=2009>2009</option>
                            <option value=2010>2010</option>
                            <option value=2011>2011</option>
                            <option value=2012>2012</option>
                            <option value=2013>2013</option>
                            <option value=2014>2014</option>
                            <option value=2015>2015</option>
                            <option value=2016>2016</option>
                            <option value=2017>2017</option>
                            <option value=2018>2018</option>
                            <option value=2019>2019</option>
                            <option value=2020>2020</option>
                            <option value=2021>2021</option>
                            <option value=2022>2022</option>
                            <option value=2023>2023</option>
                            <option value=2024>2024</option>
                            <option value=2025>2025</option>
                            <option value=2026>2026</option>
                            <option value=2027>2027</option>
                            <option value=2028>2028</option>
                            <option value=2029>2029</option>
                            <option value=2030>2030</option>
                        </select>
                    </form>
                </div>
            </div>

            <section>
                <h3 class="subtitle-secondary">Extra Notes</h3>
                <div class="entry-item" id="content"></div>
            </section>

        </div>
    </div>
</template>
    
    
<script>
import AuthService from '../services/AuthService.js'
export default {
    name: 'journal-entry',
    data() {
        return {
            ingredients: [],
            ingredient: '',
            ingredientMeasurement: null,
            ingredientQuantity: null,
            appliances: [],
            appliance: '',
            name: '',
            recipePhoto: '',
            description: '',
            instructions: '',
            servings: null,
            difficulty: 1,
            ingredientList: [],
            // List of search ingredients returned from DB
            applianceList: []
        }
    },
    methods: {
        addSymptomToArray() {
            console.log(this.symptoms)
            // TODO
            let ingredientObject = {
                ingredient_id: null,
                name: this.ingredient,
                quantity: this.ingredientQuantity,
                measurement: this.ingredientMeasurement
            }
            for (let index = 0; index < this.ingredientList.length; index++) {
                if (this.ingredient.toLowerCase().trim() === this.ingredientList[index].name.toLowerCase().trim()) {
                    ingredientObject.ingredient_id = this.ingredientList[index].id;
                }
            }
            if (ingredientObject.quantity == null || ingredientObject.quantity == '' || ingredientObject.measurement == null || ingredientObject.measurement == '') {
                alert("Ingredient needs measurement and quantity.");
            } else {
                this.ingredients.push(ingredientObject);
                console.log(this.ingredients);
            }

        },
        removeIngredientFromArray(ingredient) {
            this.ingredients = this.ingredients.filter(element => {
                return element !== ingredient;
            })
        },
        addApplianceToArray() {
            let applianceObject = {
                id: null,
                name: this.appliance
            }
            for (let index = 0; index < this.applianceList.length; index++) {
                if (this.appliance.toLowerCase().trim() === this.applianceList[index].name.toLowerCase().trim()) {
                    applianceObject.id = this.applianceList[index].id;
                }
            }
            this.appliances.push(applianceObject);
            console.log(this.appliances);
        },
        removeApplianceFromArray(appliance) {
            this.appliances = this.appliances.filter(element => {
                return element !== appliance;
            })
        },
        submitRecipe() {
            console.log(this.getRecipe);
            if (this.name !== '' && this.instructions !== '') {
                AuthService.addRecipe(this.getRecipe)
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
html,
body {
    height: 100%;
    width: 100%;
}

body {
    font-size: 16px;
    font-family: -apple-system, BlinkMacSystemFont, sans-serif;
    padding: 0;
    margin: 0;
    color: #333333;
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
}

#feedback {
    padding: 1em;
    border-radius: 0.25em;
    transition: all 0.5 ease-in-out;
}

.error {
    border: 1px solid #F00;
    color: #F00;
}

.success {
    border: 1px solid #018601;
    color: #018601;
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