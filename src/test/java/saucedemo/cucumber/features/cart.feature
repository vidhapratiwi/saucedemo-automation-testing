Feature: Add to cart
  @Cart
  Scenario: add product to cart
    Given user success login to saucedemo
    When user click the add to cart button on selected product
    Then user click the cart icon button
    And the selected product will be displayed