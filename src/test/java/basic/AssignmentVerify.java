package basic;

import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class AssignmentVerify
{
	 //6. Verify if Sum of all Course prices matches with Purchase Amount


	@Test()
	public void ass()
	{
		        String jsonBody = "{\r\n"
						+ "\"dashboard\": {\r\n"
						+ "\"purchaseAmount\": 910,\r\n"
						+ "\"website\": \"www.abc.com\"\r\n"
						+ "},\r\n"
						+ "\"courses\": [\r\n"
						+ "{\r\n"
						+ "\"title\": \"Selenium Python\",\r\n"
						+ "\"price\": 50,\r\n"
						+ "\"copies\": 6\r\n"
						+ "},\r\n"
						+ "{\r\n"
						+ "\"title\": \"Cypress\",\r\n"
						+ "\"price\": 40,\r\n"
						+ "\"copies\": 4\r\n"
						+ "},\r\n"
						+ "{\r\n"
						+ "\"title\": \"RPA\",\r\n"
						+ "\"price\": 45,\r\n"
						+ "\"copies\": 10\r\n"
						+ "}\r\n"
						+ "]\r\n"
						+ "}\r\n"
						+ "";
		                    
						
						 JsonPath jp = new JsonPath(jsonBody);
				       int sizevalue = jp.getInt("courses.size()");
						System.out.println(sizevalue);
						
						int sum=0;
						for(int i=0; i<sizevalue; i++)
						{
							 int pricevalue = jp.getInt("courses["+i+"].price");
							 int courcess   = jp.getInt("courses["+i+"].copies");
						    sum=sum+pricevalue*courcess;
						    
						}
						System.out.println(sum);
						
						int totalamount = jp.getInt("dashboard.purchaseAmount");
						 Assert.assertEquals(sum,totalamount);
		
	}

}
