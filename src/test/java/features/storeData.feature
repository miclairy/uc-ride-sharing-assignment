Feature: Store entered Data
  As a ​​user​​, I want the system to ​​store my data​​, so I don’t have to re-enter it everytime I restart the
  application.

  Scenario: Jo starts the application after entering some data
    Given there is a trip in the system
    When the application is closed and reopened
    Then the trip should still be there

  Scenario: Jo starts the application sharing a tip
    Given there is a trip in the system
    And there is a ride
    When the application is closed and reopened
    Then the ride should still be there