Feature: This feature cntains the login functionality validations

Scenario Outline: User logs in with valid credentials
    Given the user is on the login page
    When the user clicks on the login button
    When the user enters valid username "<username>" and password "<password>"
    When user clicks on Login popup window
    Then the user should be redirected to the Homepage and greetings welcome "<username>"

    Examples:
      | username | password |
      | vennela   | abcd   |

Scenario Outline: Validate Demo blaze url 
      Given open browser navigate to google homepage
      When search for "<Text>"
      Then results should contains "<Text>" link
      When click on first result
      Then validate the url of the current window 
      
      Examples:
      |Text|
      |Demo Blaze|
      
     #Product Search
  Scenario Outline: Searching for a product on the website
    Given I am on the homepage of the website
    Then I should see search results for "<Product>"
    Then user is able to add to the cart successfully "<Product>"
    When product is added to cart then gotocart
    Then user is able to click the place order button
    
    Examples:
      | Product |
      | Samsung galaxy s6   |
     

Scenario: To test sign up with valid credentials
    Given the user is on the login page
    When user clicks sign up button
    And user enters valid username and password
    And clicks sign up button
    Then user should be able to sign up successfully
