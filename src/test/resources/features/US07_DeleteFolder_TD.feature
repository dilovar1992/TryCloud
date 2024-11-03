@US07
Feature: User should be able to see all deleted file, delete and restore files
  User Story: As a user, I should be able to see all deleted files and delete/restore them permanently under Deleted files

  Background:
    Given the user already logged in
    When user navigates to "Files" module
    And user clicks on Deleted files under All files
@US07-AC1
  Scenario: User order deleted files by newest to oldest
    Then user clicks Deleted to see files sorted

  @US07-AC1
  Scenario: user delete permanently any deleted files
      And user deletes permanently by using ellipses in the file's line

  @US07-AC1
  Scenario: user can restore any files and see it on All files
        And user restore deleted file by using Restore in the file's line
        And user goes to All Files
        Then uses see the restored "Dilo" file
