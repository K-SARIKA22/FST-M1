package Examples;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstTest {
	
	// GET https://petstore.swagger.io/v2/pet/findByStatus?status=sold
	@Test
	public void getrequest()
	{
		Response response = 
				RestAssured.given().
				            baseUri("https://petstore.swagger.io/v2/pet").
				            header("Content-Type","application/json").
				            queryParam("status","sold").
				 when().get("/findByStatus");  
		
		System.out.println(response.getBody().asPrettyString());
		String petStatus = response.then().extract().path("[0]['status']");
		System.out.println(petStatus);
		response.then().statusCode(200).
		         body("[0]['status']", Matchers.equalTo("sold"));
	}
	
		// GET https://petstore.swagger.io/v2/pet/{petId}
       @Test
       public void getWithParam() {
    	   
    	   RestAssured.given().
    	       baseUri("https://petstore.swagger.io/v2/pet").
               header("Content-Type","application/json").
               pathParam("petId",12).
           when().get("/{petId}").
           then().statusCode(200).
           body("status",Matchers.equalTo("available")).
           body("name",Matchers.equalTo("doggie"));
       }
}
