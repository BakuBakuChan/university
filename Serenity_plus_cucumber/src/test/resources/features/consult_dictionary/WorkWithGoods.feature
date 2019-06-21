Feature: Work with goods
  In order to buy some goods
  As a customer
  I want to have ability to see all information about good and have ability to add in into basket and in my favorite

  Background:
    Given  user on the main ebay page

  Scenario Outline: Enter on good page
    And go to 'sign in page'
    When user enters login as "<login>", user enters password as "<password>"
    When user enters text as "<text>" in search field
    When click on random good
    Then user should have a page with good full description
    Examples:
      | login             | password   |text  |
      | nfname6@gmail.com | 12345qweRt |book  |
      | nfname6@gmail.com | 12345qweRt |cat   |


  Scenario Outline: Add goods to "Shopping cart"
    And go to 'sign in page'
    When user enters login as "<login>", user enters password as "<password>"
    When user enters text as "<text>" in search field
    When click on random good
    When clicks on button "Add to cart"
    Then good must be in the user`s "Shopping cart"
    Examples:
      | login             | password   |text  |
      | nfname6@gmail.com | 12345qweRt |book  |
      | nfname6@gmail.com | 12345qweRt |cat   |