package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class FetchingDataFromComplexJson 
{
	@Test
	public void ComplexData()
	{
		RestAssured.baseURI="https://reqres.in/";
		Response resp = given()
				.when()
				.get("api/users?page=2")
				.then()
				.extract()
				.response();

		JsonPath response = resp.jsonPath();
		int page = response.getInt("per_page");
		System.out.println(page);

		int dataSize = response.getInt("data.size()");

		for(int i=0; i<dataSize; i++)
		{
//			if(i==3)    // if we required perticular Data then we can apply This
//			{
			String name = response.getString("data["+i+"].first_name");
			
			System.out.println(name);
			//}
		}
         	String getUrl = response.getString("support.url");
         	System.out.println(getUrl);
		

	}
}
