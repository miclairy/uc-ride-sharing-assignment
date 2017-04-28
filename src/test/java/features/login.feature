Feature: Login
  As a ​​user​​, I want to ​​log into my account​​ so I can use the system.

  Scenario: Jo successfully logs in to his account
    Given jo has an account
    When he enters the correct email and password
    Then he is let into his account with his trips etc


  Scenario: Jo fails to get into his account
    Given jo doesn't have an account
    When jo tries to log in
    Then he is told the credentials are wrong

