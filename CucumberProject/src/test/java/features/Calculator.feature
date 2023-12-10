Feature: This feature will help to develop a calculator

  Scenario: To add two numbers
    Given I have the calculator
    When I add 11 and 4
    Then I should get the result as 15
@Regression
	Scenario: To sub two numbers
    Given I have the calculator
    When I sub 114 and 4
    Then I should get the result as 110