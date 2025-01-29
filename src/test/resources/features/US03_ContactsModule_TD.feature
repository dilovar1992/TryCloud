@US03
Feature: User should be able to modify the contact module
  User Story: As a user, I should be able to create new contact and edit/delete any contact under Contacts module

  @US03-1
  Scenario: User can create new contact
    Given the user already logged in
    When user navigates to "Contacts" module
    And user clicks New contact button
    And user enters "Ali" as the name of the new contact
    And user navigates to All contacts
    Then user must see the newly created contact

    @US03-2
    Scenario: User can see all contacts and total number
      Given the user already logged in
      When user navigates to "Contacts" module
      And user navigates to All contacts
      Then user sees contact names below
      |Amine|
      |Bahodur|
      |Bogard|
      |Dilovar|
      |harun|
      |Kebi|
      |nitu|
      Then user sees 7 total number of contacts near the All Contacts tab
