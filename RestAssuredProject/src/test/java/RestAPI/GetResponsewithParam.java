package RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetResponsewithParam {
	
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification  request = RestAssured.given();
		Response response = request.get("/1");
		
		System.out.println("The Response body is " + response.body().asString());

		Assert.assertEquals(response.statusCode(), 200);
				
		String responseBody = response.body().asString();
		Assert.assertTrue(responseBody.contains("Pankaj"));
		
		JsonPath json = response.jsonPath();
		String actName = json.get("name");
		String expName = "Pankaj1";
		Assert.assertEquals(actName, expName);
		
		
	}
	

}
