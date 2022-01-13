#feature means the application and the feature testing
Feature: To validate Login Application
 1) Valid Case
 2) Invalid Case
 
 # scenario is basically to tell what are we testing
 Scenario: To test login with valid scenario
 #given is the pre-condition
 Given i should open the browser and navigate to login page of orangeHRM
 #condition
 When Enter valid Name "Admin"
 And  Enter Valid password "admin123"
 And Click on login button
 #post condition
 Then i should see the username as welcome Peter "Welcome New Automation"
 
 Scenario: To test login with valid scenario
 Given i should open the browser and navigate to login page of orangeHRM
 When Enter valid Name "Admin"
 And  Enter Valid password "admin123"
 And Click on login button
 Then i should see the username as welcome Peter "Welcome New Automation"
 
 Scenario: To test login with Invalid scenario
 Given i should open the browser and navigate to login page of orangeHRM
 When Enter invalid Name "Swapnil"
 And  Enter invalid password "swapnil123"
 And Click on login button
 Then i should see the Invalid Credentials "Invalid credentials"