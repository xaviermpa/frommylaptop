@Calc
Feature: This feature will help to develop a calculator

  Background: 
    Given I have the calculator
    

  Scenario: To add two numbers
    When I add 5 and 4
    Then I should get the result as 9
    
@Regression @Sanity
  Scenario: To sub two numbers
    When I sub 12 and 4
    Then I should get the result as 8

  Scenario Outline: To add two number with multiple data set
    When I add <num1> and <num2>
    Then I should get the result as <result>

    Examples: 
      | num1 | num2 | result |
      |    7 |    9 |     16 |
      |   12 |   13 |     25 |
      |   -8 |   18 |     10 |


Scenario: To add multiple numbers
    When I add below numbers
      |  4 |
      |  6 |
      | 13 |
      | 16 |
      | 10 |
    Then I should get the result as 49

 Scenario: To calculate the total bill of all the items
    When I buy below items with given price
      | Coffee   | 50 |
      | Burger   | 80 |
      | Icecream | 40 |
    Then I should get the result as 170

  Scenario: To calculate the total bill of all the items with different quantity
    When I buy below items with given price and quantity
      | Coffee   | 2 | 50 |
      | Burger   | 3 | 80 |
      | Icecream | 1 | 40 |
    Then I should get the result as 380
