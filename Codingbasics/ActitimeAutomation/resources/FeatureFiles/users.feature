#Author: your.email@your.domain.com
# Created Date:
# Reviewed By:
#Purpose:
# Description :
@Execute
Feature: Create User Scenarios
Description This feaure describes create user functionalities.

Scenario: Login with valid credentials
Given Launch the application
And Navigate to the url of the application
When Login using valid credentials
|username|password|
|admin|manager|
Then the Home page should display
And minimize the flyout Window

Scenario: Create the user
When Create an User
|firstname|lastname|email|username|userpassword|userretypepasword|
|demo|User1|demoUser@gmail.com|demoUser1|Welcome1|Welcome1|
Then User should create successfully

Scenario: Delete the created user
When delete the user
Then the user should delete

Scenario: Logout from Application
When Perform logout action
Then the login page should display
And Close Application Browser