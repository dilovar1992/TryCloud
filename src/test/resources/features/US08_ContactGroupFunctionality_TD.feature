Feature: User should be able to create new group inder Contacts module

  @US08-1
  Scenario: user can create new group
    Given the user already logged in
    When user navigates to "Contacts" module
    And user click on plus sign
    And user enters "group" as a group-name
    Then user sees the "group" group created on the left side of the page
