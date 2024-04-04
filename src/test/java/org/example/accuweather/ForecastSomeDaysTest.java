package org.example.accuweather;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.accuweather.weather.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ForecastSomeDaysTest extends AbstractTest{

    private static Logger logger = LoggerFactory.getLogger(ForecastSomeDaysTest.class);

    @ParameterizedTest
    @MethodSource("getLocationCode")
    void check1DayForecast(int locationCode) {
        logger.debug("parametrized check1DayForecast method call");
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
        logger.debug("parametrized check5DayForecast method call");
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
        logger.debug("parametrized check10DayForecast method call");
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
        logger.debug("parametrized check15DayForecast method call");
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
        logger.debug("parametrized checkSomeDayForecast method call");
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

//    @Test
//    void checkSomeDayForecastMocked() {
//        logger.debug("parametrized checkSomeDayForecastMocked method call");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//
//
//        logger.debug("Building Mock for GET-request /forecasts/v1/daily/1day/5");
//        stubFor(get(urlPathEqualTo(getDailyForecastURL() + "1day/5"))
//                .withQueryParam())
//    }

}

