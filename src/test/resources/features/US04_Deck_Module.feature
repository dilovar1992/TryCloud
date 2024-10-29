#Feature: user should be able to manage his works by creating a new board/list/card and
 # modifying them under Deck Module.


@US04
  #Scenario: User should have the ability to create and edit his tasks to manage his work under the Deck.
  #    Given : User already logged in.
  #    When : User click on "Deck" Module.
  #    And : User should be able to create a new board.
  #   And : User should be able to create a new list of card under any board.
  #   And : User should be able to add a new card on any list on the current board.
  #   #Then : User should be able to assign any card to himself/herself by using the three dots on the related card.

Feature: Task Management under the Deck Module
  As a user, I should have the ability to create and edit tasks to manage my work under the Deck module.

  Scenario: User creates and edits tasks within the Deck
    Given User is already logged in
    When User clicks on the "Deck" module
    And User creates a new board
    And User creates a new list of cards under a board
    And User adds a new card to any list on the current board
    Then User assigns a card to himself/herself using the three "dots" menu on the related card.