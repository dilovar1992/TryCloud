@US05
Feature: User should be able to view Daily-Weekly-Monthly calendar and create new events

  @US05AC1
  Scenario: User can display daily calendar view
    Given the user already logged in
    When user navigates to "Calendar" module
    And user clicks on calendar view button
    And user selects "Day" view from the menu
    Then user sees the day view of the calendar

  @US05AC2
  Scenario: User can display weekly calendar view
    Given the user already logged in
    When user navigates to "Calendar" module
    And user clicks on calendar view button
    And user selects "Week" view from the menu
    Then user sees the week view of the calendar

  Scenario: User can display monthly calendar view
    Given the user already logged in
    When user navigates to "Calendar" module
    And user clicks on calendar view button
    And user selects "Month" view from the menu
    Then user sees the month view of the calendar

  Scenario: User can create event and see it in monthly calendar view
    Given the user already logged in
    When user navigates to "Calendar" module
    And user clicks new event button
    And user enters event information
    And user clicks submit button
    And user clicks on calendar view button
    And user selects "Month" view from the menu
    Then user sees the event in monthly calendar view

