@us01
Feature: User should be able to modify Dashboard page


  Scenario: User see al modules and username
    Given the user already logged in
    Then user should be able to see following modules
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |

    And user should be able to see "Employee61"
@wip
  Scenario: user can select widgets
    Given the user already logged in
    When user clicks on Customize button
    Then user can select any "Weather"


  Scenario: user can select any status button
    Given the user already logged in
    When user clicks on Set Status button from account dropdown
    Then user can select any of the Status options


