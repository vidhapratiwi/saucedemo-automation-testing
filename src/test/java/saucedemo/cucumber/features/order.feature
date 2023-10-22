Feature: User make an order
  @Order
  Scenario: user successfully make an order
    Given user login to saucedemo
    When user click the add to cart button
    Then user click the icon cart button
    And the selected product is displayed
    And user click the checkout button
    Then user fills the information form
    And user click the continue button
    Then order overview is displayed
    And user click the finish button
    Then the confirmation message is diplayed

