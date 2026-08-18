package com.reqres.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected String API_KEY = "YOUR_API_KEY";

    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://reqres.in";

        RestAssured.requestSpecification =
                RestAssured.given()
                        .header("x-api-key", API_KEY)
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json");
    }
}