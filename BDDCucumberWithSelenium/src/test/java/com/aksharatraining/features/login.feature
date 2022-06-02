# Author: Deepjyoti Barman
# Date: May 28, 2022
# Description: Feature to test the login scenarios.

@smoke @regression
Feature: Login

  Scenario: Regular login test
    Given The Login page is displayed
    When The user enters "abcd" as username and "pqrs" as password
    And The user clicks on the login button
    Then Home page should be displayed

  @positive
  Scenario: Valid login test
    Given The Login page is displayed
    When The user enters valid username and password
    And The user clicks on the login button
    Then Home page should be displayed

  @negative
  Scenario: In-valid login test
    Given The Login page is displayed
    When The user enters in-valid username and password
    And The user clicks on the login button
    Then Error message should be displayed
