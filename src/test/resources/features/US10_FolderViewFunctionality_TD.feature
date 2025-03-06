@US10
Feature: User be able to change folder view

  Background:
    Given the user already logged in
    When user navigates to "Files" module
@US10-1
  Scenario: user can change folder view order by Name
    And user clicks Name located above all files and folder
    Then user can see the list of files sorted in alphabetical order
  @US10-2
  Scenario: user can change folder view by Size
    And user clicks Size located above all files and folder
    Then user can see the list of files sorted in descending order
  @US10-3
  Scenario: user can change folder view by Modified time
    And user clicks Modified located on the right end,above all files and folder
    Then the files are displayed in descending order by date