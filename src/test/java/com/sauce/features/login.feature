@login
Feature: Sauce Lab Application

  Scenario Outline: Successful login to Swag Labs
    Given user read data from excel sheet "testData" sheet "users" for test "<TC_NO>"
    When the user logs in with username and password
    Then the dashboard title should be "Swag Labs"
    * user add to cart
    * the user navigates to the cart
    * the user proceeds to checkout
    * the user enters checkout details with "John" "Doe" "560001"
    * the user continues to the overview page
    * the user completes the checkout
    * the order should be placed successfully
    Examples:
      | TC_NO  |
      | TC_001 |
      | TC_002 |
      | TC_003 |
      | TC_004 |
      | TC_005 |