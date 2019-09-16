@Login
Feature: amazon - Login

  Background:
    Given Launch the application "https://www.amazon.co.uk/"
    When Clicked on Sign option

  @PositiveLogin @Regression
  Scenario: TC_002 To verify the positive login functionality
    Then Enter the username "abc"
    Then Enter the password "pass123"
    And Click Login

  @NegativeLogin
  Scenario Outline: TC_003 To verify the negative login functionality
    Then Enter the username "<UserName>"
    Then Enter the password "<Password>"
    And Click Login
    And Validate the business error message "<ErrorMessage>"

    Examples:
      | UserName       | Password  | ErrorMessage                                     |
      | test@gmail.com |           | Enter your password                              |
      |                | Pass01234 | Enter your e-mail address or mobile phone number |
      | jjjjiii009     | Pass012   | There was a problem                              |