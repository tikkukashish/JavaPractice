package com.reqres.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PaginationTests extends BaseTest {

    @DataProvider(name = "pages")
    public Object[][] pages() {
        return new Object[][] {
                {1},
                {2}
        };
    }


    @Test(dataProvider = "pages")
    public void verifyPages(int pageNumber) {

        Response response =
                given()
                    .queryParam("page", pageNumber)
                .when()
                    .get("/api/users")
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        Assert.assertEquals(
                response.jsonPath().getInt("page"),
                pageNumber
        );

        Assert.assertTrue(
                response.jsonPath().getList("data").size() > 0
        );
    }


    @Test
    public void verifyTotalUsers() {

        Response response =
                given()
                .when()
                    .get("/api/users?page=2")
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        int total = response.jsonPath().getInt("total");

        Assert.assertTrue(total > 0);
    }


    @Test
    public void verifyPerPage() {

        Response response =
                given()
                .when()
                    .get("/api/users?page=2")
                .then()
                    .statusCode(200)
                    .extract()
                    .response();

        int perPage = response.jsonPath().getInt("per_page");

        Assert.assertTrue(perPage > 0);
    }
}