$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/saganworks.feature");
formatter.feature({
  "name": "Saganworks WebPage Functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Sagan"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on site \"https://app.saganworks.com/Account/Login\"",
  "keyword": "Given "
});
formatter.match({
  "location": "SaganworksSteps.userIsOn(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Validate Email input box",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Sagan"
    },
    {
      "name": "@Task4"
    }
  ]
});
formatter.step({
  "name": "user clicks on email input box",
  "keyword": "When "
});
formatter.match({
  "location": "SaganworksSteps.userClicksOnEmailInputBox()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enters email address",
  "keyword": "And "
});
formatter.match({
  "location": "SaganworksSteps.entersEmailAddress()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on login",
  "keyword": "And "
});
formatter.match({
  "location": "SaganworksSteps.userClicksOnLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login fails",
  "keyword": "Then "
});
formatter.match({
  "location": "SaganworksSteps.loginFails()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});