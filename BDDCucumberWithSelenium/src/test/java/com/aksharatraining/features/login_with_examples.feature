# Author: Deepjyoti Barman
# Date: June 10, 2022
# Description: Feature to test the login scenarios.

# A # language: header on the first line of a feature file tells Cucumber what spoken language to use
# Language settings are optional, Cucumber supports over 70 languages (e.g. fr for 'French')
# language: en

@scenario-outline-example
Feature: Login (data driven testing) with Scenario Outline and Examples.

  Background: Pre-condition
    Given Path of the driver executable is set
    And The browser is open
    And The browser is maximized

  Scenario Outline: Valid login with different data inputs
    Given The Login page is displayed
    When The user enters <username> as username and <password> as password
    And The user clicks on the login button
    Then Home page should be displayed

    Examples:
      | username | password |
      | admin    | manager  |
      | trainee  | trainee  |