@US07
Feature: User should be able to see all deleted file, delete and restore files
  User Story: As a user, I should be able to see all deleted files and delete/restore them permanently under Deleted files

  Background:
    Given the user already logged in
    When user navigates to "Files" module


  @US07-AC1
  Scenario: User order deleted files by newest to oldest
    And user creates "Dilo" and "Turaev" files
    And user deletes "Dilo" and "Turaev" files
    And user clicks on Deleted files under All files
    Then user clicks Deleted to see files sorted

  @US07-AC2
  Scenario: user delete permanently any deleted files
    And user clicks on Deleted files under All files
    And user deletes "Turaev" file permanently by using ellipses in the file's line
    Then user do not see deleted "Turaev" file

  @US07-AC3
  Scenario: user can restore any files and see it on All files
    And user clicks on Deleted files under All files
    And user restore deleted "Dilo" file by using Restore in the file's line
    And user goes to All Files
    Then uses see the restored "Dilo" file
