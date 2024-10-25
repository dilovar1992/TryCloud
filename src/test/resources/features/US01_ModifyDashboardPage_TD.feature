Feature: User should be able to modify Dashboard page
@us01
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

  And user should be able to see Username

