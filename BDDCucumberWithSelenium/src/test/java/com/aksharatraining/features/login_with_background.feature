# Author: Deepjyoti Barman
# Date: May 28, 2022
# Description: Feature to test the login scenarios.

@sanity
Feature: Login with Background

  Background: Pre-condition
    Given Path of the driver executable is set
    And The browser is open
    And The browser is maximized

  Scenario: Regular login test with Background first
    Given The Login page is displayed
    When The user enters "abcd" as username and "pqrs" as password
    And The user clicks on the login button
    Then Home page should be displayed

  Scenario: Regular login test with Background second
    Given The Login page is displayed
    When The user enters "abcd" as username and "pqrs" as password
    And The user clicks on the login button
    Then Home page should be displayed