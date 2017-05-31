Feature: Notify User of expiration
  As a ​​driver​​, I want to be ​​notified ​​if my drivers licence, WOF or registration is about to expire so I
  can renew them on time.

  Scenario: license expires in one month
    Given Jo has an account
    And his license expires in one month
    When logs in
    Then he will be notified that his license going to expire.

  Scenario: WOF expires in one month
    Given Jo has an account
    And his WOF expires in one month
    When logs in
    Then he will be notified that s WOF is going to expire.

  Scenario: registration and licence expires in one month
    Given Jo has an account
    And his registration expires in one month
    And his license expires in one month
    When logs in
    Then he will be notified that the registration and license are going to expire.

  Scenario: licence expires in 3 weeks
    Given Jo has an account
    And his registration expires in 3 weeks
    When logs in
    Then he will not be notified that it is going to expire.