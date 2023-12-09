package stepdefs;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import app.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CalculatorStepdefs {
	
	Calculator calc;
	int result;
	
	@Given("I have the calculator")
	public void i_have_the_calculator() {
	    // Write code here that turns the phrase above into concrete actions
		
		calc = new Calculator();
	}

	@When("I add {int} and {int}")
	public void i_add_and(int num1, int num2) {
	    // Write code here that turns the phrase above into concrete actions
		
		result = calc.Add(num1, num2);
	   
	}

	@Then("I should get the result as {int}")
	public void i_should_get_the_result_as(int expResult) {
	    // Write code here that turns the phrase above into concrete actions
	   
		Assert.assertEquals(expResult, result);
	}

	@When("I sub {int} and {int}")
	public void i_sub_and(int num1, int num2) {
	    // Write code here that turns the phrase above into concrete actions
		
		result = calc.Sub(num1, num2);
	   
	}

@When("I add below numbers")
	public void i_add_below_numbers(List<Integer> numbers) {
		
		for(int num:numbers) {
			
			result = calc.Add(num, result); //49
			
		}
	   
	}

@When("I buy below items with given price")
	public void i_buy_below_items_with_given_price(Map<String,Integer> items) {
		
		for(int value:items.values()) {
			
			result = calc.Add(value, result);
		}	
	}

@When("I buy below items with given price and quantity")
	public void i_buy_below_items_with_given_price_and_quantity(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    
		
		int rows = dataTable.height();
		
		for(int i=0;i<rows;i++) {
			
			int qnt = Integer.parseInt(dataTable.cell(i, 1));
			int price = Integer.parseInt(dataTable.cell(i,2));
			
			result = calc.Add( qnt*price , result);
		}
		
	}

}

