package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Create_User 
{
	@Test
	public void InsertData()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";

		Response resp = given()
				.body(JsonBody.GetBody())
				.when()
				.post("/user")
				.then()
				.extract()
				.response();
		String strResp = resp.asPrettyString();
		System.out.println(strResp);
	}

	@Test
	public void getData()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";

		Response resp = given()
						.when()
						.get("/user/rohit")
						.then()
						.extract()
						.response();
		String strResp = resp.asPrettyString();
		System.out.println(strResp);
	}

}
