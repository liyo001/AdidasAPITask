@petstore
Feature: Verify the functionality related to pet store

@1
Scenario: get available Pet
		Given I "get" the pet using endpoint
		Then I validate the available pets details in response
@2
Scenario: Create a Pet
		Given I "create" the pet using endpoint
		Then I validate pet details in response
		
@3	
Scenario: Update a Pet
		Given I "update" the pet using endpoint
		Then I validate updated pet details in response
@4
Scenario: Delete a Pet
		Given I "delete" the pet using endpoint
		Then I validate the response
@5		
Scenario: Verify the deleted Pet
		Given I "verifiedDeleted" the pet using endpoint
		Then I validate deleted pet details in response
		
		
		
	