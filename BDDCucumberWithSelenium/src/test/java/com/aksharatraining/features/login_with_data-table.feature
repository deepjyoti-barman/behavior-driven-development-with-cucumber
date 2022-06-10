# Author: Deepjyoti Barman
# Date: June 10, 2022
# Description: Feature to test the login scenarios.

@data-table-example
Feature: Demonstrate the usage of data tables.

  Background: Pre-condition
    Given Path of the driver executable is set
    And The browser is open
    And The browser is maximized

  @data-table1
  Scenario: Online registration for badminton doubles championship (List<List<String>> / List<Map<String, String>>)
    Given The Registration page is displayed
    When The user enters the following details
      | firstname | lastname | phoneno    |
      | Venkatesh | Iyer     | 9876543210 |
      | Ravindra  | Trivedi  |            |
    And The user clicks on the submit button
    Then Registration success page should be displayed

  @data-table2
  Scenario: Online registration for badminton singles championship (List<String>)
    Given The Registration page is displayed
    When The user enters the following information
      | Venkatesh  |
      | Iyer       |
      | 7654321098 |
    And The user clicks on the submit button
    Then Registration success page should be displayed

  @data-table3
  Scenario: Online registration for badminton singles championship (Map<String, String>)
    Given The Registration page is displayed
    When The user fills in the fields with necessary data
      | firstname | Venkatesh |
      | lastname  | Iyer      |
      | phoneno   |           |
    And The user clicks on the submit button
    Then Registration success page should be displayed

  @doc-string
  Scenario: Online registration for badminton singles championship (String)
    Given The Registration page is displayed
    When The user enters his bio as the following
      """
      Hello everyone,

      How are you all? Keep your spirits high,
        and all the best for the championship.

      From,
      (Defending Champ) Tarun
      """