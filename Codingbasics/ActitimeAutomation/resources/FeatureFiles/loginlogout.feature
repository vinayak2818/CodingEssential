#Author: your.email@your.domain.com
# Created Date:
# Reviewed By:
#Purpose:
# Description :
@Execute
Feature: Login and Logout functionality
Description: Verify the login and logout functionality

Scenario: Login with valid credentials
Given Launch the application
And Navigate to the url of the application
When Login using valid credentials
|username|password|
|admin|manager|
Then the Home page should display
And minimize the flyout Window

Scenario: Logout from Application
When Perform logout action
Then the login page should display
And Close Application Browser

