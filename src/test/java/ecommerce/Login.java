package ecommerce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Login extends BasicData
{
	@Test
	public void loginApi()
	{
		RestAssured.baseURI ="https://rahulshettyacademy.com";
		Response loginresp = given()
				.body("{\r\n"
						+ "    \"userEmail\": \"kunalbhusari@gmail.com\",\r\n"
						+ "    \"userPassword\": \"Test@1234\"\r\n"
						+ "}")
				.header("Content-Type","application/json")
				.when()
				.post("/api/ecom/auth/login")
				.then()
				.extract()
				.response();


		String strresp = loginresp.asPrettyString();
		System.out.println(strresp);
		
		JsonPath jp = loginresp.jsonPath();

  		String idOfUser = jp.getString("userId");
  		userId = idOfUser;
  		System.out.println("User id is "+idOfUser);

  		String tokenvalue = jp.getString("token"); // 
  		System.out.println(tokenvalue);
  		tokenid=tokenvalue;
	}


}
