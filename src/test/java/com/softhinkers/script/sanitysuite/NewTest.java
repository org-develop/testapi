package com.softhinkers.script.sanitysuite;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewTest {

    @BeforeMethod
    public void setUp() throws IOException {

    }

    @Test(priority = 1, description = "Test to check status")
    public void testTocheckStatus() throws IOException {
        RestAssured.baseURI = "https://api.coindesk.com/v1/bpi";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/currentprice.json");
        Assert.assertEquals(response.getStatusCode() , 200 , "Correct status code returned");

    }

    @Test(priority = 1, description = "Test to Fetch First Name")
    public void testToFetchFirstName() throws IOException {
        RestAssured.baseURI = "https://api.coindesk.com/v1/bpi";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/currentprice.json");
        JsonPath jsonPathEvaluator = response.jsonPath();
        String city = jsonPathEvaluator.get("chartName");
        Assert.assertEquals(city, "Bitcoins", "Correct city name received in the Response");
    }
}
