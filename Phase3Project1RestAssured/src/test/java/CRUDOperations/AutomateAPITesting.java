package CRUDOperations;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


	public class AutomateAPITesting {

		
		@Test
		public void Test_01_GetAllEmployee() {
			
			RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employees";
			RequestSpecification  request = RestAssured.given();
			Response response = request.get();
			
			String responseBody = response.body().asString();
			
			System.out.println(responseBody);

			System.out.println("Response code is " + response.statusCode());

			Assert.assertEquals(response.statusCode(), 200);
						
		}

		@Test
		public void Test_02_GetSingleEmployee() {
			
			RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employee/1";
			RequestSpecification  request = RestAssured.given();
			Response response = request.get();
			
			String responseBody = response.body().asString();
			System.out.println(responseBody);
			System.out.println("Response code is " + response.statusCode());

			//Assertion
			Assert.assertEquals(response.statusCode(), 200);
			Assert.assertTrue(responseBody.contains("Tiger Nixon"));
			//also check employee name with specific json node
			JsonPath json = response.body().jsonPath();
			String actName = json.get("data.employee_name");
			Assert.assertEquals(actName, "Tiger Nixon");
			
		}
		
		@Test
		public void Test_03_CreateEmployee() throws IOException {
			
			byte[] file = Files.readAllBytes(Paths.get("Data.Json"));
			
			RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/create";
			RequestSpecification  request = RestAssured.given();
			
			Response response = request.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(file)
					.post();

		System.out.println("The response code is " + response.getStatusCode());
		
		System.out.println("The response body is " + response.body().asString());
		
		Assert.assertEquals(response.statusCode(), 200);
		
		JsonPath json = response.body().jsonPath();
		int emp_id = json.get("data.id");
		System.out.println("The employeed created and saved = "+ emp_id);
		
		String bytes =""+emp_id;
		FileWriter fw = new FileWriter("Delete.txt");
		fw.flush();
		fw.write(bytes);
		fw.close();
		
		}

		@Test
		public void Test_04_DeleteEmployee() throws IOException {

			Path p1 = Paths.get("Delete.txt");
			String emp_id=Files.readString(p1);
			
			RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/delete/"+emp_id;
			RequestSpecification  request = RestAssured.given();
			Response response = request.delete();
			
			String responseBody = response.body().asString();
			
			System.out.println(responseBody);

			System.out.println("Response code is " + response.statusCode());

			Assert.assertEquals(response.statusCode(), 200);

			JsonPath json = response.body().jsonPath();
			String actMsg = json.get("message");
			Assert.assertEquals(actMsg, "Successfully! Record has been deleted");
						
		}
		
		@Test
		public void Test_05_TestDeletedEmployee() throws IOException {

			Path p1 = Paths.get("Delete.txt");
			String emp_id=Files.readString(p1);
			
			RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employee/"+emp_id;
			RequestSpecification  request = RestAssured.given();
			Response response = request.get();
			
			System.out.println("Response code is " + response.statusCode());
			//Assertion
			Assert.assertEquals(response.statusCode(), 404);

		}
	}
