package serializationAndDeserialization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.DelayData;
import pojo.DelayUser;

import static io.restassured.RestAssured.*;

import java.util.List;
public class DelayUserSerAndDes 
{
	@Test
	public void delayusertestclass()
	{
		RestAssured.baseURI="https://reqres.in/";
		DelayUser delayResp = given()
				.when()
				.get("api/users?delay=3")
				.then()
				.log().all()
				.extract()
				.response()
				.as(DelayUser.class);
		List<DelayData> allgetdata =delayResp.getData();
		String name = allgetdata.get(3).getFirst_name();
		System.out.println(name);  // eve 
		System.out.println(allgetdata.get(3) .getEmail());	  
		




	}

}
