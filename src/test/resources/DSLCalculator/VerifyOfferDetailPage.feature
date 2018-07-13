Feature: Verify offer detail page
  Verify offer detail page in DSL Calculator

  Scenario: Result List - verify Offer detail page

    Given the User is on the DSL Result List
    When he selects one of the listed Tariffs
    And clicks on "mehr zum Tarif" button
    Then he should be able see the details of the selected Tariff
    And he should also see a button labeled as "In 5 Minuten online wechseln"