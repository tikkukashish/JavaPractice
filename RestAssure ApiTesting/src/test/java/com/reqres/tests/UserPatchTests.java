package com.reqres.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserPatchTests extends BaseTest {


    @Test
    public void patchUserName() {

        String body =
                """
                {
                    "name": "Updated Name"
                }
                """;

        Response response =
                given()
                    .body(body)
                .when()
                    .patch("/api/users/2")
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(
                response.jsonPath().getString("name"),
                "Updated Name"
        );

        Assert.assertNotNull(
                response.jsonPath().getString("updatedAt")
        );
    }


    @Test
    public void patchUserJob() {

        String body =
                """
                {
                    "job": "Automation Engineer"
                }
                """;

        Response response =
                given()
                    .body(body)
                .when()
                    .patch("/api/users/2")
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        Assert.assertEquals(
                response.jsonPath().getString("job"),
                "Automation Engineer"
        );
    }
}