@US13
Feature: As a user I should be able to change profile info settings under Profile module.

  Background: User has logged in with valid credentials
    Given the user already logged in

  @US13AC1
  Scenario: User can see Full name, Email, Phone Number in personal info section of profile settings page
    And user clicks profile icon
    And user clicks "Settings" from profile menu
    Then user sees following sections in Personal info page
      | Full name    |
      | Email        |
      | Phone number |

  @US13AC2
  Scenario: Username in profile menu and full name in input box in profile settings page should match
    And user clicks profile icon
    And user clicks "Settings" from profile menu
    And user clicks profile icon
    Then user sees matching username and full name in the input box


#  @US13AC3
#  Scenario: Phone number input box in profile settings page should accept only numbers
#  There's bug, accepts letters also