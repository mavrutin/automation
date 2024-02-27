Feature: feature to test search items
Scenario: Irrelevant items are displayed after entering in Search box
Given User is on home page
When User searches irrelevant items in a search box
And User clicks search
Then User is shown no results
