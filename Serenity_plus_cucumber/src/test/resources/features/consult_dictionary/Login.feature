Feature: Login into ebay account
  In order to use all ebay features
  As a customer
  I want to login into my ebay account

  Scenario Outline: Login into ebay account with valid credentials
    Given user on the main ebay page
    And go to 'sign in page'
    When user enters login as "<login>", user enters password as "<password>"
    Then user name in top of the page must be equals to name as "<name>"
    Examples:
      | login             | password  |name|
      | nfname6@gmail.com | 12345qweRt|Name|