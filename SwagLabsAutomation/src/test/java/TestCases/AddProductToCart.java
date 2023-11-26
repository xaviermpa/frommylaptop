package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductPage;

public class AddProductToCart extends HelperLibrary{

	
@Test
public void AddGivenProducttoCartbyname()
{
	LoginPage login = new LoginPage(driver);
	login.LoginFunction("standard_user","secret_sauce");	
	WebElement productheader = driver.findElement(By.className("product_label"));
	Assert.assertEquals(productheader.getText(),"Products");
	
	ProductPage product = new ProductPage(driver);
	product.AddProducttoCartbyName("Sauce Labs Backpack");
		
}

}
