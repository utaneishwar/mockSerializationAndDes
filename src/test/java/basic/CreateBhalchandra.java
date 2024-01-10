package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;
public class CreateBhalchandra
{
	@Test
	public void create1()
	{
		RestAssured.baseURI ="https://petstore.swagger.io/v2";

		Response response = given()
				.body("\r\n"
						+ "  \"id\": 0,\r\n"
						+ "  \"username\": \"utanevaishali\",\r\n"
						+ "  \"firstName\": \"vaishali\",\r\n"
						+ "  \"lastName\": \"utane\",\r\n"
						+ "  \"email\": \"utanevaishali@gmail.com\",\r\n"
						+ "  \"password\": \"Vaishali@123\",\r\n"
						+ "  \"phone\": \"8788584611\",\r\n"
						+ "  \"userStatus\": 0")
				.when()
				.post("/user")
				.then()
				.extract()
				.response();
		String createuser = response.asPrettyString();
		System.out.println(createuser);
		System.out.println(response.statusCode());
		System.out.println(response.time());
	}

	@Test
	public void fetchuser()
	{

		RestAssured.baseURI ="https://petstore.swagger.io/v2";

		Response response = given()
				.when()
				.get("user/utanevaishali")
				.then()
				.extract()
				.response();
		String getuser = response.asPrettyString();
		System.out.println(getuser);
		System.out.println(response.statusCode());
   }
}
