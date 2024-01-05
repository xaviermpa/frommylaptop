package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperLibrary {

WebDriver driver; 
@BeforeMethod
public void Setup()
{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com");

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
}

@AfterMethod
public void TearDown()
{
	driver.close();	
}
	
}
