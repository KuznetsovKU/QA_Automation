package org.example.accuweather;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AuthorizationTest extends AbstractTest{

    @Test
    void checkCorrectToken() {
        given().queryParam("apikey", getApiKey())
                .when().get(getBaseURL() + getDailyForecastURL() + "5day/5")
                .then().statusCode(200);
    }

    @Test
    void checkNotCorrectToken() {
        given().queryParam("apikey", getApiKey() + "d")
                .when().get(getBaseURL() + getDailyForecastURL() + "5day/5")
                .then().statusCode(401);
    }
}
