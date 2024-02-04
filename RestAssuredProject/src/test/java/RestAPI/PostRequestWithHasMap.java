package RestAPI;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithHasMap {
	
	
	@Test
	public void test1() {

		HashMap<String,String> Obj = new HashMap<String,String>();	
		Obj.put("name", "Xavier");
		Obj.put("id", "1001");
		Obj.put("Salary", "80000");
		
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body(Obj)
									.post();
		
		System.out.println("The response code is " + response.getStatusCode());
		
		System.out.println("The response body is " + response.body().asString());
		
	}

}
