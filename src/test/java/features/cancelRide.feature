Feature: Cancel Ride
  As a ​​driver​​, I want to ​​cancel a ride so the passengers will be notified that I will no longer be
  picking them up

  Scenario: Jo cancels a ride
    Given Jo is a driver who wants to cancel a ride
    And Jo has a trip which he has shared
    And there are passengers booked on the ride
    When jo selects to cancel the ride
    Then the passengers are notified
    And the ride is no longer available