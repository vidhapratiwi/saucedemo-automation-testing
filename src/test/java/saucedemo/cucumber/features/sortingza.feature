Feature: Feature: Sorting name z to a
  @za
  Scenario: user sorting name z to a
    Given user is login on the website
    When user click the sort dropdown menu on page
    Then user select sort name z to a
    And products sorted by name from z to a