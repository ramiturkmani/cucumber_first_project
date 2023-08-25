@Sagan
Feature: Saganworks WebPage Functionality

  Background:
    Given user is on site "https://app.saganworks.com/Account/Login"

  @Task4
  Scenario: Validate Email input box
    When user clicks on email input box
    And enters email address
    And enters password
    And user clicks on login
    Then wait for login