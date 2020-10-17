$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/PetStore.feature");
formatter.feature({
  "name": "Verify the functionality related to pet store",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@petstore"
    }
  ]
});
formatter.scenario({
  "name": "get available Pet",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@petstore"
    },
    {
      "name": "@1"
    }
  ]
});
formatter.step({
  "name": "I \"get\" the pet using endpoint",
  "keyword": "Given "
});
formatter.match({
  "location": "PetStoreStepDef.i_something_the_pet_using_endpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the available pets details in response",
  "keyword": "Then "
});
formatter.match({
  "location": "PetStoreStepDef.i_validate_the_available_pets_details_in_response()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Create a Pet",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@petstore"
    },
    {
      "name": "@2"
    }
  ]
});
formatter.step({
  "name": "I \"create\" the pet using endpoint",
  "keyword": "Given "
});
formatter.match({
  "location": "PetStoreStepDef.i_something_the_pet_using_endpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate pet details in response",
  "keyword": "Then "
});
formatter.match({
  "location": "PetStoreStepDef.i_validate_pet_details_in_response()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Update a Pet",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@petstore"
    },
    {
      "name": "@3"
    }
  ]
});
formatter.step({
  "name": "I \"update\" the pet using endpoint",
  "keyword": "Given "
});
formatter.match({
  "location": "PetStoreStepDef.i_something_the_pet_using_endpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate updated pet details in response",
  "keyword": "Then "
});
formatter.match({
  "location": "PetStoreStepDef.i_validate_updated_pet_details_in_response()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete a Pet",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@petstore"
    },
    {
      "name": "@4"
    }
  ]
});
formatter.step({
  "name": "I \"delete\" the pet using endpoint",
  "keyword": "Given "
});
formatter.match({
  "location": "PetStoreStepDef.i_something_the_pet_using_endpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the response",
  "keyword": "Then "
});
formatter.match({
  "location": "PetStoreStepDef.i_validate_the_response()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify the deleted Pet",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@petstore"
    },
    {
      "name": "@5"
    }
  ]
});
formatter.step({
  "name": "I \"verifiedDeleted\" the pet using endpoint",
  "keyword": "Given "
});
formatter.match({
  "location": "PetStoreStepDef.i_something_the_pet_using_endpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate deleted pet details in response",
  "keyword": "Then "
});
formatter.match({
  "location": "PetStoreStepDef.i_validate_deleted_pet_details_in_response()"
});
formatter.result({
  "status": "passed"
});
});