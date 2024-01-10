package ecommerce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;
public class PlaceOrder extends BasicData
{
	@Test
	public void placeorder()
	{
		RestAssured.baseURI="https://www.rahulshettyacademy.com";
		                      given()
		                     .header("Authorization", tokenid)
		                     .header("Content-Type", "application/json")
		                     .body("")
		                     .when()
							 .post("/api/ecom/order/create-order")
							 .then()
							 .log().all()
							 .extract()
							 .response();
 
	}
 }
