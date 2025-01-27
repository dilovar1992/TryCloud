@US03
Feature: User should be able to modify the contact module
  User Story: As a user, I should be able to create new contact and edit/delete any contact under Contacts module

  @US03-1
  Scenario: User can create new contact
    Given the user already logged in
    When user navigates to "Contacts" module
    And user clicks New contact button
    And user write "Ali" of new contact
    And user navigates to All contacts
    Then user must see the newly created contact