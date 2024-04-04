package org.example.accuweather;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static io.restassured.RestAssured.given;


public class AuthorizationTest extends AbstractTest{

    private static Logger logger = LoggerFactory.getLogger(AuthorizationTest.class);

    @Test
    void checkCorrectToken() {
        logger.debug("checkCorrectToken method call");
        given().queryParam("apikey", getApiKey())
                .when().get(getBaseURL() + getDailyForecastURL() + "5day/5")
                .then().statusCode(200);
    }

    @Test
    void checkNotCorrectToken() {
        logger.debug("checkNotCorrectToken method call");
        given().queryParam("apikey", getApiKey() + "d")
                .when().get(getBaseURL() + getDailyForecastURL() + "5day/5")
                .then().statusCode(401);
    }

    @Test
    void checkTokenMocked() throws URISyntaxException, IOException {
        logger.debug("checkCorrectTokenMocked method start");

        //given
        logger.debug("Building Mock for GET-request /forecasts/v1/daily/5day/5");
        stubFor(get(urlPathEqualTo(getDailyForecastURL() + "5day/5"))
                .withQueryParam("apikey", equalTo(getApiKey()))
                .willReturn(aResponse().withStatus(200)));

        stubFor(get(urlPathEqualTo(getDailyForecastURL() + "5day/5"))
                .withQueryParam("apikey", notMatching(getApiKey()))
                .willReturn(aResponse().withStatus(403)));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        logger.info("HTTP-client building is complete");

        //when
        HttpGet request = new HttpGet(getBaseMockURL() + getDailyForecastURL() + "5day/5");
        URI uriOK = new URIBuilder(request.getURI())
                .addParameter("apikey", getApiKey())
                .build();

        request.setURI(uriOK);
        HttpResponse responseOK = httpClient.execute(request);

        URI uriError = new URIBuilder(request.getURI())
                .addParameter("apikey", getApiKey() + "ddd")
                .build();

        request.setURI(uriError);
        HttpResponse responseError = httpClient.execute(request);

        //then
        verify(2, getRequestedFor(urlPathEqualTo("/forecasts/v1/daily/5day/5")));
        Assertions.assertEquals(200, responseOK.getStatusLine().getStatusCode());
        Assertions.assertEquals(403, responseError.getStatusLine().getStatusCode());

    }
}
