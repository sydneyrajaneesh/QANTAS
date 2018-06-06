$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("01_Light_Bulb_Switch_On.feature");
formatter.feature({
  "line": 2,
  "name": "verify Light bulb switches",
  "description": "",
  "id": "verify-light-bulb-switches",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@First"
    }
  ]
});
formatter.scenario({
  "line": 3,
  "name": "Switch off and switch on light bulb",
  "description": "",
  "id": "verify-light-bulb-switches;switch-off-and-switch-on-light-bulb",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "an lightbulb challenge url",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "a user calls the switch on post method",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the lightbulb should throw light rays",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "a user calls the switch off post method",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "the lightbulb should be dark and status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "LightsOnandOff.lightbulb_challenge_url()"
});
formatter.result({
  "duration": 22451090985,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 38
    }
  ],
  "location": "LightsOnandOff.switch_off_post_method(String)"
});
formatter.result({
  "duration": 7963627562,
  "status": "passed"
});
formatter.match({
  "location": "LightsOnandOff.lightbulb_throws_lightrays()"
});
formatter.result({
  "duration": 6365473125,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 39
    }
  ],
  "location": "LightsOnandOff.switch_on_post_method(String)"
});
formatter.result({
  "duration": 1304382186,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 48
    }
  ],
  "location": "LightsOnandOff.lightbulb_is_dark(int)"
});
formatter.result({
  "duration": 5046675,
  "error_message": "java.lang.NullPointerException\r\n\tat servicelayer.LightsOnandOff.lightbulb_is_dark(LightsOnandOff.java:81)\r\n\tat ✽.Then the lightbulb should be dark and status code is 200(01_Light_Bulb_Switch_On.feature:8)\r\n",
  "status": "failed"
});
});