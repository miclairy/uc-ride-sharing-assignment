Feature: Register Car
  As a ​ driver​ , I want to ​ register a car​ so that it can be used for sharing a ride.

  Scenario: Jo registers car
      Given Jo is a driver
      And Jo has a car with 5 seats
      And license plate "YTZ235"
      And year 2001
      And the car colour is "green"
      When the car is registered
      Then the car's attributes of year 2001, license plate "YTZ235", colour "green" and 5 seats are stored.
