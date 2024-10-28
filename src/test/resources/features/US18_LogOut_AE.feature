@US18
Feature: USer should be able to logout from the app

  Background:
    Given the user already logged in

  Scenario: User logs out and redirected to login page
    And user clicks profile icon
    And user clicks "Log out" from profile menu
    Then user lands on the login page

  Scenario: User logs out successfully and cannot go to homepage by click back
    And user clicks profile icon
    And user clicks "Log out" from profile menu
    And user should land on the login page
    And user navigates back in the browser
    Then user should land on the login page