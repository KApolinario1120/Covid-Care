<template>
    <div>
    
    <div class="mx-auto col-md-7" >
    
    <h1 class="text-center"> Create Recipe </h1>
    
    <br>
    <form>
    
    <!-- recipe name -->
        <b-form-group
            id="fieldset-1"
            description="What is your recipe called?"
            label="Recipe Name:"
            label-for="recipe-name">
            <b-form-input id="recipe-name" v-model="name" trim></b-form-input>
        </b-form-group>
    
    <!-- recipe photo -->
    
        <b-form-group
            id="fieldset-1"
            description="Enter the url for your photo"
            label="Recipe photo:"
            label-for="recipe-photo">
            <b-form-input id="recipe-photo" v-model="recipePhoto" trim required></b-form-input>
        </b-form-group>
    
    <!-- description -->
    
        <br>
        <label for="description">Description:</label>
        <b-form-textarea
            id="description"
            v-model="description"
            placeholder=""
            rows="3"
            max-rows="6"
        ></b-form-textarea>
        
    <!-- Add ingredient -->
    
        <br>
        <label for="ingredient-input" >Ingredients:</label> 
        <ul id="ingredient-input" style="list-style-type:none;">
            <div style="margin: 2px;" class="d-flex" v-for="ingredient in ingredients" v-bind:key="ingredient">
            <div>
                <li>{{ingredient.quantity}} {{ingredient.measurement}} {{ingredient.name}}</li>
            </div>
            <div class="ml-auto">
                <button class="btn btn-danger btn-sm" v-on:click.prevent="removeIngredientFromArray(ingredient)">X</button>
            </div>
            </div>
        </ul>
        <b-container fluid>
    
            <b-row>
                 
                <!-- Quantity -->
                <b-col sm="3">
                    <b-form-input v-model="ingredientQuantity" placeholder="Quantity"></b-form-input>
                </b-col>
    
                <!-- Measurement -->
                <b-col sm="3">
                    <b-form-select placeholder="measurement" v-model="ingredientMeasurement" :options="measurementOptions">
                        <template #first>
                            <b-form-select-option :value="null" disabled>Measurement</b-form-select-option>
                        </template>
                    </b-form-select>
                <!-- <b-form-input v-model="ingredientMeasurement" placeholder="Measurement"></b-form-input> -->
                </b-col>
    
                <!-- Ingredient search -->
                <b-col sm="5">
                    <b-form-input name="ingredient-input" list="ingredient-list" id="ingredient-input" v-model="ingredient" v-on:keyup="searchIngredientList()" v-on:keydown.enter.prevent="addIngredientToArray()" placeholder="Add ingredient"></b-form-input>
                </b-col>
                <datalist id="ingredient-list">
                <option v-for="ingredient in ingredientList" v-bind:key="ingredient">
                    {{ingredient.name}}
                </option>
                </datalist>
    
                <!-- Add Ingredient Button -->
                <b-col sm="1">
                    <button class="btn btn-success" v-on:click.prevent="addIngredientToArray()">Add</button>
                </b-col>
    
            </b-row>
    
        </b-container>
    
    <!-- Serving Size -->
    
        <br>
        <label for="servings">Servings:</label>
        <b-form-select id="servings" v-model="servings" :options="servingOptions">
            <template #first>
            <b-form-select-option :value="null" disabled>-- How many servings does this recipe make? --</b-form-select-option>
          </template>
        </b-form-select>
        <br>
    
    <!-- Add appliance -->
    
        <br>
        <label for="appliance-input">Appliances:</label> 
        <ul id="appliance-input" style="list-style-type:none;">
            <div style="margin: 2px;" class="d-flex" v-for="appliance in appliances" v-bind:key="appliance">
            <div>
                <li>{{appliance.name}}</li>
            </div>
            <div class="ml-auto">
                <button class="btn btn-danger btn-sm" v-on:click.prevent="removeApplianceFromArray(appliance)">X</button>
            </div>
            </div>
        </ul>
        <b-container fluid>
            <b-row class="my-1">
                <b-col sm="11">
                    <b-form-input list="appliance-list" id="appliance-input" v-model="appliance" v-on:keyup="searchApplianceList()"  v-on:keydown.enter.prevent="addApplianceToArray()" placeholder="Add appliance"></b-form-input>
                </b-col>
                <b-col sm="1">
                    <button class="btn btn-success" v-on:click.prevent="addApplianceToArray()">Add</button>
                </b-col>
            </b-row>
        </b-container>
    
        <datalist id="appliance-list">
            <option v-for="appliance in applianceList" v-bind:key="appliance">
                {{appliance.name}}
            </option>
        </datalist>
       
    <!-- Recipe instructions -->
    
        <br>
        <label for="instructions">Instructions:</label>
        <b-form-textarea
          id="instructions"
          v-model="instructions"
          placeholder=""
          rows="6"
          max-rows="12"
        ></b-form-textarea>
        <br>
    
    <!-- Difficulty bar -->
    
        <br>
        <label for="difficulty-range">Difficulty: {{ difficulty }}</label>
        <b-form-input id="difficulty-range" v-model="difficulty" type="range" min="1" max="10"></b-form-input>
    
        <br><br>
        <div class="text-center">
            <button class="btn btn-primary" v-on:click.prevent="submitRecipe()" type="submit">Save to Recipe List</button>
        </div>
        <br>
      </form>
      </div>
      </div>
    </template>
    
    
    
    
    <script>
    import AuthService from '../services/AuthService.js'
    export default {
        name: 'create-recipe',
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
            getRecipe() {
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
    }
    .mx-auto {
        border: 5px solid rgb(230, 213, 195);
        background-color: cornsilk;
        border-radius: 10px;
    }
    </style>