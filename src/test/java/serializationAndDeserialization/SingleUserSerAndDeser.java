package serializationAndDeserialization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.SingleUser_Data;
import pojo.Singleuser;

import static io.restassured.RestAssured.*;
public class SingleUserSerAndDeser
{
	@Test
	public void SingleUserFetchData()
	{
		RestAssured.baseURI="https://reqres.in/";
	  Singleuser singleresp = given()
							.when()
							.get("api/users/2")
							.then()
							.log().all()
							.extract()
							.response()
							.as(Singleuser.class);
	      SingleUser_Data name = singleresp.getData();
	         int getid = name.getId();
	          System.out.println(getid);  
	          System.out.println(name.getFirst_name());     
	 }
	
	
}
