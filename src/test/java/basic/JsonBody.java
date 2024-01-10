package basic;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class JsonBody 
{
	@Test
	public static String GetBody()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
				
		String body ="{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"rohit\",\r\n"
				+ "  \"firstName\": \"rohit\",\r\n"
				+ "  \"lastName\": \"shetty\",\r\n"
				+ "  \"email\": \"settyrohit@gmail.com\",\r\n"
				+ "  \"password\": \"Pass@123\",\r\n"
				+ "  \"phone\": \"8975780260\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}";
				return body;
	}
}
