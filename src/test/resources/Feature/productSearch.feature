Feature: Product Search
  Scenario: Search for a product by keyword
    Given I am on the Amazon home page
    When I search for "laptop"
    Then I should see search results
    And the results page should mention "laptop"