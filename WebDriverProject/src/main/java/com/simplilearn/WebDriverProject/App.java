package com.simplilearn.WebDriverProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://simplilearn.com/");
//		try {
//			driver.wait(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driver.manage().window().maximize();

		
		driver.findElement(By.linkText("Log in")).click();
				
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.name("user_login")).sendKeys("xav.mpa@gmail.com");
		
		driver.findElement(By.linkText("Log in")).click();
		
		
		
		driver.close();
        
    }
}
