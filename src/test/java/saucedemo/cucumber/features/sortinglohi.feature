Feature: Sorting price low to high
  @lohi
  Scenario: user sorting price low to high
    Given user login the website
    When user click sort dropdown
    Then user select price low to high
    And products are sorted by the lowest price