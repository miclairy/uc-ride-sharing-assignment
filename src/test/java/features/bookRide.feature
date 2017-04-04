Feature: Book a ride
  As ​​passenger​​, I want to ​​book a ride​​ so that I can get to where I am going.

  Scenario: Sally wants to book a ride
    Given Sally is a passenger
    And sally has selected a ride
    When sally books the ride
    Then sally will be expected on the ride and the available seats decreases
    And she will know that she booked the ride

  Scenario: Sally wants to book the same ride
    Given Sally is a passenger
    And sally has booked a ride
    When sally goes to book the ride again
    Then nothing happens and she is not included again.