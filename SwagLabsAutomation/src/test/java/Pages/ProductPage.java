package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class ProductPage {

	WebDriver driver;

	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void AddProducttoCartbyName(String productname)
	{

		//product page objects
		//product id - static object
		WebElement ProductName = driver.findElement(By.xpath("//div[text()='"+productname+"']"));
		//add to cart button - dynamic object
		WebElement AddToCartBtn = driver.findElement(By.xpath("//div[text()='"+productname+"']/following::button[@class='btn_primary btn_inventory'][1]"));		
		ProductName.isDisplayed();
		AddToCartBtn.click();
		
	}

}
