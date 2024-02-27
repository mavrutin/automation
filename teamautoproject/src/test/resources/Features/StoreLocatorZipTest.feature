Feature: feature to test marshalls store locator search
Scenario: Validate store locator by zip search is working
Given browser is open
And User is on marshalls store locator search page
When User enters a zip code in a search box
And hits search button
Then User is navigated to search feature