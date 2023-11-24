package com.simplilearn.WebDriverProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookSignUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com//");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement NewAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		NewAccount.click();
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		FirstName.sendKeys("Rahul");
		
		WebElement LastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		LastName.sendKeys("Roy");
		
		WebElement Email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		Email.sendKeys("abc@xyz.com");
		
		WebElement ReEmail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		ReEmail.sendKeys("abc@xyz.com");
		
		WebElement Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		Password.sendKeys("Abc@12345");
		
		WebElement Day = driver.findElement(By.id("day"));
		Select ddDay = new Select(Day);
		ddDay.selectByValue("25");
		
		WebElement Month = driver.findElement(By.id("month"));
		Select ddMonth = new Select(Month);
		ddMonth.selectByValue("10");
		//ddMonth.selectByVisibleText("Jan");
		
		WebElement year = driver.findElement(By.id("year"));
		Select ddYear = new Select(year);
		//ddMonth.selectByValue("1");
		ddYear.selectByVisibleText("1982");

		WebElement GenderMale = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		GenderMale.click();
				
		List<WebElement> months = driver.findElements(By.xpath("//select[@id='month']"));
		
		for(WebElement m:months) {
			System.out.println(m.getText());
		}
		
		List<WebElement> years = driver.findElements(By.xpath("//select[@id='year']"));
		
		for(WebElement y:years) {
			System.out.println(y.getText());
		}

		driver.close();		
		
		
		

	}

}
