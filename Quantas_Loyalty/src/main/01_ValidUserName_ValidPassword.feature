@First
Feature: Switch On Light Bulb
  @switch_On
  Scenario: User calls web service to connect to Login Page
    Given a light bulb webpage with a lightbulb is displayed
    When a user calls the Login URL using post method with switch set to "On"
    Then the light bulb in the webpage should be also set to On 