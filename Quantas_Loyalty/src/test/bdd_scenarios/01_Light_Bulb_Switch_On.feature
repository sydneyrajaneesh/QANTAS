@First
Feature: verify Light bulb switches
  Scenario: Switch off and switch on light bulb
    Given an lightbulb challenge url
    When a user calls the switch on post method
    Then the lightbulb should throw light rays
    Then a user calls the switch off post method

    
    