package demoTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class restDemo {

	@Test (priority = 0, enabled = false)
	public void TestCase_01_signUp()
	{	
		// first step is to specify base URI.
		RestAssured.baseURI = "https://ecommerceservice.herokuapp.com";
		
		// Second step to get the body where it required.
		String requestBody = "{\r\n"
				+ "	\"email\": \"swapnil456@gmail.com\",\r\n"
				+ "	\"password\": \"swapnil@122333\"\r\n"
				+ "}\r\n"
				+ "";
		
		// Flow starts here 
		Response swapnilResp = 
		given().header("content-type","application/json")
			.body(requestBody)
		
		.when()
			.post("/user/signup")
		
		.then().assertThat().statusCode(201).and().contentType(ContentType.JSON)
		
		.extract().response();
		
		// converting response to the String format
		String responseBody = swapnilResp.asString();
		//converting response into json format
		JsonPath data = new JsonPath(responseBody);
		System.out.println(data.get("message"));

	}
	
	@Test (priority = 0, enabled = true)
	public void TestCase_02_login()
	{
		RestAssured.baseURI = "https://ecommerceservice.herokuapp.com";
		
		String requestBody = "{\r\n"
				+ "	\"email\": \"swapnil456@gmail.com\",\r\n"
				+ "	\"password\": \"swapnil@122333\"\r\n"
				+ "}\r\n"
				+ "";
		
		Response response = given().header("content-type","application/json")
		.body(requestBody)
		
		.when()
		.post("/user/login")
		
		.then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
		.extract().response();
		
		String responseBody = response.asString();
		System.out.println(response.asString());
		JsonPath jsonData = new JsonPath(responseBody);
		//System.out.println(jsonData.get("accessToken"));
		String accessToken = jsonData.get("accessToken");
	}
	
}
