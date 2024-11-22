@US17
Feature: User should able to login
  User Story: As a user, I should be able to login

@US17-AC1
  Scenario: User can log in with valid credentials
    Given the user is on the login page
    When the user enters valid "Employee32" and "Employee123"
    And the user clicks on the Login button
    And the user should be logged in successfully
    Then the user should be redirected to the "Dashboard"

  @US17-AC2
  Scenario: User cannot log in with invalid credentials
    Given the user is on the login page
    When the user enters an invalid "username" or "password"
    And the user clicks on the Login button
    Then an error message "Wrong username or password." should be displayed
  @US17-AC3
  Scenario: Error message when username or password is left blank
    Given the user is on the login page
    When the user leaves the "username" or "password" field blank
    And the user clicks on the Login button
    Then an error message "Please fill out this field." should be displayed
  @US17-AC4
  Scenario: User can toggle password visibility
    Given the user is on the login page
    And the user enters a "password" in the password field
    Then the password should be displayed as dots by default
    When the user clicks on the Show password icon
    Then the password should be displayed in plain text

