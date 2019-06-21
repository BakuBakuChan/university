Feature: Search for anything
  In order to buy some goods
  As a customer
  I want to have ability to search them

  Background:
    Given  user on the main ebay page

  Scenario Outline: Search for goods
    When user enters text as "<text>" in search field
    Then user should have a page with goods with text as "<text>" in name
    Examples:
      | text |
      |book  |
      |cat   |
      |violin|

  Scenario: Search for goods in specific category from top of the page
    When user points on category name and clicks on some subcategory name
    Then user should have a page with goods with key word from subcategory name in goods name


  Scenario: Search for goods in specific category from "Shop by category" button
    When user clicks on "Shop by category" button and clicks on some subcategory name and clicks on subcategory of previous subcategory
    Then user should have a page with goods with key word from subcategory name in goods name


  Scenario: Search for goods in specific category from all categories
    When user clicks on "Shop by category" button and clicks on "see all categories" and clicks on some subcategory name
    Then user should have a page with goods with key word from subcategory name in goods name