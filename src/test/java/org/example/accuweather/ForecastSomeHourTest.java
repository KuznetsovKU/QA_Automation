package org.example.accuweather;

import org.example.accuweather.weather.HourlyForecast;
import org.example.accuweather.weather.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ForecastSomeHourTest extends AbstractTest{

    @ParameterizedTest
    @MethodSource("getLocationCode")
    void check1HourForecast(int locationCode) {
        List<HourlyForecast> weather = Arrays.asList(given().queryParam("apikey", getApiKey())
                .when().get(getBaseURL() + getHourlyForecastURL() + "1hour/" + locationCode)
                .then().statusCode(200).time(lessThan(values.getResponseTime()))
                .extract().response().body().as(HourlyForecast[].class));

        Assertions.assertAll(
                () -> Assertions.assertNotNull(weather),
                () -> Assertions.assertEquals(1, weather.size())
        );
    }


    @ParameterizedTest
    @MethodSource("getLocationCode")
    void check12HourForecast(int locationCode) {
        List<HourlyForecast> weather = Arrays.asList(given().queryParam("apikey", getApiKey())
                .when().get(getBaseURL() + getHourlyForecastURL() + "12hour/" + locationCode)
                .then().statusCode(200).time(lessThan(values.getResponseTime()))
                .extract().response().body().as(HourlyForecast[].class));

        Assertions.assertAll(
                () -> Assertions.assertNotNull(weather),
                () -> Assertions.assertEquals(12, weather.size())
        );
    }

    @ParameterizedTest
    @MethodSource("getLocationCode")
    void check24HourForecast(int locationCode) {
        List<HourlyForecast> weather = Arrays.asList(given().queryParam("apikey", getApiKey())
                .when().get(getBaseURL() + getHourlyForecastURL() + "24hour/" + locationCode)
                .then().statusCode(200).time(lessThan(values.getResponseTime()))
                .extract().response().body().as(HourlyForecast[].class));

        Assertions.assertAll(
                () -> Assertions.assertNotNull(weather),
                () -> Assertions.assertEquals(24, weather.size())
        );
    }

    @ParameterizedTest
    @MethodSource("getLocationCode")
    void check72HourForecast(int locationCode) {
        List<HourlyForecast> weather = Arrays.asList(given().queryParam("apikey", getApiKey())
                .when().get(getBaseURL() + getHourlyForecastURL() + "72hour/" + locationCode)
                .then().statusCode(200).time(lessThan(values.getResponseTime()))
                .extract().response().body().as(HourlyForecast[].class));

        Assertions.assertAll(
                () -> Assertions.assertNotNull(weather),
                () -> Assertions.assertEquals(72, weather.size())
        );
    }

    @ParameterizedTest
    @MethodSource("getLocationCode")
    void check120HourForecast(int locationCode) {
        List<HourlyForecast> weather = Arrays.asList(given().queryParam("apikey", getApiKey())
                .when().get(getBaseURL() + getHourlyForecastURL() + "120hour/" + locationCode)
                .then().statusCode(200).time(lessThan(values.getResponseTime()))
                .extract().response().body().as(HourlyForecast[].class));

        Assertions.assertAll(
                () -> Assertions.assertNotNull(weather),
                () -> Assertions.assertEquals(120, weather.size())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 12, 24, 72, 120})
    void checkSomeHourForecast(int hour) {
        List<HourlyForecast> weather = Arrays.asList(given().queryParam("apikey", getApiKey())
                .when().get(getBaseURL() + getHourlyForecastURL() + hour + "hour/5")
                .then().statusCode(200).time(lessThan(values.getResponseTime()))
                .extract().response().body().as(HourlyForecast[].class));

        Assertions.assertAll(
                () -> Assertions.assertNotNull(weather),
                () -> Assertions.assertEquals(hour, weather.size())
        );
    }
}
