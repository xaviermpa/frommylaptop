package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginScenarios extends HelperLibrary{

	
@Test
public void LoginFailureTest()
{
	LoginPage login = new LoginPage(driver);
	login.LoginFunction("abc.com","slfjslfj");
	
	WebElement errorMessage = driver.findElement(By.tagName("h3"));
	System.out.println("The error message is " + errorMessage.getText());

	String actMsg = errorMessage.getText();
	String expMsg = "Epic sadface: " + "Username and password do not match any user in this service" ;
	Assert.assertEquals(actMsg,expMsg);
	
}

@Test
public void LoginSuccessTest()
{
	LoginPage login = new LoginPage(driver);
	login.LoginFunction("standard_user","secret_sauce");	
	WebElement productpageheader = driver.findElement(By.className("app_logo"));
	Assert.assertEquals(productpageheader.getText(),"Swag Labs");
}

}
