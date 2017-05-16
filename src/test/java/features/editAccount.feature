Feature: Edit Account

  Scenario: Sally edits her account
    Given Sally has an account
    When Sally changes her name to "sophie" and her phone number to "0275559999"
    Then Her details are changed

  Scenario: Sally edits her account
    Given Sally has an account
    When Sally changes her uc id to "sph23"
    Then Her details are not changed

  Scenario: Jo edits his account
    Given Jo has a driver account
    When Jo goes to edit his account and changes his license expiration to next year
    Then his new license information is stored