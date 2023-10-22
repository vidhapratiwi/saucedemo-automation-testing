Feature: Sorting price high to low
  @hilo
  Scenario: user sorting price high to low
    Given user login to saucedemo website
    When user click the sort dropdown
    Then user select price high to low
    And products are sorted by the highest price