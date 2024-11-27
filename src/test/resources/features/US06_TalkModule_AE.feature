@US06
Feature: As a user, I should be able to create a new conversation, add participant under the Talk module

  @US06AC1
  Scenario:User can create a new conversation by adding any selected participant
    Given the user already logged in
    When user navigates to "Talk" module
    And user clicks Create new conversation button
    And user enters conversation name "Merhaba"
    And user clicks join via link checkbox
    And user clicks add participants button
    And user selects random participants
    And user clicks Create conversation button
    And user clicks on close button
    Then user should see "Merhaba" conversation under the list


  @US06AC2
  Scenario:User can delete a conversation
    Given the user already logged in
    When user navigates to "Talk" module
    And user opens the ellipses menu
    And user clicks "Delete Conversation" from the menu
    And user chooses "Yes" from the popup alert
    Then user should not see the conversation under the list

