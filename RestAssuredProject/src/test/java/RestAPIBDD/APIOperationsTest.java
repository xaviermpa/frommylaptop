package RestAPIBDD;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APIOperationsTest {

	String baseurl = "http://localhost:3000/employees";
@Test
public void GetOperation()
{
	RestAssured.given()
				.baseUri(baseurl)
				.when()
				.get()
				.then()
				.log()
				.body()
				.statusCode(200);
				
}

@Test
public void GetOperationwithParam()
{
	RestAssured.given()
				.baseUri(baseurl)
				.when()
				.get("/1")
				.then()
				.log()
				.all()
				.statusCode(200)
				.body("name",Matchers.equalTo("Pankaj"))
				.body("salary",Matchers.equalTo("10000"));
				
}

@Test
public void GetOperationwithQueryParam()
{
	RestAssured.given()
				.baseUri("https://demo.guru99.com/V4/sinkministatement.php")
				.queryParam("CUSTOMER_ID","68195")
				.queryParam("PASSWORD","1234") 
				.queryParam("Account_No","1")
				.when()
				.get()
				.then()
				.log()
				.all()
				.statusCode(200);
				
}

@Test
public void PostOperation()
{
	
	HashMap<String,String> Obj = new HashMap<String,String>();	
	Obj.put("name", "MPAXavier");
	Obj.put("id", "9001");
	Obj.put("Salary", "80000");
	
	RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.baseUri(baseurl)
				.body(Obj)
				.when()
				.post()
				.then()
				.log()
				.all()
				.statusCode(201);
}

@Test
public void PutOperation() throws IOException
{

	byte[] file = Files.readAllBytes(Paths.get("Data.Json"));

	RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.baseUri(baseurl)
				.body(file)
				.when()
				.put("/9001")
				.then()
				.log()
				.all()
				.statusCode(200);
}

@Test(groups = {"broken"} ) //( enabled=false )
public void DeleteOperation()
{	
	RestAssured.given()
				.baseUri(baseurl)
				.when()
				.delete("/9001")
				.then()
				.log()
				.all()
				.statusCode(200);
}

}