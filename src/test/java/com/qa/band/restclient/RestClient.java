package com.qa.band.restclient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;;

/**
 * 
 * @author tarun.tiwari
 *
 */
public class RestClient {

    public static Response doGet(String ContentType, String baseURI,
            String basPath, Map<String, String> paramsMap, String pathParam,
            boolean log) {

        setBaseURI(baseURI);
        RequestSpecification request = createRequest(ContentType, paramsMap,
                pathParam, log);
        Response response = getResponse("GET", request, basPath);

        return response;

    }

    public static Response doPost(String ContentType, String baseURI,
            String basPath, Map<String, String> paramsMap, String pathParms,
            boolean log) throws IOException {
        setBaseURI(baseURI);
        RequestSpecification request = createRequest(ContentType, paramsMap,
                pathParms, log);
        String jsonBody = new String(Files.readAllBytes(Paths.get(System
                .getProperty("user.dir")
                + "/src/test/java/com/qa/band/testData/createPlan.txt")));
        request.body(jsonBody);
        Response response = getResponse("POST", request, basPath);
        return response;

    }

    public static void setBaseURI(String baseURI)

    {
        RestAssured.baseURI = baseURI;
    }

    public static RequestSpecification createRequest(String contentType,
            Map<String, String> paramsMap, String petID, boolean log) {
        RequestSpecification request;

        if (log)
            request = RestAssured.given().log().all();
        else
            request = RestAssured.given();
        if (paramsMap != null)
            request.queryParams(paramsMap);
        if (petID != null)
            request.pathParam("petId", petID);
        if (contentType.equalsIgnoreCase("JSON"))
            request.contentType(ContentType.JSON);
        else if (contentType.equalsIgnoreCase("XML"))
            request.contentType(ContentType.XML);
        else if (contentType.equalsIgnoreCase("TEXT"))
            request.contentType(ContentType.TEXT);
        return request;
    }

    public static Response getResponse(String httpMethod,
            RequestSpecification request, String basePath) {
        return executeAPI(httpMethod, request, basePath);
    }

    public static Response executeAPI(String httpMethod,
            RequestSpecification request, String basePath) {
        Response response = null;
        if (httpMethod.equals("GET"))
            response = request.get(basePath);
        else if (httpMethod.equals("POST"))
            response = request.post(basePath);
        else if (httpMethod.equals("PUT"))
            response = request.put(basePath);
        else if (httpMethod.equals("DELETE"))
            response = request.delete(basePath);

        return response;
    }

}
