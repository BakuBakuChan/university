Feature: Sort search result
  In order to buy some specific goods
  As a customer
  I want to have ability to sort search results

  Background:
    Given  user on the main ebay page
    When user enters text as "book" in search field

  Scenario: Filters for goods
    When chooses one of filters in checkbox
    Then description of random good contains a filter value

  Scenario: Filters for goods
    When chooses one of filters in radio button
    Then description of random good contains a filter value

    Scenario: Sort goods
      When chooses one of sort criteria
      Then description of random good match to sort criteria