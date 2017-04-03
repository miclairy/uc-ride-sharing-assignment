Feature: Search stop point.
  As a user​, I want to search for existing stop points so that I can define or find rides

  Scenario: Search for stop points
    Given there is some stop points
    When when I search for a stop point buy entering "Bear"
    Then the search results should show 6 hare street as a result.