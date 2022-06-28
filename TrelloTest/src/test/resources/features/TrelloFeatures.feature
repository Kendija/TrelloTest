Feature: This Feature will test Trello API

  Scenario: Add new list to the test board after changing board title
    Given The test board exists and contains the correct information
    When I change the board title to "New Name"
    And I check that board name was updated to "New Name"
    Then I add list with title "Example List" to the board
