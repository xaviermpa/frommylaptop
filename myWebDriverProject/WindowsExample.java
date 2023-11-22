package UiTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsExample{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		String ParentWin = driver.getWindowHandle();
		System.out.println("Parent win is " + ParentWin);
		
		WebElement TabBtn = driver.findElement(By.id("tabButton"));
		TabBtn.click();
		
		Set<String> AllWin = driver.getWindowHandles();
		String ChildWin = "";
		
		for(String Win:AllWin) {
			
			if(!Win.equals(ParentWin)) {
				ChildWin = Win;
			}
			
		}
		
		driver.switchTo().window(ChildWin);
		
		WebElement Header = driver.findElement(By.tagName("h1"));
		System.out.println("Header on new tab is " + Header.getText());
		
		driver.close();
		driver.switchTo().window(ParentWin);
		
		//**************************************************************************
		
		WebElement WinBtn = driver.findElement(By.id("windowButton"));
		WinBtn.click();
		
		AllWin = driver.getWindowHandles();
		for(String Win:AllWin) {
			
			if(!Win.equals(ParentWin)) {
				ChildWin = Win;
			}
		}
		
		driver.switchTo().window(ChildWin);
		
		Header = driver.findElement(By.tagName("h1"));
		System.out.println("Header on new Window is " + Header.getText());
		
		driver.quit();
	}

}

