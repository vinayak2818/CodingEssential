
Feature: Validating place API's
 
 @AddplaceAPI
  Scenario: Verify if place is being Successfully added using AddPlaceAPI
  
    Given Add Place payload with "<name>" "<address>" "<langauage>" "<phone_number>"
    When user calls "AddplaceAPI" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
		And "scope" in response body is "APP"
		And verify place_ID cfeated maps to "<name>" using "getplaceAPI"
		
	Examples:
	 |name           |address                |langauage      |phone_number    |
	 |Frontline House|29,side layout cohen 09|Kannada,English|(+91) 9449919003|
	# |Vinayak				 |33,ascd layout cscad 09|Kannada,English|(+91) 9482007317|
	
	@DeleteAPI
	Scenario: Verify if Delete place functionality is working
	
	Given Deleteplace Payload
	 When user calls "deleteplaceAPI" with "POST" http request
    Then the API call is success with status code 200 
    And "status" in response body is "OK"