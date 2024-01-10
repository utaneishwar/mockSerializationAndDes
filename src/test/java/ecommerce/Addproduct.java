package ecommerce;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;
public class Addproduct extends BasicData
{
	@Test
	public void AddProduct()
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\images\\Screenshot (487).png";
		File file =new File(path);
		
		RestAssured.baseURI="https://rahulshettyacademy.com";

		Response addresponse = given()   // required token id
				.header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9."
						                 + "eyJfaWQiOiI2NTZhZjE3ZDlmZDk5Yzg1ZThkZGFlMGMiLCJ"
						                 + "1c2VyRW1haWwiOiJrdW5hbGJodXNhcmlAZ21haWwuY29tIiwidX"
						                 + "Nlck1vYmlsZSI6ODc4ODU4NDYxMSwidXNlclJvbGUiOiJjdX"
						                 + "N0b21lciIsImlhdCI6MTcwMTUxNjcxMSwiZXhwIjoxNzMzMD"
						                 + "c0MzExfQ.C0Znt-tPi9xnkCmhmDyVvSyMH1QBosFv45MRagOYdvA")
				.param("productName", "Party wear Jeans")
				.param("productAddedBy",userId)
				.param("productCategory", "fashion")
				.param("productSubCategory", "Trouser")
				.param("productPrice", "2000")
				.param("productDescription", "Levis Jeans")
				.param("productFor", "women")
				.multiPart("productImage", file)
				
				.when()
				.post("/api/ecom/product/add-product")
				.then()
				.log().all()
				.extract()
				.response();

	

		JsonPath jp = addresponse.jsonPath();

		productId = jp.getString("productId");
		System.out.println(productId);








	}

}
