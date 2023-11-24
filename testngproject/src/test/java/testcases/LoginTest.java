package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends BaseClass{

	
@Test
public void LoginFailureTest()
{
	LoginPage login = new LoginPage(driver);
	login.LoginFunction("abc.com","slfjslfj");
	
	WebElement errorMessage = driver.findElement(By.className("error_msg"));
	System.out.println("The error message is " + errorMessage.getText());

	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println("total num of links are " + links.size());


}

@Test
public void LoginSuccessTest()
{
	LoginPage login = new LoginPage(driver);
	login.LoginFunction("xavierdbhs@gmail.com","sfsflsflsjlfj");	

}

}
