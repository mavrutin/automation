Feature: feature to test marshalls store locator search with valid city and state combo
Scenario: validate store locator by valid city and state combo search is working
Given my browser is open
And user is on marshalls store locator search page
When the valid city 
And state is entered
And user clicks search button
Then then related results are visible