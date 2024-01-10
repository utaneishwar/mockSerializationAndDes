package serAndDserMock;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojoMockclasses.Fetch_ResponseBody;
import pojoMockclasses.RequestBody;
import pojoMockclasses.Resp_Body;

import static io.restassured.RestAssured.*;
public class Create_User 
{
	
	@Test
	public void createUser()
	{
		RequestBody rb=new RequestBody();
		rb.setId(1);
		rb.setUsername("mayur");
		rb.setFirstName("mayur");
		rb.setLastName("bhosale");
		rb.setEmail("mayurbosale@gmail.com");
		rb.setPassword("mayur@123");
		rb.setPhone("8975780260");
		rb.setUserStatus(0);
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		   Resp_Body getresp = given()
		                    .body(rb)                // serealization javaobject into byte-stream
		                    .header("Content-Type","application/json")
		                    .header("accept","application/json")
		                    .when()
		                    .post("/user")
		                    .then()
//		                    .log()
//		                    .all()
		                    .extract()
		                    .response()
		                    .as(Resp_Body.class);
		  System.out.println(getresp.getCode());
		  System.out.println(getresp.getMessage());
		  System.out.println(getresp.getType());
		
	}

	@Test
	public void fetchuser()
	{    //   Fetch_ResponseBody fr =new Fetch_ResponseBody ();   // do not requied 
	System.out.println("********************************************8");
		RestAssured.baseURI="https://petstore.swagger.io/v2";
                Fetch_ResponseBody r_e_s = given()
        					.when()
        					.get("user/mayur")
        					.then()
//        					.log()
//        					.all()
        					.extract()
        					.response()
        					.as(Fetch_ResponseBody.class);
                          
             System.out.println(r_e_s.getId()); 
             System.out.println(r_e_s.getUsername()); 
             System.out.println(r_e_s.getFirstName()); 
             System.out.println(r_e_s.getLastName()); 
             System.out.println(r_e_s.getEmail()); 
             System.out.println(r_e_s.getPassword()); 
             System.out.println(r_e_s.getPhone()); 
             System.out.println(r_e_s.getUserStatus()); 
 }
	








}
