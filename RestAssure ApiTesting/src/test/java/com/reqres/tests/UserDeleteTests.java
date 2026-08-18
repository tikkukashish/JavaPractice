package com.reqres.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserDeleteTests extends BaseTest {


    @Test
    public void deleteUser() {

        Response response =
                given()
                .when()
                    .delete("/api/users/2")
                .then()
                    .statusCode(204)
                    .extract()
                    .response();

        Assert.assertEquals(response.statusCode(), 204);

        Assert.assertTrue(
                response.asString().isEmpty()
        );
    }


    @Test
    public void deleteAnotherUser() {

        Response response =
                given()
                .when()
                    .delete("/api/users/5")
                .then()
                    .statusCode(204)
                    .extract()
                    .response();

        Assert.assertEquals(response.statusCode(), 204);
    }
}