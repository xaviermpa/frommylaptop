package Pages;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.TakesScreenshot;

public class LoginPage {

	WebDriver driver;

	//---------locators----------------
	
	//login page objects
	//user id
	@FindBy(name="user-name")
	WebElement UserName; // = driver.findElement(By.name("user-name"));
	//password
	@FindBy(name="password")
	WebElement Password; // = driver.findElement(By.name("password"));
	//login button
	@FindBy(id="login-button")
	WebElement LoginBtn; //= driver.findElement(By.id("login-button"));

	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@SuppressWarnings("deprecation")
	public void takeScreenshot(String screenshotname)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        Timestamp instant= Timestamp.from(Instant.now());
        try {
			FileUtils.copyFile(source, new File("C:\\Users\\xaviermpa\\eclipse-workspace\\SwagLabsAutomation\\ScreenShot\\"+screenshotname+instant.getDate()+instant.getTime()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void LoginFunction(String UserNameVal,String PwdVal)
	{

        
		UserName.sendKeys(UserNameVal);
		Password.sendKeys(PwdVal);
		takeScreenshot("LoginPageBefore");
		LoginBtn.click();
		takeScreenshot("LoginPageAfter");		
	}

}
