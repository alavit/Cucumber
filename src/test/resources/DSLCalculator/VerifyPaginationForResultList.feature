Feature: Pagination for loading the Result List

  Scenario: Verify Lazy loading/pagination for loading the Result List

    Given the User is on the DSL Result List-1
    When there are more than 20 tariffs available for the provided Vorwahl and bandwidth
    Then the User should a button labeled as "20 weitere laden"
    When he/she clicks on this button
    Then the list should be appended with next 20 tariffs and so on until all Tariffs are loaded