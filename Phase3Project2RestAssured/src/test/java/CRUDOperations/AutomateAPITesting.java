package CRUDOperations;


	import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	public class AutomateAPITesting {

		

		
		@Test
		public void Get_ListOfUsers() {
			
			RestAssured.baseURI = "https://reqres.in";
			RequestSpecification  request = RestAssured.given();
			Response response = request.get("api/users?page=2");
			
			String responseBody = response.body().asString();
			
			System.out.println(responseBody);

			System.out.println("Response code is " + response.statusCode());

			Assert.assertEquals(response.statusCode(), 200);
						
		}

		@Test
		public void Post_CreateUser() throws IOException {
			
			byte[] file = Files.readAllBytes(Paths.get("Data.Json"));
			
			RestAssured.baseURI = "https://reqres.in/api/users";
			RequestSpecification  request = RestAssured.given();
			
			Response response = request.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(file)
					.post();

		System.out.println("The response code is " + response.getStatusCode());
		
		System.out.println("The response body is " + response.body().asString());
		
		}
}
