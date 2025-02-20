Feature: User should be able to create new group inder Contacts module

  @US08-1
  Scenario: user can create new group
    Given the user already logged in
    When user navigates to "Contacts" module
    And user click on New Group
    And user enters "group" as a group-name
    Then user sees the "group" group created on the left side of the page

  @US08-2
  Scenario: user can see all groups in contacts info menu
    Given the user already logged in
    When user navigates to "Contacts" module
    And user clicks on "Dilo" from all contacts
    And user clicks on groups dropdown in contacts info page
    Then user can see all available groups under All Contacts in dropdown

  @US08-3
  Scenario: User can add new property ,from contacts info page
    Given the user already logged in
    When user navigates to "Contacts" module
    And user clicks on "Dilo" from all contacts
    And user clicks on Add new property dropdown in contacts info page
    And user selects "Anniversary" from dropdown
    Then user sees the "Anniversary" property added in contacts info page