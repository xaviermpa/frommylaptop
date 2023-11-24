package UiTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		driver.switchTo().frame("frame1");
		WebElement Header = driver.findElement(By.tagName("h1"));
		System.out.println(Header.getText());
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		Header = driver.findElement(By.tagName("h1"));
		System.out.println(Header.getText());
		

	}

}
