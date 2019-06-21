Feature: Work with cart
  In order to buy some goods
  As a customer
  I want to have ability to work with my shopping cart

  Background:
    Given  user on the main ebay page
    And go to 'sign in page'
    When user enters login as "nfname6@gmail.com", user enters password as "12345qweRt"

  Scenario Outline: Remove good from "Shopping cart"
    When user enters text as "<text>" in search field
    When click on random good
    When clicks on button "Add to cart"
    When clicks on the button "Remove"
    Then there isn`t deleted good in the "Shopping cart"
    Examples:
      | text |
      |book  |

  Scenario Outline: "Save for later" function
    When user enters text as "<text>" in search field
    When click on random good
    When clicks on button "Add to cart"
    When click on the button "Save for later"
    Then the good from "Shopping cart" must be replaced to "Save for later" category
    Examples:
      | text |
      |book  |

#  Scenario Outline: Check total sum
#    When user enters text as "<text>" in search field
#    When click on random good
#    When clicks on button "Add to cart"
#    Then "total" price tag at the cart page must be equal to the sum of products price in the cart
#    Examples:
#      | text |
#      |book  |