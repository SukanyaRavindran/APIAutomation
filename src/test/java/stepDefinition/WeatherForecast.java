package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import services.TestBase;

import static io.restassured.RestAssured.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WeatherForecast extends TestBase{

	Response response;
	Response postCodeResponse1;
	ArrayList<String> dateRequired = new ArrayList<String>();
	ArrayList<Integer> tempRequired = new ArrayList<Integer>();
	List<Integer> temperature;
	ArrayList<Float> uvRequired = new ArrayList<Float>();
	List<Float> uvList;
	List<String> dateList;
	List<String> responseDateUsingPostCode;
	int indexArray[] = new int[4];
	int index = 0;
	

	@Given("^I like to surf in any (\\d+) beaches <Out of top ten> of Sydney$")
	public void i_like_to_surf_in_any_beaches_Out_of_top_ten_of_Sydney(String arg1) throws Throwable {
		response = 
		given()
		.when()
		.get(cityParamBaseUrI);
	}

	@And("^I only like to surf on any (\\d+) days specifically \"([^\"]*)\" in next (\\d+) Days$")
	public void i_only_like_to_surf_on_any_days_specifically_Thursday_Friday_in_next_Days(int arg1, String str, int arg3) throws Throwable {

		String[] splitted = str.split("\\s+");	
		dateList = response.jsonPath().getList("data.valid_date");
		
	    for(String date:dateList)
	    {
	        LocalDate localDate = LocalDate.parse(date);
	        DayOfWeek day = localDate.getDayOfWeek();

	        if((day.toString().equalsIgnoreCase(splitted[0])) || (day.toString().equalsIgnoreCase(splitted[2]))) {
	        	dateRequired.add(date);
	        }
	    }
	    
	    System.out.println("Date matches the given specified days " + str + " are \n");
	    for(String loop:dateRequired) {
	    	System.out.println(loop);
	    }
	}

	@When("^I look up the the weather forecast for the next (\\d+) days using POSTAL CODES$")
	public void i_look_up_the_the_weather_forecast_for_the_next_days_using_POSTAL_CODES(int arg1) throws Throwable {

		postCodeResponse1 =
		given()
		.when()
		.get(postCodeParamBaseUrI);
		
		responseDateUsingPostCode = postCodeResponse1.jsonPath().getList("data.valid_date");
		temperature = postCodeResponse1.jsonPath().getList("data.temp");
		
		for(String loop1:dateRequired) {
			int counter = 0;
			for(String loop2:responseDateUsingPostCode) {	
				if(loop1.equals(loop2)) {				
				//	System.out.println(temperature.get(counter));
					indexArray[index] = counter;
					index++;
		    	}
				counter++;
			}
		}
		 
		System.out.println("\nPrinting temperatures of Thursday and Friday in next 16 days: \n");
		for(int i=0; i<index; i++) {
			System.out.println(temperature.get(indexArray[i]));
		}
	}

	@Then("^I check to if see the temperature is between \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_check_to_if_see_the_temperature_is_between_and(int lowT, int highT) throws Throwable {
		/*for(int i=0; i<index; i++) {
			if((temperature.get(indexArray[i]) > lowT) || (temperature.get(indexArray[i]) < highT)) {
				tempRequired.add(temperature.get(indexArray[i]));
			}
		}*/
	}

	@Then("^I check to see if UV index is <= (\\d+)$")
	public void i_check_to_see_if_UV_index_is(float arg1) throws Throwable {
		uvList = postCodeResponse1.jsonPath().getList("data.uv");
		int dateIndex = 0;
		int dateIndexArray[] = new int[4];
		
		int i=0;
		for(String loop1:dateRequired) {
			int counter = 0;
			for(String loop2:responseDateUsingPostCode) {
				if(loop1.equals(loop2)) {
					if(uvList.get(counter) <= arg1) {	
						uvRequired.add(uvList.get(counter));
						dateIndexArray[i] = dateIndex;
						i++;
					}
				}
				counter++;
			}
			dateIndex++;
		}
			
	    for(Float loop:uvRequired) {
	    	System.out.println("\nUV value on " + dateRequired.get(dateIndexArray[i-1]) + " is " + loop + " which is less than " + arg1);
	    	//bufferedWriter.write("\nUV value on " + dateRequired.get(dateIndexArray[i-1]) + " is " + loop + " which is less than " + arg1);
	    	//bufferedWriter.newLine();
	    }
	}

	@Then("^I Pick two spots based on suitable weather forecast for the day$")
	public void i_Pick_two_spots_based_on_suitable_weather_forecast_for_the_day() throws Throwable {
		
	    String city = postCodeResponse1.jsonPath().get("city_name");	    
	    String latitude = postCodeResponse1.jsonPath().get("lat");	    
	    String longitude = postCodeResponse1.jsonPath().get("lon");    
	    String countryCode = postCodeResponse1.jsonPath().get("country_code");    
	    String stateCode = postCodeResponse1.jsonPath().get("state_code");
	    
	    System.out.println("\nThe spots picked on suitable weather forecast have \n");
	    System.out.println("City: " + city);
	    System.out.println("Latitude: " + latitude);
	    System.out.println("Longitude: " + longitude);
	    System.out.println("Country Code: " + countryCode);
	    System.out.println("State Code: " + stateCode);
	}
}	
