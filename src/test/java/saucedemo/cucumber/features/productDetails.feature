Feature: Check the product details
  @Product
  Scenario: User check the product details
    Given user already login to saucedemo
    When user click on product name
    Then product details is displayed