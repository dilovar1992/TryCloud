@US13
Feature: As a user I should be able to change profile info settings under Profile module.

  Background:
    Given the user already logged in

  @US13AC1
  Scenario: User can see Full name, Email, Phone Number in personal info section of profile settings page
    And user clicks profile icon
    And user clicks "Settings" from profile menu
    Then user sees the following sections in Personal info page