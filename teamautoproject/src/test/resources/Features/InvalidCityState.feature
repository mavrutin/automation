Feature: feature to test marshalls store locator search with invalid city and state combo
Scenario: validate store locator by invalid city and state combo search is working
Given user browser is open
And it is on marshalls store locator search page
When the "<phrase>" city 
And state "<value>" is entered
And search button clicked
Then verify the "<related>" in step

    Examples: City
			| phrase | value   | related 				   |
      | Boston | Ontario | stores were found |
      | Lima   | State 	 | provide a valid	 |