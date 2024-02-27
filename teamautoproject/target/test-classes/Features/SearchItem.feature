Feature: feature to test search items
Scenario: Relevant items are displayed after entering in Search box
Given home page
And User inputs relevant items in a search bar
When User searches items in a search box
And clicks search
Then User is shown all valid items
