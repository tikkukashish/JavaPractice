package com.reqres.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserGetTests extends BaseTest {

    @Test(priority = 1)
    public void getUsers() {

        Response response =
                given()
                .when()
                    .get("/api/users?page=2")
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertTrue(
                response.jsonPath().getList("data").size() > 0
        );
    }


    @Test(priority = 2)
    public void getSingleUser() {

        Response response =
                given()
                .when()
                    .get("/api/users/2")
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(
                response.jsonPath().getInt("data.id"),
                2
        );

        Assert.assertNotNull(
                response.jsonPath().getString("data.email")
        );

        Assert.assertNotNull(
                response.jsonPath().getString("data.first_name")
        );

        Assert.assertNotNull(
                response.jsonPath().getString("data.last_name")
        );
    }


    @Test(priority = 3)
    public void getUserNotFound() {

        Response response =
                given()
                .when()
                    .get("/api/users/9999")
                .then()
                    .statusCode(404)
                    .extract()
                    .response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 404);
    }


    @Test(priority = 4)
    public void verifyPagination() {

        Response response =
                given()
                    .queryParam("page", 2)
                .when()
                    .get("/api/users")
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        int page = response.jsonPath().getInt("page");
        int totalPages = response.jsonPath().getInt("total_pages");

        Assert.assertEquals(page, 2);
        Assert.assertTrue(totalPages >= 1);
    }


    @Test(priority = 5)
    public void verifyUserListFields() {

        Response response =
                given()
                .when()
                    .get("/api/users?page=2")
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        Assert.assertNotNull(response.jsonPath().get("data"));

        Assert.assertNotNull(
                response.jsonPath().get("data[0].id")
        );

        Assert.assertNotNull(
                response.jsonPath().get("data[0].email")
        );

        Assert.assertNotNull(
                response.jsonPath().get("data[0].first_name")
        );

        Assert.assertNotNull(
                response.jsonPath().get("data[0].last_name")
        );

        Assert.assertNotNull(
                response.jsonPath().get("data[0].avatar")
        );
    }
}