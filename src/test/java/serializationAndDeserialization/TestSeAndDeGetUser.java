package serializationAndDeserialization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.Data;
import pojo.Get_ListUser;
import pojo.Support;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.util.List;
public class TestSeAndDeGetUser 
{
	@Test
	public void CreateUser()
	{
		RestAssured.baseURI="https://reqres.in/";

		Get_ListUser resp = given()
				.when()
				.get("api/users?page=2")
				.then()
				.log().all()
				.extract()
				.response()
				.as(Get_ListUser.class);

		List<Data> data  = resp.getData();
		String email = data.get(3).getEmail();
		System.out.println(email);
		String name =data.get(5).getFirst_name();
		System.out.println(name);

		int sizevalue = resp.getData().size();
		 Support support = resp.getSupport();
		  String texts = support.getText();
		  System.out.println(texts); //"To keep ReqRes free, contributions towards server costs are appreciated!"
		
		  System.out.println(data.get(4).getAvatar()); //https://reqres.in/img/faces/11-image.jpg
            
		
			
	}

}
