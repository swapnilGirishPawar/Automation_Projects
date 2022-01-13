Feature: TO validate search functionality.

Scenario: To test Search scenario
Given I should open the flipkart website.
When Enter the Email ID "pswapnil032@gmail.com"
And Enter the password  "swapnil123"
And Click on the login button
And Search for Product - "<Products>"

Then I should see the relevant search results "<Products>"
      
Examples: 
      |      Products      |
      |     I phone XR     |
      |  Bluetooth Speaker |
      |    Polo T-Shirt    |

Scenario: user able to see count of eight after putting details in Search bar.