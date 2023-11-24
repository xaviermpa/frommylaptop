package UiTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FaceBookLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);


		WebElement emailaddress = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		emailaddress.sendKeys("xav.mpa@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		password.sendKeys("xxxxxxxxxxx");
	
		
		WebElement loginbtn = driver.findElement(By.xpath("//button[@name='login']"));
		loginbtn.click();
		
		//verify error message
		driver.findElement(By.xpath("//div[text()='Wrong Credentials']")).isDisplayed();
		driver.findElement(By.xpath("//div[text()='Invalid username or password']")).isDisplayed();
		
		driver.close();
		
		
	}

}
