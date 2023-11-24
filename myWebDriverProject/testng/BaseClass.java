package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	@BeforeMethod
	public void Method1()
	{
		System.out.println("before method");
	}
	@AfterMethod
	public void Method2()
	{
		System.out.println("After method");
	}

	@BeforeTest
	public void Method3()
	{
		System.out.println("before test");
	}
	@AfterTest
	public void Method4()
	{
		System.out.println("After test");
	}


	
}
