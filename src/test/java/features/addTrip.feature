Feature: make trip
  As ​​driver​​, I want to ​​add trips so that I can set up all the information for the rides
  that I will share later on

  Scenario: Jo makes a trip
    Given jo is a driver making a trip
    And jo has some routes
    And Jo registered a car.
    When Jo creates a trip by defining it to be his only route "to university" 1500 each stop point 15 minutes after the previous
    And that the trip is recurrent so it repeats every "Wednesday" until 6th "May".
    Then the trip is displayed to jo with all information.
