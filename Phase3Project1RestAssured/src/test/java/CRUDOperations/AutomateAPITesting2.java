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




	public class AutomateAPITesting2 {


		public static class EnvironmentVariables
		{
			public static final String baseUri = "https://dummy.restapiexample.com/";
			public static final String basePath = "api/v1/";
		}
		
		public static class GlobalVariables
		{
			public static int Emp_ID=1;		
			public static String DeleteEmp_ID="";	
		}

		
	    
		@Test
		public void Test_01_GetAllEmployee() {
			
			RestAssured.baseURI = EnvironmentVariables.baseUri + EnvironmentVariables.basePath + "employees";
			RequestSpecification  request = RestAssured.given();
			Response response = request.get();
			
			String responseBody = response.body().asString();
			
			System.out.println(responseBody);

			System.out.println("Response code is " + response.statusCode());

			Assert.assertEquals(response.statusCode(), 200);
						
		}

		@Test
		public void Test_02_GetSingleEmployee() {
			
			RestAssured.baseURI = EnvironmentVariables.baseUri + EnvironmentVariables.basePath+ "employee/"+ GlobalVariables.Emp_ID;
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
			
			RestAssured.baseURI = EnvironmentVariables.baseUri + EnvironmentVariables.basePath + "create";
			RequestSpecification  request = RestAssured.given();
			
			Response response = request.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(file)
					.post();

		System.out.println("The response code is " + response.getStatusCode());
		
		System.out.println("The response body is " + response.body().asString());
		
		Assert.assertEquals(response.statusCode(), 200);
		
		JsonPath json = response.body().jsonPath();
		GlobalVariables.Emp_ID = json.get("data.id");
		System.out.println("The employeed created and saved = "+ GlobalVariables.Emp_ID);
		
		String bytes =""+GlobalVariables.Emp_ID;
		FileWriter fw = new FileWriter("Delete.txt");
		fw.flush();
		fw.write(bytes);
		fw.close();
		
		}

		@Test
		public void Test_04_DeleteEmployee() throws IOException {

			Path p1 = Paths.get("Delete.txt");
			GlobalVariables.DeleteEmp_ID=Files.readString(p1);
			
			RestAssured.baseURI = EnvironmentVariables.baseUri + EnvironmentVariables.basePath+"delete/"+GlobalVariables.DeleteEmp_ID;
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
			GlobalVariables.DeleteEmp_ID=Files.readString(p1);
			
			RestAssured.baseURI = EnvironmentVariables.baseUri + EnvironmentVariables.basePath+ "employee/"+GlobalVariables.DeleteEmp_ID;
			RequestSpecification  request = RestAssured.given();
			Response response = request.get();
			
			System.out.println("Response code is " + response.statusCode());
			//Assertion
			Assert.assertEquals(response.statusCode(), 404);

		}
	}
