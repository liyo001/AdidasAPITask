@petstore
Feature: Verify the functionality to create the plan.


@1
Scenario: verify the create plan in system
		Given I "create" the pet using endpoint
		Then I validate plan details in response
		
		
@2
Scenario: get the plan using planName
		Given I "get" the pet using endpoint
		Then I validate the plan details in response
		

		
		
		
	