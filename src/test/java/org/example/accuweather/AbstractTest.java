package org.example.accuweather;

import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.stream.Stream;

public class AbstractTest {

    static Values values = new Values();
    static Properties properties = new Properties();

    private static InputStream configFile;

    private static String apiKey;

    private static String baseURL;

    private static String dailyForecastURL;

    private static String hourlyForecastURL;

    @BeforeAll
    static void initConfig() {
        try {
            configFile = new FileInputStream("src/test/resourсes/accuweather.properties");
        } catch (Exception e) {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
        try {
            properties.load(configFile);
        } catch (Exception e) {
            throw new NullPointerException();
        }
        apiKey = properties.getProperty("apikey");
        baseURL = properties.getProperty("base_url");
        dailyForecastURL = properties.getProperty("daily_forecast");
        hourlyForecastURL = properties.getProperty("hourly_forecast");
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseURL() {
        return baseURL;
    }

    public static String getDailyForecastURL() {
        return dailyForecastURL;
    }

    public static String getHourlyForecastURL() {
        return hourlyForecastURL;
    }

    static Stream<String> getLocationCode() {
        return Stream.of(values.getLocationCode());
    }
//
//    static Stream<String> getDays() {
//        return Stream.of(values.getDays());
//    }


}
