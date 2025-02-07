@US03
Feature: User should be able to modify the contact module
  User Story: As a user, I should be able to create new contact and edit/delete any contact under Contacts module

  @US03-1
  Scenario: User can create new contact
    Given the user already logged in
    When user navigates to "Contacts" module
    And user clicks New contact button
    And user enters "Usmon" as the name of the new contact
    And user navigates to All contacts
    Then user must see the newly created contact

    @US03-2
    Scenario: User can see all contacts and total number
      Given the user already logged in
      When user navigates to "Contacts" module
      And user navigates to All contacts
      Then user sees contact names
      Then user sees 7 total number of contacts near the All Contacts tab

      @US03-3
      Scenario: User can change profile image of any contacts
        Given the user already logged in
        When user navigates to "Contacts" module
        And user chooses contact number 6 from all contacts
        And user clicks on image icon
        And user clicks on "Choose from Files"
        And user chooses "photo_2025-01-28_10-12-01 (2).jpg" uploaded image
        And user clicks Choose button
        Then user should see new profile image of contact number 6

        @US03-4
        Scenario: User can delete any contact
          Given the user already logged in
          When user navigates to "Contacts" module
          And user chooses contact number 6 from all contacts
          And user clicks ellipses on the right end
          And user clicks Delete from list
          Then user does not see contact number 6 on contact list


