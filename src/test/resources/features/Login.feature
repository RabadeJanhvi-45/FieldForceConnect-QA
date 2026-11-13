
Feature: Login functionality

  @valid
  Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials
    And the user clicks the Sign In button
    Then the user should successfully reach the dashboard

  @invalid
  Scenario: Login with invalid credentials
    Given the user is on the login page
    When the user enters invalid credentials
    And the user clicks the Sign In button
    Then the user should see an appropriate error message
