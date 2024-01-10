package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Get_ListUsers 
{
	@Test
	public void getbody()
	{

		RestAssured.baseURI="https://reqres.in";
		Response resp = given()
						.when()
						.get("/api/users?page=2")
						.then()
						.extract()
						.response();

		String strresp = resp.asPrettyString();
		System.out.println(strresp);
		int stscode = resp.statusCode();
		System.out.println(stscode);
	}

}
