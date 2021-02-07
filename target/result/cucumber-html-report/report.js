$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/weatherForecast.feature");
formatter.feature({
  "line": 2,
  "name": "Weather Forecast",
  "description": "",
  "id": "weather-forecast",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@weather"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "As a choosy surfer",
  "description": "",
  "id": "weather-forecast;as-a-choosy-surfer",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "I like to surf in any 2 beaches \u003cOut of top ten\u003e of Sydney",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I only like to surf on any 2 days specifically \"Thursday \u0026 Friday\" in next 16 Days",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I look up the the weather forecast for the next 16 days using POSTAL CODES",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I check to if see the temperature is between \"20\" and \"30\"",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "I check to see if UV index is \u003c\u003d 3",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I Pick two spots based on suitable weather forecast for the day",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 22
    }
  ],
  "location": "WeatherForecast.i_like_to_surf_in_any_beaches_Out_of_top_ten_of_Sydney(String)"
});
formatter.result({
  "duration": 3643625200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 27
    },
    {
      "val": "Thursday \u0026 Friday",
      "offset": 48
    },
    {
      "val": "16",
      "offset": 75
    }
  ],
  "location": "WeatherForecast.i_only_like_to_surf_on_any_days_specifically_Thursday_Friday_in_next_Days(int,String,int)"
});
formatter.result({
  "duration": 749473900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "16",
      "offset": 48
    }
  ],
  "location": "WeatherForecast.i_look_up_the_the_weather_forecast_for_the_next_days_using_POSTAL_CODES(int)"
});
formatter.result({
  "duration": 1366350600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 46
    },
    {
      "val": "30",
      "offset": 55
    }
  ],
  "location": "WeatherForecast.i_check_to_if_see_the_temperature_is_between_and(int,int)"
});
formatter.result({
  "duration": 115700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 33
    }
  ],
  "location": "WeatherForecast.i_check_to_see_if_UV_index_is(float)"
});
formatter.result({
  "duration": 44661100,
  "status": "passed"
});
formatter.match({
  "location": "WeatherForecast.i_Pick_two_spots_based_on_suitable_weather_forecast_for_the_day()"
});
formatter.result({
  "duration": 174188700,
  "status": "passed"
});
});