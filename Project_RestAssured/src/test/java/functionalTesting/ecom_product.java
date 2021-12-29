package functionalTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class ecom_product {
	
	public String url = "https://ecommerceservice.herokuapp.com";
	public String accessToken;
	public String productid;
	
	@Test (enabled = false)
	public void signup()
	{
		RestAssured.baseURI = url;
		
		String requestBody = "{\r\n"
				+ "	\"email\": \"swapnil12345678@gmail.com\",\r\n"
				+ "	\"password\": \"Swapnil@123\"\r\n"
				+ "}\r\n"
				+ "";
		 
				given().header("content-Type","application/json")
				.body(requestBody)
				.when()
				.post("/user/signup")
				.then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
	}

	@Test (priority = 0, enabled = true)
	public void login()
	{
		RestAssured.baseURI = url;
		
		String requestBody = "{\r\n"
				+ "	\"email\": \"swapnil12345678@gmail.com\",\r\n"
				+ "	\"password\": \"Swapnil@123\"\r\n"
				+ "}\r\n"
				+ "";
		
		Response response = 
				given().header("content-Type","application/json")
				.body(requestBody)
				.when()
				.post("/user/login")
				.then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
		
		String jsonData = response.asString();
		JsonPath responseBody = new JsonPath(jsonData);
		// Storing the access token.
		accessToken = responseBody.get("accessToken");
		System.out.println(accessToken);
	}
	
	@Test (priority = 1, enabled = true)
	public void getAllProducts()
	{
		RestAssured.baseURI = url;
		
		Response response = 
				given().header("content-Type","application/json")
				.header("Authorization","Bearer "+accessToken)
				
				.when().get("/products")
				.then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
				
		String jsonData = response.asString();
		JsonPath responseBody = new JsonPath(jsonData);
		System.out.println(responseBody.get("product[891]._id"));
// Note:- it is not printing all products in console, but showing everything in command prompt.
	}
	
	@Test (priority = 2, enabled = true)
	public void createProduct()
	{
		RestAssured.baseURI = url;
		
		String requestBody = "{\r\n"
				+ "	\"name\": \"Samsung LED\",\r\n"
				+ "	\"price\": 96500\r\n"
				+ "}\r\n"
				+ ""; 
		
		Response response = 
				given().header("content-Type","application/json")
				.header("Authorization","Bearer "+accessToken)
				.body(requestBody)
				
				.when().post("/products")
				.then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
				
		String jsonData = response.asString();
		JsonPath responseBody = new JsonPath(jsonData);
		System.out.println(responseBody.get("product._id"));
		productid = responseBody.get("product._id");
	}
	
	@Test (priority = 3, enabled = true)
	public void getProductById()
	{
		RestAssured.baseURI = url;
		
		Response response = 
				given().header("content-Type","application/json")
				.header("Authorization","Bearer "+accessToken)
				
				.when().get("/products/"+productid)
				.then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
				
		String jsonData = response.asString();
		JsonPath responseBody = new JsonPath(jsonData);
		System.out.println(responseBody.get());
	}

	@Test (priority = 4, enabled = true)
	public void updateById()
	{
		RestAssured.baseURI = url;
		
		String requestBody = "{\r\n"
				+ "	\"name\": \"OnePlus TV\",\r\n"
				+ "	\"price\": 98457\r\n"
				+ "}\r\n"
				+ "";
		
		Response response = 
				given().header("content-Type","application/json")
				.header("Authorization","Bearer "+accessToken)
				.body(requestBody)
				
				.when()
				.patch("/products/"+productid)
				.then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
		
		String jsonData = response.asString();
		JsonPath responseBody = new JsonPath(jsonData);
		System.out.println(responseBody.get());
	}
	
	@Test (priority = 5, enabled = true)
	public void deleteProductById()
	{
		RestAssured.baseURI = url;
		
		Response response = 
				given().header("content-Type","application/json")
				.header("Authorization","Bearer "+accessToken)
				
				.when().delete("/products/"+productid)
				.then().assertThat().statusCode(200).and().contentType(ContentType.JSON)
				.extract().response();
				
		String jsonData = response.asString();
		JsonPath responseBody = new JsonPath(jsonData);
		System.out.println(responseBody.get());
	}

}
