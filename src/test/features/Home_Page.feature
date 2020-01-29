Feature: Home Page functionality validating

  Scenario: Home Page URL validation
    When User enter URL - "https://www.novamed.online/"
    Then User should be on Home Page
    And User closed Browser

  Scenario: Home Page Title validation
    When User enter URL - "https://www.novamed.online/"
    Then The Home Page title should be - "Медицинские анализы. Диагностика и лечение. ДНК тесты и др"
    And User closed Browser

  Scenario: User can navigate to Home Page by clicking on the company logo (top of the Page)
   Given User enter URL - "https://www.novamed.online/"
    When Click on tab "O КЛИНИКЕ"
    And Click on company logo
    Then User should be on Home Page
    And User closed Browser

  Scenario: User can navigate to address page by clicking on address locator (top of the Page)
    Given User enter URL - "https://www.novamed.online/"
    When User click on address locator
    Then User should be on Contact Page
    And User closed Browser

  Scenario: Initially the Shopping Cart should be empty
    When User enter URL - "https://www.novamed.online/"
    Then Shopping cart should be empty
    And User closed Browser

  Scenario: User can request a call back
    When User enter URL - "https://www.novamed.online/"
    And Click on button "Request a call back"
    Then Page for request a call back is opened
    And User closed Browser