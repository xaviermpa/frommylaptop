Feature: This feature will be used to login into Simplilearn Website

  Scenario: Validate Login success scenario
    Given I have launched the application URL
    And I click on the Login link
    When I enter the username
    And I enter the password
    And I click on the login button
    Then I should land on the home page
