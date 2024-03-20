package createsource;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class CreatenewUser 
{
		@Test
		public void NewUser()
		{
			RestAssured.baseURI="https://dummy.restapiexample.com";
			
			Response response = given()
			.header("Content-Type","application/json")
			.header("Accept","application/json")
			.body("{\r\n"
					+ "\"name\":\"Vishal\",\r\n"
					+ "\"salary\":\"45000\",\r\n"
					+ "\"age\":\"26\"\r\n"
					+ "}")
			.when()
			.post("/api/v1/create")
			.then()
			.extract()
			.response();
			
			String resp = response.asPrettyString();
			System.out.println(resp);
			
		 JsonPath js = response.jsonPath();
		 		String status = js.get("status");
			System.out.println("status is "+status); // success 
			
			String message = js.get("message");
			System.out.println("response message is "+message); // Successfully! Record has been added.
	
		       String name=js.get("data.name");
		       System.out.println("name is "+name);  // 
				//id
		       int id=js.get("data.id");
		       System.out.println("id is "+id); // 1006
		}
		
		

}
