Feature: To validate the login
1) Valid Login
2) Invalid Login

Scenario: To validate the log in with valid scenario
Given I should open the flipkart website.
When Enter the Email ID.
And Enter the password.
And Click on the login button.
Then Home page should be opened.

Scenario: To validate the log in with invalid scenario
Given I should open the flipkart website.
When Enter the email ID.
And enter the password.
And Click on Login button.
Then I should see - Your username or password is incorrect.

