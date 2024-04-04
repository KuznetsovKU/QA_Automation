package org.example.accuweather;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.example.accuweather.weather.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("check1DayForecast")
    @Description("Проверка предоставления прогноза на 1 день")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Тестирование предоставления прогнозов по дням")
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
    @DisplayName("check5DayForecast")
    @Description("Проверка предоставления прогноза на 5 дней")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Тестирование предоставления прогнозов по дням")
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
    @DisplayName("check10DayForecast")
    @Description("Проверка предоставления прогноза на 10 дней")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Тестирование предоставления прогнозов по дням")
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
    @DisplayName("check15DayForecast")
    @Description("Проверка предоставления прогноза на 15 дней")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Тестирование предоставления прогнозов по дням")
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
    @DisplayName("checkSomeDayForecast")
    @Description("Проверка предоставления прогноза на разное количество дней")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Тестирование предоставления прогнозов по дням")
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

}

