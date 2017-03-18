Feature: create stop points
  As ​​driver​​, I want to ​​create stop points so I can specify where I will pick up or drop
  off passengers

  Scenario: Bob adds stop point
    Given bob is a driver
    When bob creates a stop point at 21 "Halswell Junction Road"
    Then the street address is stored as a stop point


  Scenario: Sally adds a stop point already made
    Given Sally is a driver
    When Sally creates a stop point at 21 "Halswell Junction Road" after bob
    Then a new stop point is not made