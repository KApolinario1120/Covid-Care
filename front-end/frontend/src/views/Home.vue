<template>
    <div id="Home">
        <h1 id="welcome"><div id ="name">Meal Planner</div><span>Welcome, {{this.$store.state.user.username}}!!!!!!</span>
        </h1>
        <!-- <img src=".gif" alt="Name gif"> -->
        <h3 id="easy">Meal Planning Made Easy</h3>
        <p>Get organized with the Meal Planner. Customize your weekly meal plan based on your recipes.</p>
      <div class = "stepsContainer">
        <div class = "steps">
          <img class="step-image" src="https://www.eatwell101.com/wp-content/plugins/eric-meal-planner/assets/images/meal.jpg">
          <br>
          <span class="nums">1</span>
          <span class="step-text">Add Recipes</span>
        </div>
        <div class = "steps">
          <img class="step-image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS256s8dnj8IMnXjGqZw4FyQWomLGX9m0prWg&usqp=CAU">
          <br>
          <span class="nums">2</span>
          <span class="step-text">Customize Meal planner</span>
        </div>
        <div class = "steps">
          <img class="step-image" src="https://www.eatwell101.com/wp-content/plugins/eric-meal-planner/assets/images/bag.jpg">
          <br>
          <span class="nums">3</span>
          <span class="step-text">Customize Grocery List</span>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: "home"
  };
  </script>
  
  <style scoped>
  #Home h1 {
    text-align:left; font-size:50px; text-transform:uppercase; color:white; letter-spacing:5px;
    font-family:"Playfair Display", serif; font-weight:400;
  }
  #Home h1 span {
    margin-top: 5px;
    font-size:15px; color:white; word-spacing:1px; font-weight:normal; letter-spacing:3px;
    text-transform: uppercase; font-family:"Raleway", sans-serif; font-weight:500;
    display: grid;
    grid-template-columns: 1fr max-content 1fr;
    grid-template-rows: 27px 0;
    grid-gap: 20px;
    align-items: center;
  }
  #Home h1 span:after,#Home h1 span:before {
    content: " ";
    display: block;
    height: 5px;
    background-color:#f8f8f8;
  }
  #Home h3 {
    text-align:center; font-size:30px; text-transform:uppercase; color:white; letter-spacing:5px;
    font-family:"Playfair Display", serif; font-weight:200;
    padding-top: 2rem;
  }
  #name{
    text-align: center;
  }
  #Home p{
    text-align:center; font-size:15px; text-transform:uppercase; color:white; letter-spacing:1px;
    font-family:"Playfair Display", serif;
  }
  .stepsContainer {
      width: 100%;
      text-align: center;
  }
  .steps {
      text-align: center;
      display: inline-block;
      width: 360px;
      padding: 25px;
      box-sizing: border-box;
      font-size: 1.0rem;
      color:white;
      font-weight: bold;
  }
  .steps .step-image {
      display: inline-block;
      width: 100%;
      max-width: 130px;
      margin-bottom: 20px;
      
  }
  .steps .nums {
      display: inline-block;
      background: #007444;
      height: 30px;
      width: 30px;
      border-radius: 15px;
      color: #fff;
      font-weight: bold;
      font-size: 1.2rem;
  }
  .stepsContainer span {
      font-style: inherit;
      font-weight: inherit;
  }
  </style>