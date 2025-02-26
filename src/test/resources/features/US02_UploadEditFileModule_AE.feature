@US02 #cannot implement due to robot class issues with MacOS
Feature: User should be able to upload, edit and delete file from Files module

  @US02AC1
  Scenario: User should be able to upload file
    Given the user already logged in
    When user navigates to "Files" module
    And user clicks add icon
    And user select Upload file from new item menu
    And user refreshes the page
    Then user sees the uploaded file under the files list

  @US02AC2
  Scenario: User should be able create folder
    Given the user already logged in
    When user navigates to "Files" module
    And user clicks add icon
    And user select "New folder" from new item menu
    And user enters a "klasor" folder name
    And user clicks submit button
    And user refreshes the page
    Then user sees the "klasor" under the files list

  @US02AC3
  Scenario: User should be able delete any item by clicking ellipses menu
    Given the user already logged in
    When user navigates to "Files" module
    And user clicks ellipses on any file
    And user clicks "Delete file" from the ellipses menu
    Then user should not see the deleted file "Filename" under the files list

  @US02AC4
  Scenario: User can see the total number of files and folders under the files list table
    Given the user already logged in
    When user navigates to "Files" module
    Then user sees the total number of files and folders