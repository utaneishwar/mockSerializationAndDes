package mysore;

import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class CreateUser 
{
	@Test
	public void createNewUser()
	{
		RestAssured.baseURI="https://dummy.restapiexample.com";
		Response response = given()
							.body("{\r\n"
									+ "\"name\":\"test1234\",\r\n"
									+ "\"salary\":321,\r\n"
									+ "\"age\":\"31\"\r\n"
									+ "\r\n"
									+ "}")
							.header("Content-Type", "application/json")
							.header("Accept", "application/json")
							.when()
							.post("/api/v1/create")
							.then()
							.extract()
							.response();
							
		String res=response.asPrettyString();	
		
		System.out.println(res);
		
		JsonPath js =response.jsonPath();
		
		System.out.println(js.getString("message"));
		System.out.println();
		System.out.println(js.getString("data.name"));
		
		System.out.println(js.getString("data.age"));
	
							
	}
}
