Feature: Create an Account
  As a ​​potential user​​, I want to ​​create an account​​ so that I can use the system effectively (see story 3)

  Scenario: jo creates a driver account
    Given jo clicked become driver
    When jo enters "jb34", "jo", "6 hare street", "027555555" and "jb34@uclive.ac.nz" and he uploads a photo and enters the password "password1" twice
    Then the email and password are verified and he is asked for his drivers license information
    When jo enters type "full", "FR123456", "02/01/2010", "02/01/2020"
    Then it is verified he can carry passengers
    And his details are stored and account is created

  Scenario: sally creates a passenger account
    Given sally clicked to become a passenger
    When sally enters "sal34", "sally", "8 bear street", "021444556" and "sal34@canterbury.ac.nz" and she uploads a photo and enters the password "funlover2" twice
    Then the email and password are verified and her account is created

  Scenario: sally forgets she already signed up and signs up again
    Given sally is already signed up
    When sally enters "sal34", "sally", "8 bear street", "021444556" and "sal34@canterbury.ac.nz" and she uploads a photo and enters the password "funlover2" twice
    Then the email fails verification and she is told the email is already in use