package github;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRepo {
	
	
	@Test
	public void test1() throws IOException {
		
		
		byte[] file = Files.readAllBytes(Paths.get("data1.json"));
		
		RestAssured.baseURI = "https://api.github.com/user/repos";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.auth().oauth2("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")
									.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body(file)
									.post();
		
		System.out.println("The response is " + response.body().asString());
		System.out.println("The status code is " + response.statusCode());
	}

}
