Feature: feature to test marshalls store locator search with invalid zip
Scenario: Validate store locator by invalid zip search is working
Given a browser is on marshalls store locator search page
When the invalid zip code is entered
And User clicks search button
Then the related results are visible