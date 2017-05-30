Feature: Register Car
  As a ​ driver​ , I want to ​ register a car​ so that it can be used for sharing a ride.

  Scenario: Jo registers car
      Given Jo is a driver
      And Jo has a car with 5 seats and type is "Small Car"
      And license plate "YTZ235"
      And year 2001
      And the car colour is "green", model is "Subaru"
      When the car is registered
      Then the car's attributes of year 2001, license plate "YTZ235", colour "green" and 5 seats are stored.


  Scenario: Jo registers 2 cars
    Given Jo is a driver
    And Jo has a car registered a car
    When jo registers a new car
    Then the car's is registered and jo has add the car to his account


  Scenario: Jo registers car with no seats or year that doesn't exist
    Given Jo is a driver
    When jo registers a "car" with 0 seats and license plate of "123TRE" and year -2000 and the colour is "blue"and the model is "holden"
    Then the car is not made and exception is thrown

