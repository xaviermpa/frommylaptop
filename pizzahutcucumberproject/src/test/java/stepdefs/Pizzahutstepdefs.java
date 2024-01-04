package stepdefs;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Pizzahutstepdefs {

	WebDriver driver = BaseClass.driver;
	
	@Given("I have launched the application")
	public void i_have_launched_the_application() {
		driver.get("https://pizzahut.co.in/");
	}

	@When("I enter the location as {string}")
	public void i_enter_the_location_as(String location) {
	WebElement locationtxt = driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
	locationtxt.sendKeys(location);	   
	}

	@And("I select the very first suggestion from the list")
	public void i_select_the_very_first_suggestion_from_the_list() {
		WebElement locationlst = driver.findElement(By.xpath("//*[contains(text(),'Airport')]"));
		locationlst.click();	   	    
	}

	@Then("I should land on the Deals page")
	public void i_should_land_on_the_Deals_page() {
		WebElement DealLink = driver.findElement(By.xpath("//a[@data-synth='link--deals--side']//span[text()='Deals']"));
		DealLink.isDisplayed();	
	}

	@And("I select the tab as {string}")
	public void i_select_the_tab_as(String Pizzas) {
		WebElement PizzaLink = driver.findElement(By.xpath("//a[@data-synth='link--pizzas--side']//span[text()='"+Pizzas+"']"));
		PizzaLink.isDisplayed();		    
		PizzaLink.click();		    
	}

	@And("I select the pizza as {string}")
	public void i_select_the_pizza_as(String Pizzaname) {
		//see the given pizza name
		WebElement Pizzaitem = driver.findElement(By.xpath("//div[text()='"+Pizzaname+"']"));
		Pizzaitem.isDisplayed();	
		
		//click add the same pizza
		WebElement Addpizzaitem = driver.findElement(By.xpath("//div[text()='"+Pizzaname+"']/following::span[text()='Add'][1]"));
		Addpizzaitem.click();	

	}

	@Then("I should see the pizza is added to the cart")
	public void i_should_see_the_pizza_is_added_to_the_cart() {
		//able to see the selected pizza name in basket
		WebElement Pizzaitemselected = driver.findElement(By.xpath("//div[@data-testid='basket-item-product']//div[contains(text(),'Personal Mazedar Makhni Paneer')]"));
		Pizzaitemselected.isDisplayed();	
		
	}

	@And("I click on the Checkout button")
	public void i_click_on_the_Checkout_button() {
		//click checkout button
		WebElement checkoutbutton= driver.findElement(By.xpath("//span[text()='Checkout']"));
		checkoutbutton.click();	
		
	}

	@Then("I should be landed on the secured checkout page")
	public void i_should_be_landed_on_the_secured_checkout_page() {
		WebElement checkoutpagetile = driver.findElement(By.xpath("//span[text()='Secure Checkout']"));
		checkoutpagetile.isDisplayed();	
	    
	}

	@And("I enter the personal details")
	public void i_enter_the_personal_details(DataTable persdetails) {

		for(int i=0;i<persdetails.height();i++)
		{
			//dynamic element finding and input
			WebElement PersDetail1 = driver.findElement(By.name(persdetails.cell(i,0)));
			PersDetail1.sendKeys(persdetails.cell(i,1));
		}	
			
		}	
	
	@And("I enter the address details")
	public void i_enter_the_address_details(List<String> Addressdetails) {
	    
		WebElement AddrDetail1 = driver.findElement(By.name("deliveryAddress.interior"));
		AddrDetail1.sendKeys(Addressdetails.get(0));

		WebElement AddrDetail2 = driver.findElement(By.name("deliveryAddress.notes"));
		AddrDetail2.sendKeys(Addressdetails.get(1));
	    
	}

	@Then("I should see three payment options")
	public void i_should_see_three_payment_options(List<String> PaymentOptions) {
		
		for(String value:PaymentOptions) 
		{
			//dynamic element find and check whether present or not
			WebElement PaymentOption = driver.findElement(By.xpath("//span[text()='"+value+"']"));
			PaymentOption.isDisplayed();	
		}	
		
	}

	@But("I select the payment option as {string}")
	public void i_select_the_payment_option_as(String PaymentCash) {
	    
		WebElement CashpaymentOption = driver.findElement(By.xpath("//span[text()='Cash']/preceding::i[2]"));
		CashpaymentOption.click();	
	    
	}
}
