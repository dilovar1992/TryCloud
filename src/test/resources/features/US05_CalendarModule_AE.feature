@US05
Feature: User should be able to view Daily-Weekly-Monthly calendar and create new events

  Scenario: User can display daily calendar view
    Given the user already logged in
    When user navigates to "Calendar" module
    And user clicks on calendar view button
    And user selects "Day" view from the menu
    Then user sees the "Day" view of the calendar
