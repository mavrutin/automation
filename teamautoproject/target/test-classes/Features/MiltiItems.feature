Feature: feature to test search multiple items

  Scenario Outline: Search for multiple invalid items
    Given user on home page
    When Add "<phrase>" to search
    Then userb expects "<related>" on page

    Examples: Animals
      | phrase   | related       |
      | drill    | searched      |
      | abc123   | no result     |
