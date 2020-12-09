Feature:	To type a keyword in Google website

Scenario:	Check the typing of keyword
Given navigate to "http://www.google.com"
When We type the keyword in google edit box
And We click on Google Search button
Then We validate the "cucumbe"