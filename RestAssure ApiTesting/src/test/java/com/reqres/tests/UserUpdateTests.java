package com.reqres.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserUpdateTests extends BaseTest {


    @Test
    public void updateUserUsingPUT() {

        String requestBody =
                """
                {
                    "name": "Dhruvi Updated",
                    "job": "Senior QA Engineer"
                }
                """;

        Response response =
                given()
                    .body(requestBody)
                .when()
                    .put("/api/users/2")
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(
                response.jsonPath().getString("name"),
                "Dhruvi Updated"
        );

        Assert.assertEquals(
                response.jsonPath().getString("job"),
                "Senior QA Engineer"
        );

        Assert.assertNotNull(
                response.jsonPath().getString("updatedAt")
        );
    }


    @Test
    public void updateAnotherUser() {

        String body =
                """
                {
                    "name": "Test User",
                    "job": "Automation Tester"
                }
                """;

        Response response =
                given()
                    .body(body)
                .when()
                    .put("/api/users/5")
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        Assert.assertEquals(
                response.jsonPath().getString("name"),
                "Test User"
        );

        Assert.assertEquals(
                response.jsonPath().getString("job"),
                "Automation Tester"
        );
    }
}