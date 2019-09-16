@CreateAccount
Feature: amazon - Create Account

  Background:
    Given Launch the application "https://www.amazon.co.uk/"
    When Click on New Here option

  @PositiveCreateAccount @Regression
  Scenario: TC_001 To verify the positive create account functionality
    * Fill the Create Account form
      | Field      | Value       |
      | Name       | Hari        |
      | Email      | abc         |
      | Password   | Password123 |
      | RePassword | Password123 |
    Then Click on Continue button