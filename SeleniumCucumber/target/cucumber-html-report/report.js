$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Selenium.feature");
formatter.feature({
  "name": "To type a keyword in Google website",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Check the typing of keyword",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "navigate to \"http://www.google.com\"",
  "keyword": "Given "
});
formatter.match({
  "location": "seleniumSteps.navigate_to(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "We type the keyword in google edit box",
  "keyword": "When "
});
formatter.match({
  "location": "seleniumSteps.we_type_the_keyword_in_google_edit_box()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "We click on Google Search button",
  "keyword": "And "
});
formatter.match({
  "location": "seleniumSteps.we_click_on_Google_Search_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "We validate the \"cucumbe\"",
  "keyword": "Then "
});
formatter.match({
  "location": "seleniumSteps.we_validate_the(String)"
});
formatter.result({
  "error_message": "junit.framework.ComparisonFailure: expected:\u003c[cucumbe]\u003e but was:\u003c[Cucumber]\u003e\r\n\tat junit.framework.Assert.assertEquals(Assert.java:100)\r\n\tat junit.framework.Assert.assertEquals(Assert.java:107)\r\n\tat steps.seleniumSteps.we_validate_the(seleniumSteps.java:91)\r\n\tat ✽.We validate the \"cucumbe\"(file:src/test/resources/features/Selenium.feature:7)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png", null);
formatter.after({
  "status": "passed"
});
});