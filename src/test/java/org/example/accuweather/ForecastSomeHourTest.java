package org.example.accuweather;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.example.accuweather.weather.HourlyForecast;
import org.example.accuweather.weather.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("check1HourForecast")
    @Description("Проверка предоставления прогноза на 1 час")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Тестирование предоставления прогнозов по часам")
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
    @DisplayName("check12HourForecast")
    @Description("Проверка предоставления прогноза на 12 часов")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Тестирование предоставления прогнозов по часам")
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
    @DisplayName("check24HourForecast")
    @Description("Проверка предоставления прогноза на 24 часа")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Тестирование предоставления прогнозов по часам")
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
    @DisplayName("check72HourForecast")
    @Description("Проверка предоставления прогноза на 72 часа")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Тестирование предоставления прогнозов по часам")
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
    @DisplayName("check120HourForecast")
    @Description("Проверка предоставления прогноза на 120 часов")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Тестирование предоставления прогнозов по часам")
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
    @DisplayName("checkSomeHourForecast")
    @Description("Проверка предоставления прогноза на разное количество часов")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Тестирование предоставления прогнозов по часам")
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
