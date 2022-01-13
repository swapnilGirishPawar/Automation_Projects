
Feature: To validate Login Application
 1) Valid Case
 2) Invalid Case
 
 @PositiveTesting
 Scenario: To test login with valid scenario
 Given i should open the browser and navigate to login page of FLipkart
 When Enter valid Name "pswapnil032@gmail.com"
 And  Enter Valid password "swapnil123"
 And Click on login button
 Then i should see the Home page of flipkart "Swapnil" 
 
 @NegetiveTesting
 Scenario: To test login with Invalid scenario
 Given i should open the browser and navigate to login page of Flipkart
 When Enter invalid Name "Swapnil@gmail.com"
 And  Enter invalid password "swapnil@123"
 And Click on login button
 
 Then i should see the Invalid Credentials "Your username or password is incorrect"