@US09
Feature: User should be able to search a file or a contact from a Dashboard
  @US09-1
  Scenario: User can search file using magnifying glass icon
    Given the user already logged in
    When user navigates to "Contacts" module
    And user clicks on magnifying glass icon
    And user write "Readme" on search bar
    And user clicks on "Readme" file.
    Then user sees "Readme" file under All Files
  @US09-2
    Scenario: user navigate to Dashboard
    Given the user already logged in
    When user navigates to "Contacts" module
    And user clicks on magnifying glass icon
    And user write "Left on seen" on search bar
    And user clicks on "Left on seen" file.
    And user clicks on Logo icon on the left corner
    Then user navigates to the Dashboard