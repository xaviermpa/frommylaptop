package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void LoginFunction(String UserNameVal,String PwdVal)
	{

		//login page objects
		//user id
		WebElement UserName = driver.findElement(By.name("user-name"));
		//password
		WebElement Password = driver.findElement(By.name("password"));
		//login button
		WebElement LoginBtn = driver.findElement(By.id("login-button"));

		
		UserName.sendKeys(UserNameVal);
		Password.sendKeys(PwdVal);
		LoginBtn.click();
		
	}

}
