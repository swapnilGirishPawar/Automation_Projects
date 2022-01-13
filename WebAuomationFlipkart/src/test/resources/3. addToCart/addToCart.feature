Feature: TO validate Add to cart functionality.
Scenario: To test Add to cart scenario
Given I should open the flipkart website.
When Enter the Email ID "pswapnil032@gmail.com"
And Enter the password  "swapnil123"
And Click on the login button
And Search for Product - "Iphone 13"
And Click on the add to on particular product "APPLE iPhone 13 (Pink, 256 GB)"
And click on Add to Cart Option.

Then I should able to see the same searched product in the Cart page.