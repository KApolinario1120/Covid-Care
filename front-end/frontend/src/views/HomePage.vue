<template>
    <div id="Home">
        <h1 id="welcome">
            <div id ="name">Covid Care</div>
            <span>Welcome to our Website!!!!!</span>
        </h1>
        
        <h3 id="easy">Click on the nav bar above to log your journal entries</h3>
    </div>
</template>

<script>
export default {
name: "home-page"
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
</style>