package org.example.accuweather;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.apache.http.HttpResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Stream;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;

public class AbstractTest {

    static Values values = new Values();
    static Properties properties = new Properties();

    private static InputStream configFile;

    private static String apiKey;

    private static String baseURL;

    private static String dailyForecastURL;

    private static String hourlyForecastURL;

    private static WireMockServer wireMockServer = new WireMockServer();

    private static final int port = 8080;

    private static String baseMockURL;

    private static final Logger logger = LoggerFactory.getLogger(AbstractTest.class);

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

    @BeforeAll
    static void startMockServer() {
        baseMockURL = "http://localhost:" + port;
        wireMockServer.start();
        configureFor("localhost", port);
        logger.info("Start WireMockServer on port: " + port);
    }

    @AfterAll
    static void stopMockServer() {
        wireMockServer.stop();
        logger.info("Stop WireMockServer");
    }

    public String convertResponseToString(HttpResponse httpResponse) throws IOException {
        logger.debug("convertResponseToString method call");
        try (InputStream responseStream = httpResponse.getEntity().getContent();
             Scanner scanner = new Scanner(responseStream, "UTF-8")) {
            String responseString = scanner.useDelimiter("\\Z").next();
            return responseString;

        }
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

    public static String getBaseMockURL() {
        return baseMockURL;
    }

    static Stream<String> getLocationCode() {
        return Stream.of(values.getLocationCode());
    }
//
//    static Stream<String> getDays() {
//        return Stream.of(values.getDays());
//    }


}
