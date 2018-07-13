Feature: Verify result list
  Verify result list in DSL Calculator

  Scenario: DSL Result List - verify result list

    Given the User is on www.verivox.de
    When he is on the DSL calculator
    And he enters prefix/code “Ihre Vorwahl” as 030 with 16 Mbit/s bandwidth selection
    And clicks on the button labeled as "JETZT VERGLEICHEN"
    Then he should be able see the Result List page with all the available Tariffs