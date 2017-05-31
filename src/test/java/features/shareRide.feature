Feature: Share Ride
  As a ​ driver​ , I want to ​ share a ride so that it can be displayed to potential passengers.

  Scenario: Jo shares a ride
    Given Jo has made a trip
    When jo shares the trip with 3 available seats
    Then a ride that can be booked is created and the trip is shared

  Scenario: Jo shares a ride
    Given Jo has made a trip
    When jo shares the trip with 13 available seats
    Then a ride that can be booked is created with the maximum number of seats in the car


