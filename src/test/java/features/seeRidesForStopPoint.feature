Feature: See rides for a stop point
   As a ​​passenger​​, I want to ​​see the available rides at a specific stop point so that I
   can choose one.

  Scenario: Sally wants to see rides to get home
    Given there is some stop points including 6 "Hare" street.
    And sally is a passenger
    And there are some rides with 6 "Hare" street included as a stop point
    When sally selects a 6 "Hare" street
    Then the rides which have 6 "Hare" street as a stop point are seen.

  Scenario: Sally wants to filter the rides
    Given there is a stop point that has multiple rides that go to it.
    And sally has selected that stop point
    And sally is a passenger
    When sally selects a filter option "to uni"
    Then the rides which go "to uni" are seen.


