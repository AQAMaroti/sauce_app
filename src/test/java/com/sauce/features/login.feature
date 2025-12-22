@login
Feature: Sauce Lab Application

  Scenario Outline: Successful login to Swag Labs
    When the user logs in with username "<username>" and password "<password>"
    Then the dashboard title should be "Swag Labs"
    * user add to cart
      | product    |
      | backpack   |
      | bike-light |
      | t-shirt    |
    * the user navigates to the cart
    * the user proceeds to checkout
    * the user enters checkout details with "John" "Doe" "560001"
    * the user continues to the overview page
    * the user completes the checkout
    * the order should be placed successfully
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | standard_user | secret_sauce |
      | standard_user | secret_sauce |
      | standard_user | secret_sauce |