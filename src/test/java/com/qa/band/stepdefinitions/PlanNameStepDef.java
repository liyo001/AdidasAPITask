package com.qa.band.stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.testng.Assert;

import com.qa.band.restclient.RestClient;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

public class PlanNameStepDef {
    public static final HashMap<String, String> map = new HashMap<>();
    public static Response response;
    public static Properties prop;
    String createPlan;
    String getPlanName;

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
            createPlan = prop.getProperty("createPlan");
            response = RestClient.doPost("JSON", baseURI, createPlan, null,
                    null, true);
            System.out.println(response.prettyPrint());
        } else if (method.equalsIgnoreCase("get")) {
            HashMap<String, String> pathParms = new HashMap<>();
            pathParms.put("planName", "Tarun");
            getPlanName = prop.getProperty("getPlanName");
            response = RestClient.doGet("JSON", baseURI, getPlanName, pathParms,
                    null, true);
            System.out.println(response.prettyPrint());
        }

    }

    @Then("^I validate the plan details in response$")
    public void i_validate_pet_details_in_response()

    {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        String status = response.jsonPath().getString("planName");

        Assert.assertEquals(status, "Tarun");
    }

}
