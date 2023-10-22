Feature: User Login Page Saucedemo
  @Login
  Scenario Outline: User login
    Given user opens the website page
    When user input <username> as username
    And user input <password> as password
    And click login button
    Then user verify <status> login result

    Examples:
    | username      | password     | status  |
    | standard_user | secret_sauce | success |
    | standard_user | failed_login | failed  |