<template>
    <div id="Home">
        <h1 id="welcome">
            <div id ="name">Covid Care</div>
            <span>Track your Covid-19 symptoms here</span>
        </h1>
        <iframe src="https://ourworldindata.org/explorers/coronavirus-data-explorer?zoomToSelection=true&time=2020-03-01..latest&facet=none&pickerSort=desc&pickerMetric=new_cases_per_million&Metric=Confirmed+cases&Interval=7-day+rolling+average&Relative+to+Population=true&Color+by+test+positivity=false&country=IND~USA~GBR~CAN~DEU~JPN&hideControls=true" loading="lazy" style="width: 100%; height: 600px; border: 0px none;"></iframe>
        
        <!-- <h3 id="easy">To learn more about long COVID, please watch the video below.</h3> -->
        <h1><span>What is long COVID exactly? Scroll down to learn more.</span></h1>

        <div id="information-long-covid">
            <div id="text-explanation">
                <h4>The NIH offers several resources available to help make sense of long COVID symptoms.</h4>
                <p>"Many people recover fully within a few days or weeks after being infected with SARS-CoV-2, the virus that causes COVID-19. But others have symptoms that linger for weeks, months, or even years after their initial diagnosis. Some people seem to recover from COVID-19 but then see their symptoms return, or they develop new symptoms within a few months. Even people who had no symptoms when they were infected can develop symptoms later. Either mild or severe COVID-19 can lead to long-lasting symptoms."</p>
                <a href="https://covid19.nih.gov/covid-19-topics/long-covid#long-covid-resources-1">Click here to read more</a>
                </div>
            <div id="video">
                <iframe width=600ren height="400" src="https://www.youtube.com/embed/h5VM7-9cAnE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </div>
        </div>
    
    </div>
</template>

<script>
export default {
name: "home-page"
};
</script>

<style scoped>
#information-long-covid {
    display: flex;
    flex-direction: row;
    flex-grow: 1;
    justify-content: space-around;
    padding: 20px, 20px, 20px, 20px;
    margin: 40px, 40px, 40px, 40px;
}
#video {
    display: flex;
    flex-direction: column;
    padding-top:0px;
    padding: 20px;
}
#text-explanation{
    padding-top:0px;
    flex-direction: column;
    font-size: 20px;
    padding: 20px;
    display: flex;
    align-items: center;
    justify-content: center;
}
iframe {
    border-radius: 5%;
}
#Home h1 {
text-align:left; font-size:50px; text-transform:uppercase; color:black; letter-spacing:5px;
font-family:"Railway", serif; font-weight:400;
}
#Home h1 span {
margin-top: 5px;
font-size:15px; color:black; word-spacing:1px; font-weight:normal; letter-spacing:3px;
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
background-color:rgb(241, 123, 155);
}
#Home h3 {
text-align:center; font-size:30px; color:black; letter-spacing:5px;
font-family:"Railway", serif; font-weight:200;
line-height: 50px;
padding-top: 2rem;
padding-left: 5rem;
padding-right: 5rem;
}
h4 {
    text-align: center;
}
#name{
text-align: center;
}
#text-explanation a{
    font-weight: bold;
}
#Home p{
text-align:center; font-size:20px; color:black; letter-spacing:1px;
font-family:"Railway", serif; font-style: italic;
}
</style>