package com.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GETTesting {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqbin.com";
    }

    @Test
    public void getRequestTest() {

        Response response =
                given()
                    .log().all()

                .when()
                    .get("/echo/get/json");

        // Print Response Details
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Response Body : " + response.getBody().asString());
        System.out.println("Status Line : " + response.getStatusLine());
        System.out.println("Content Type : " + response.getContentType());
        System.out.println("Response Time : " + response.getTime());
        System.out.println("Response Size : " + response.getBody().asString().length());

        // Validation
        response.then()
                .log().all()
                .statusCode(200)
                .contentType("application/json")
                .time(lessThan(5000L));
    }
}