<template>
    <div>
    
    <div class="mx-auto col-md-7" >
    
    <h1 class="text-center"> Today's Journal </h1>
    
    <br>
    <br>
    <br>
    <form>
    
    <!-- username -->
        <label for="username">Username:</label>
        <b-form-group
            id="fieldset-1"
            description="What is your username?"
            label="username:"
            label-for="username">
            <b-form-input id="username" v-model="username" trim></b-form-input>
        </b-form-group>

    <!-- password -->
        <br>
        <br>
        <label for="password">Password:</label>
        <b-form-group
            id="fieldset-1"
            description="What is your password?"
            label="password:"
            label-for="password">
            <b-form-input id="password" v-model="password" trim></b-form-input>
        </b-form-group>

    <!-- notes -->
        <br>
        <br>
        <label for="notes">Notes:</label>
        <b-form-textarea
            id="notes"
            v-model="description"
            placeholder="add multiple lines"
            rows="3"
            max-rows="6"
        ></b-form-textarea>

        <br>
        <br>
    <!-- temperature -->
            <label for="temperature">Temperature:</label>
        <b-form-group
            id="fieldset-1"
            description="Did you measure your temperature today?"
            label="temperature:"
            label-for="temperature">
            <b-form-input id="temperature" v-model="temperature" trim></b-form-input>
        </b-form-group>

    <!-- symptom check boxes -->
        <br>
        <br>
        <b-form-group label="Using options array:" v-slot="{ ariaDescribedby }">
      <b-form-checkbox-group
        id="checkbox-group-1"
        v-model="selected"
        :options="options"
        :aria-describedby="ariaDescribedby"
        name="flavour-1"
      ></b-form-checkbox-group>
    </b-form-group>

    <b-form-group label="Using sub-components:" v-slot="{ ariaDescribedby }">
      <b-form-checkbox-group
        id="checkbox-group-2"
        v-model="selected"
        :aria-describedby="ariaDescribedby"
        name="flavour-2"
      >
        <b-form-checkbox value="fatigue">Tiredness or fatigue that interferes with daily life</b-form-checkbox>
        <b-form-checkbox value="post-exertional malaise">Symptoms that get worse after physical or mental effort (also known as “post-exertional malaise”)</b-form-checkbox>
        <b-form-checkbox value="fever">Fever</b-form-checkbox>
        <b-form-checkbox value="shortness of breath">Difficulty breathing or shortness of breath</b-form-checkbox>
        <b-form-checkbox value="cough">Cough</b-form-checkbox>
        <b-form-checkbox value="chest pain">Chest pain</b-form-checkbox>
        <b-form-checkbox value="heart palpitations">Fast-beating or pounding heart (also known as heart palpitations)</b-form-checkbox>
        <b-form-checkbox value="difficulty thinking or concentration">Difficulty thinking or concentrating (sometimes referred to as “brain fog”)</b-form-checkbox>
        <b-form-checkbox value="Headache">Headache</b-form-checkbox>
        <b-form-checkbox value="Sleep problems">Difficulty sleeping or waking</b-form-checkbox>
        <b-form-checkbox value="dizziness">Dizziness when you stand up (lightheadedness)</b-form-checkbox>
        <b-form-checkbox value="Pins-and-needles feelings">Pins-and-needles feelings</b-form-checkbox>
        <b-form-checkbox value="Change in smell or taste">Change in smell or taste</b-form-checkbox>
        <b-form-checkbox value="Depression or anxiety">Depression or anxiety</b-form-checkbox>
        <b-form-checkbox value="Diarrhea">Diarrhea</b-form-checkbox>
        <b-form-checkbox value="Stomach pain">Stomach pain</b-form-checkbox>
        <b-form-checkbox value="Joint or muscle pain">Joint or muscle pain</b-form-checkbox>
        <b-form-checkbox value="Rash">Rash</b-form-checkbox>
        <b-form-checkbox value="Changes in menstrual cycles">Changes in menstrual cycles</b-form-checkbox>
      </b-form-checkbox-group>
    </b-form-group>
        
      </form>
      </div>
      </div>
    </template>
    
    <script>
    import AuthService from '../services/AuthService.js'
    export default {
        name: 'journal-entry',
        data () {
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
                applianceList: [],
                // List of search appliances returned from DB
                servingOptions: [
                    {value: '1', text: '1'}, 
                    {value: '2', text: '2'},
                    {value: '3', text: '3'},
                    {value: '4', text: '4'},
                    {value: '5', text: '5'},
                    {value: '6', text: '6'},
                    {value: '7', text: '7'},
                    {value: '8', text: '8'},
                    {value: '9', text: '9'},
                    {value: '10', text: '10'},
                    {value: '11', text: '11'},
                    {value: '12', text: '12'},
                    {value: '13', text: '13'},
                    {value: '14', text: '14'},
                    {value: '15', text: '15'},
                ],
                measurementOptions: [
                    {value: 'bunch', text: 'bunch'},
                    {value: 'cup', text: 'cup'},
                    {value: 'fluid oz', text: 'fluid oz'},
                    {value: 'ft', text: 'ft'},
                    {value: 'gal', text: 'gal'},
                    {value: 'gm', text: 'gm'},
                    {value: 'in', text: 'in'},
                    {value: 'lbs', text: 'lbs'},
                    {value: 'L', text: 'L'},
                    {value: 'ml', text: 'ml'},
                    {value: 'mg', text: 'mg'},
                    {value: 'oz', text: 'oz'},
                    {value: 'pinch', text: 'pinch'},
                    {value: 'pt', text: 'pt'},
                    {value: 'tbsp', text: 'tbsp'},
                    {value: 'tsp', text: 'tsp'},
                    {value: 'unit', text: 'unit'},
                    {value: 'whole', text: 'whole'}
                    
                ]
            }
        },
        methods: {
            addIngredientToArray(){
                console.log(this.ingredients)
                let ingredientObject = {
                    ingredient_id: null,
                    name: this.ingredient,
                    quantity: this.ingredientQuantity,
                    measurement: this.ingredientMeasurement
                }
                for (let index = 0; index < this.ingredientList.length; index++) {
                    if (this.ingredient.toLowerCase().trim() === this.ingredientList[index].name.toLowerCase().trim()){
                        ingredientObject.ingredient_id = this.ingredientList[index].id;
                    }
                }
                if(ingredientObject.quantity == null || ingredientObject.quantity == '' || ingredientObject.measurement == null || ingredientObject.measurement == '' ) {
                    alert("Ingredient needs measurement and quantity.");
                } else {
                    this.ingredients.push(ingredientObject);
                    console.log(this.ingredients);
                }
                
            },
            removeIngredientFromArray(ingredient) {
                this.ingredients = this.ingredients.filter( element => {
                    return element !== ingredient;
                })
            },
            addApplianceToArray(){
                let applianceObject = {
                    id: null,
                    name: this.appliance
                }
                for (let index = 0; index < this.applianceList.length; index++) {
                    if(this.appliance.toLowerCase().trim() === this.applianceList[index].name.toLowerCase().trim()){
                        applianceObject.id = this.applianceList[index].id;
                    }
                }
                this.appliances.push(applianceObject);
                console.log(this.appliances);
            },
            removeApplianceFromArray(appliance) {
                this.appliances = this.appliances.filter( element => {
                    return element !== appliance;
                })
            },
            submitRecipe(){
                console.log(this.getRecipe);
                if(this.name !== '' && this.instructions !== '') {
                    AuthService.addRecipe(this.getRecipe)
                    .then((response) => {
                        console.log(response.data);
                        this.$router.push('/recipes/'+response.data.id);
                })
                } else {
                    alert("Recipe name and instructions cannot be empty");
                }
            },
            searchIngredientList(){
                this.ingredientList = [];
                if(this.ingredient !== '') {
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
            searchApplianceList(){
                this.applianceList = [];
                if(this.appliance !== '') { 
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

    label {
        font-weight: bold;
        margin-left: 20px;
        font-family:"Raleway", serif;
        font-size: 23px;
        color: rgb(82, 82, 82);
    }
    .mx-auto {
        padding-top: 20px;
        margin-top: 20px;
        /* border: 5px solid rgb(230, 213, 195);
        background-color: cornsilk; */
        border-radius: 10px;
    }

    h1 {
        text-align: center;
        font-family:"Raleway", serif;
    }
    </style>