package com.qa.adidas.stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.testng.Assert;

import com.qa.adidas.restclient.RestClient;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

public class PetStoreStepDef {
    public static final HashMap<String, String> map = new HashMap<>();
    public static Response response;
    public static Properties prop;
    String createPet;
    String getPetByStatus;
    String updatePet;
    String deletedPet;

    @Given("^I \"([^\"]*)\" the pet using endpoint$")
    public void i_something_the_pet_using_endpoint(String method)
            throws IOException {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir")
                            + "/src/test/resources/Config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String baseURI = prop.getProperty("baseURI");

        if (method.equalsIgnoreCase("create")) {
            createPet = prop.getProperty("createPet");
            response = RestClient.doPost("JSON", baseURI, createPet, null, null,
                    true);
            System.out.println(response.prettyPrint());
        } else if (method.equalsIgnoreCase("get")) {
            HashMap<String, String> pathParms = new HashMap<>();
            pathParms.put("status", "available");
            getPetByStatus = prop.getProperty("getPetByStatus");
            response = RestClient.doGet("JSON", baseURI, getPetByStatus,
                    pathParms, null, true);
            System.out.println(response.prettyPrint());
        } else if (method.equalsIgnoreCase("verifiedDeleted")) {
            deletedPet = prop.getProperty("deletedPet");
            response = RestClient.doGet("JSON", baseURI, deletedPet, null,
                    map.get("petID"), true);
            System.out.println(response.prettyPrint());
        } else if (method.equalsIgnoreCase("update")) {
            updatePet = prop.getProperty("updatePet");

            response = RestClient.doUpdate("JSON", baseURI, updatePet, null,
                    null, true);
            System.out.println(response.prettyPrint());
        } else {
            deletedPet = prop.getProperty("deletedPet");

            response = RestClient.dodelete("JSON", baseURI, deletedPet, null,
                    map.get("petID"), true);
            System.out.println(response.prettyPrint());
        }

    }

    @Then("^I validate the available pets details in response$")
    public void i_validate_the_available_pets_details_in_response()

    {

        List<Object> list = response.jsonPath().getList("status");

        for (Object object : list) {

            if (!object.equals("available")) {
                System.out.println("Pets status is not correct.");
                break;
            }

        }

    }

    @Then("^I validate pet details in response$")
    public void i_validate_pet_details_in_response()

    {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String status = response.jsonPath().getString("status");

        Assert.assertEquals(status, "available");
    }

    @Then("^I validate updated pet details in response$")
    public void i_validate_updated_pet_details_in_response()

    {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String status = response.jsonPath().getString("status");

        Assert.assertEquals(status, "sold");

        String id = response.jsonPath().getString("id");
        map.put("petID", id);
    }

    @Then("^I validate the response$")
    public void i_validate_the_response() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String type = response.jsonPath().getString("type");
        Assert.assertEquals(type, "unknown");

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "3");
    }

    @Then("^I validate deleted pet details in response$")
    public void i_validate_deleted_pet_details_in_response()

    {

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);

        String type = response.jsonPath().getString("type");
        Assert.assertEquals(type, "error");

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "Pet not found");
    }

}
