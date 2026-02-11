Feature: Amazon navigation to Kindle Books

  Scenario: Change delivery location to India and navigate to Kindle Books
    Given I open the Amazon website
    When I go to the delivery address section
    And I change the location to India
    Then the page should update to show delivery in India

    When I open the "All" tab from the left side menu
    And I navigate to "Kindle E-Readers & Books"
    And I select "Kindle Books"
    Then the Kindle Books page should be displayed

    When I navigate back to the main page
    Then the Amazon homepage should be displayed
    And I close the browser
