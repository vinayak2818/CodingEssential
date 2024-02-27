#Author: your.email@your.domain.com
# Created Date:
# Reviewed By:
#Purpose:
# Description :

Feature: Login and Logout functionality
Description: Verify the login and logout functionality
Scenario Outline: Login with valid credentials
Given Launch the application
And Navigate to the url of the application
When Login using <username> and <password> credentials
When Perform logout action
Then the login page should display
And Close Application Browser

Examples: 
|username|password|
|admin|manager|
|admin|manager|
|admin|manager|