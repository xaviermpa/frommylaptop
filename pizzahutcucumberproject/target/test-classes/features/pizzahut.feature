@Regression
Feature:  This feature will be used to automate PizzaHut Website

Scenario: This scenario will be used to Place the Order

Given I have launched the application
When I enter the location as "Chennai"
And I select the very first suggestion from the list
Then I should land on the Deals page
And I select the tab as "Pizzas"
And I select the pizza as "Mazedar Makhni Paneer"
Then  I should see the pizza is added to the cart
And I click on the Checkout button
Then I should be landed on the secured checkout page
And I enter the personal details
|name| Rajesh Sharma|
|phone| 888888888|
|email| abc@xyz.com|
And I enter the address details
|123 Main Street|
|Some Landmark|
Then I should see three payment options
|Online Payment|
|Paytm|
|Cash|
But I select the payment option as "Cash"
