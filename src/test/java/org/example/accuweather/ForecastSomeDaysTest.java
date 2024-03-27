package org.example.accuweather;

import org.example.accuweather.weather.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ForecastSomeDaysTest extends AbstractTest{

    @ParameterizedTest
    @MethodSource("getLocationCode")
    void check1DayForecast(int locationCode) {
        Weather weather = given().queryParam("apikey", getApiKey())
                .when().get(getBaseURL() + getDailyForecastURL() + "1day/" + locationCode)
                .then().statusCode(200).time(lessThan(values.getResponseTime()))
                .extract().response().body().as(Weather.class);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(weather),
                () -> Assertions.assertNotNull(weather.getHeadline()),
                () -> Assertions.assertEquals(1, weather.getDailyForecasts().size())
        );
    }

    @ParameterizedTest
    @MethodSource("getLocationCode")
    void check5DayForecast(int locationCode) {
        Weather weather = given().queryParam("apikey", getApiKey())
                .when().get(getBaseURL() + getDailyForecastURL() + "5day/" + locationCode)
                .then().statusCode(200).time(lessThan(values.getResponseTime()))
                .extract().response().body().as(Weather.class);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(weather),
                () -> Assertions.assertNotNull(weather.getHeadline()),
                () -> Assertions.assertEquals(5, weather.getDailyForecasts().size())
        );
    }

    @ParameterizedTest
    @MethodSource("getLocationCode")
    void check10DayForecast(int locationCode) {
        Weather weather = given().queryParam("apikey", getApiKey())
                .when().get(getBaseURL() + getDailyForecastURL() + "10day/" + locationCode)
                .then().statusCode(200).time(lessThan(values.getResponseTime()))
                .extract().response().body().as(Weather.class);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(weather),
                () -> Assertions.assertNotNull(weather.getHeadline()),
                () -> Assertions.assertEquals(10, weather.getDailyForecasts().size())
        );
    }

    @ParameterizedTest
    @MethodSource("getLocationCode")
    void check15DayForecast(int locationCode) {
        Weather weather = given().queryParam("apikey", getApiKey())
                .when().get(getBaseURL() + getDailyForecastURL() + "15day/" + locationCode)
                .then().statusCode(200).time(lessThan(values.getResponseTime()))
                .extract().response().body().as(Weather.class);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(weather),
                () -> Assertions.assertNotNull(weather.getHeadline()),
                () -> Assertions.assertEquals(15, weather.getDailyForecasts().size())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 15})
    void checkSomeDayForecast(int day) {
        Weather weather = given().queryParam("apikey", getApiKey())
                .when().get(getBaseURL() + getDailyForecastURL() + day + "day/5")
                .then().statusCode(200).time(lessThan(values.getResponseTime()))
                .extract().response().body().as(Weather.class);

        Assertions.assertAll(
                () -> Assertions.assertNotNull(weather),
                () -> Assertions.assertNotNull(weather.getHeadline()),
                () -> Assertions.assertEquals(day, weather.getDailyForecasts().size())
        );
    }

}

