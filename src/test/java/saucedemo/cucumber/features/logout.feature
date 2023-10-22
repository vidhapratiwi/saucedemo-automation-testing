Feature: User logout
  @Logout
  Scenario: user logout from saucedemo
    Given user login website
    Then user navigate to sidebar menu
    When user click logout button
    And user back to login page
