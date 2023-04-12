Feature: Login functionality in book cart
  Scenario: login with valid credentials
    Given User is in book cart homepage
    When user clicks on login button
    And user inputting valid credentials
    Then login should be successful
    And user quit browser