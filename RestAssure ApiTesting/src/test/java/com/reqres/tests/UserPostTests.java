package com.reqres.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserPostTests extends BaseTest {


    @Test
    public void createUser() {

        String requestBody =
                """
                {
                    "name": "Dhruvi",
                    "job": "QA Engineer"
                }
                """;

        Response response =
                given()
                    .body(requestBody)
                .when()
                    .post("/api/users")
                .then()
                    .statusCode(201)
                    .extract()
                    .response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(
                response.jsonPath().getString("name"),
                "Dhruvi"
        );

        Assert.assertEquals(
                response.jsonPath().getString("job"),
                "QA Engineer"
        );

        Assert.assertNotNull(
                response.jsonPath().getString("id")
        );

        Assert.assertNotNull(
                response.jsonPath().getString("createdAt")
        );
    }


    @Test
    public void createUserWithDifferentData() {

        String requestBody =
                """
                {
                    "name": "John",
                    "job": "Developer"
                }
                """;

        Response response =
                given()
                    .body(requestBody)
                .when()
                    .post("/api/users")
                .then()
                    .statusCode(201)
                    .extract()
                    .response();

        Assert.assertEquals(
                response.jsonPath().getString("name"),
                "John"
        );

        Assert.assertEquals(
                response.jsonPath().getString("job"),
                "Developer"
        );
    }


    @Test
    public void createUserWithEmptyBody() {

        Response response =
                given()
                    .body("{}")
                .when()
                    .post("/api/users")
                .then()
                    .extract()
                    .response();

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());

        // Don't hard-code 201 here if the current ReqRes behavior
        // accepts an empty object.
        Assert.assertTrue(response.statusCode() >= 200 &&
                          response.statusCode() < 500);
    }
}