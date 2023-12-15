package stepdefs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		WebElement locationlst = driver.findElement(By.xpath("//div[text()='Pune Railway Station']"));
		locationlst.click();	   	    
	}

	@Then("I should land on the Deals page")
	public void i_should_land_on_the_Deals_page() {
		WebElement DealLink = driver.findElement(By.linkText("Deals"));
		DealLink.isDisplayed();	
	}

	@And("I select the tab as {string}")
	public void i_select_the_tab_as(String Pizza) {
		WebElement PizzaLink = driver.findElement(By.linkText(Pizza));
		PizzaLink.isDisplayed();		    
		PizzaLink.click();		    
	}

	@And("I select the pizza as {string}")
	public void i_select_the_pizza_as(String Pizzaname) {
		//see the given pizza name
//		WebElement Pizzaitem = driver.findElement(By.xpath("//div[@text()='"+Pizzaname+"']"));
//		Pizzaitem.isDisplayed();	
		
//		//click add the same pizza
//		WebElement Addpizzaitem = driver.findElement(By.xpath("//button/span[1]/span[@text()='Add']"));
//		Addpizzaitem.isDisplayed();	
//		
	}

	@Then("I should see the pizza is added to the cart")
	public void i_should_see_the_pizza_is_added_to_the_cart() {
	    
	    
	}

	@And("I click on the Checkout button")
	public void i_click_on_the_Checkout_button() {
	    
	    
	}

	@Then("I should be landed on the secured checkout page")
	public void i_should_be_landed_on_the_secured_checkout_page() {
	    
	    
	}

	@And("I enter the personal details")
	public void i_enter_the_personal_details(io.cucumber.datatable.DataTable dataTable) {
	    
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    
	}

	@And("I enter the address details")
	public void i_enter_the_address_details(io.cucumber.datatable.DataTable dataTable) {
	    
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    
	}

	@Then("I should see three payment options")
	public void i_should_see_three_payment_options(io.cucumber.datatable.DataTable dataTable) {
	    
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    
	}

	@But("I select the payment option as {string}")
	public void i_select_the_payment_option_as(String string) {
	    
	    
	}
}
