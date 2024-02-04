package github;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRepo {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "https://api.github.com/repos/xaviermpa/Xavier";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.auth().oauth2("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")
							.delete();
		
		System.out.println("The Response body is " + response.body().asString());

	}

}
