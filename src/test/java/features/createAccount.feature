Feature: Create an Account
  As a ​​potential user​​, I want to ​​create an account​​ so that I can use the system effectively (see story 3)

  Scenario: jo creates a driver account
    Given jo clicked become driver
    When jo enters "jo", "6 hare street", 027555555 and "ab34@uclive.ac.nz" and he uploads a photo and enters the password "password1" twice
    Then the email and password are verified and he is asked for his drivers license information
    When jo enters type "full", "FR123456", "02/01/2010", "02/01/2020"
    Then it is verified he can carry passengers
    And his details are stored and account is created