package RestAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification  request = RestAssured.given();
		Response response = request.get();
		
		String responseBody = response.body().asString();
		
		System.out.println(responseBody);

		System.out.println("Response code is " + response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		
		JsonPath json = response.jsonPath();
		List<String> actName = json.get("name");
		
		for(String s : actName)
		{
			System.out.println(s);			
		}
		
//		String[] expName = {"Pankaj","David","Emily","Antony","AntonyEmily"};
//		int i=0;
//		for(String s : actName)
//		{
//		Assert.assertEquals(s, expName[i]);
//		i++;
//		}
	}

}
