Feature: See ride details
  As ​​passenger​​, I want to ​​see the details of a specific ride so that I can choose the
  best ride for me.

  Scenario: Sally sees details of a ride
    Given Sally is a passenger
    When sally selects a ride which is from "Jo" who is "gold" grade and with a 1995 "Green" "Subaru" with 4 seats available
    And the route is 20 minutes long with 3 stops.
    Then the rides details are displayed including drivers name, grade, car model, color, year, seats available, route length and number of stops.