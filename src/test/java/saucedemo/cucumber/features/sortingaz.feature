Feature: Feature: Sorting name a to z
  @az
  Scenario: user sorting name a to z
    Given user is login on saucedemo website
    When user click the sort dropdown menu
    Then user select sort name a to z
    And products sorted by name from a to z