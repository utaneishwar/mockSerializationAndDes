package serAndDserMock;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojoMockclasses.Data;
import pojoMockclasses.Response_Body;
import pojoMockclasses.Support;

import static io.restassured.RestAssured.*;

import java.util.List;
public class Get_List_user 
{
	// concept of Serealization and Deserealization

	@Test
	public void Get_list_Of_users()
	{
		RestAssured.baseURI ="https://reqres.in/";
		Response_Body resp = given()
				.when()
				.get("api/users?page=2")
				.then()
				.log()
				.all()
				.extract()
				.response()
				.as(Response_Body.class);  // desearialization 

		List<Data> listofdata = resp.getData();
		String name = listofdata.get(2).getFirst_name();
		System.out.println(name);  // 

		String  resp_url = resp.getSupport().getUrl();
		String  resp_Text = resp.getSupport().getText();

		System.out.println(resp_url);  //
		System.out.println(resp_Text); 
		//		             System.out.println(resp_support.getUrl());   
		//		             System.out.println(resp_support.getText());   

		System.out.println("===============");
	
		for(int i=0; i<listofdata.size(); i++)
		{
			System.out.println(listofdata.get(i).getId());  // we get all list of data 
			System.out.println(listofdata.get(i).getFirst_name());
			System.out.println(listofdata.get(i).getLast_name());

        }
	



	}






}
