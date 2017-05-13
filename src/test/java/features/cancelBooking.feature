Feature: Cancel booking
  As a ​​passenger​​, I want to ​​cancel a booked ride so that the driver will be informed and the seat
  can be used by someone else.

  Scenario: Sally cancels a booking
    Given sally has booked a ride and wants to cancel it
    When sally cancels the booking because "she is busy"
    Then the drivers car is available again if it wasn't before with updated available seats
    And the driver is notified of the cancellation
