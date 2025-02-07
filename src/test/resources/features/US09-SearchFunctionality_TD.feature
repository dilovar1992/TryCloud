Feature: User should be able to search a file or a contact from a Dashboard

  Scenario: User can search file using magnifying glass icon
    Given the user already logged in
    When user navigates to "Contacts" module
    And user clicks on magnifying glass icon
    And user write "filename" on search bar
    And user clicks on found file.
    Then user sees the file under All Files

    Scenario: user navigate to Dashboard
      Given the user already logged in
      When user navigates to "Contacts" module
      And user clicks on magnifying glass icon
      And user write "filename" on search bar
      And user clicks on found file.
      And user clicks on App icon
      Then user navigates to the Dashboard