Feature: Create Route

  Scenario: Jo makes a route
    Given Jo is a driver and wants to make a route
    And there are more than 1 stop point
    When jo creates route by adding stop points
    Then a new route is stored with the stop points.