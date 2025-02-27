@US10
Feature: User be able to change folder view

  Background:
    Given the user already logged in
    When user navigates to "Files" module

  Scenario: user can change folder view order by Name
    And user clicks Name located above all files and folder
    Then user can see the list sorted in alphabetical order
