package org.example.accuweather;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.example.accuweather.location.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

public class LocationTest extends AbstractTest{

    private static final Logger logger = LoggerFactory.getLogger(LocationTest.class);

    @Test
    @DisplayName("get_shouldReturnCode200 in LocationTest")
    @Description("Проверка возврата кода ответа 200 на стабе")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Тестирование запросов по Location")
    void get_shouldReturnCode200() throws IOException, URISyntaxException {
        logger.info("Starting test for responseCode200");

        //given
        ObjectMapper objectMapper = new ObjectMapper();
        Location locationOk = new Location();
        locationOk.setKey("OK");

        Location locationError = new Location();
        locationError.setKey("Error");

        logger.info("Building Mock for GET-request /locations/v1/cities/autocomplete");
        stubFor(get(urlPathEqualTo("/locations/v1/cities/autocomplete"))
                .withQueryParam("q", equalTo("Samara"))
                .willReturn(aResponse().withStatus(200).withBody(objectMapper.writeValueAsString(locationOk))));

        stubFor(get(urlPathEqualTo("/locations/v1/cities/autocomplete"))
                .withQueryParam("q", equalTo("error"))
                .willReturn(aResponse().withStatus(200).withBody(objectMapper.writeValueAsString(locationError))));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        logger.info("HTTP-client building is complete");

        //when
        HttpGet request = new HttpGet(getBaseMockURL() + "/locations/v1/cities/autocomplete");
        URI uriOk = new URIBuilder(request.getURI())
                .addParameter("q", "Samara").build();

        request.setURI(uriOk);
        HttpResponse responseOk = httpClient.execute(request);

        URI uriError = new URIBuilder(request.getURI())
                .addParameter("q", "error").build();

        request.setURI(uriError);
        HttpResponse responseError = httpClient.execute(request);

        //then
        verify(2, getRequestedFor(urlPathEqualTo("/locations/v1/cities/autocomplete")));
        Assertions.assertEquals(200, responseOk.getStatusLine().getStatusCode());
        Assertions.assertEquals("OK", objectMapper.readValue(
                responseOk.getEntity().getContent(), Location.class).getKey());
        Assertions.assertEquals(200, responseError.getStatusLine().getStatusCode());
        Assertions.assertEquals("Error", objectMapper.readValue(
                responseError.getEntity().getContent(), Location.class).getKey());
    }

    @Test
    @DisplayName("get_shouldReturnCode401 in LocationTest")
    @Description("Проверка возврата кода ответа 401 на стабе")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Тестирование запросов по Location")
    void get_shouldReturnCode401() throws URISyntaxException, IOException {
        logger.info("Starting test for responseCode 401");

        //given
        logger.debug("Building Mock for GET-request /locations/v1/cities/autocomplete");
        stubFor(get(urlPathEqualTo("/locations/v1/cities/autocomplete"))
                .withQueryParam("apiKey", notMatching("D3aGMHZCJhAQqcV4ACYaGCzakyaqYqvw"))
                .willReturn(aResponse().withStatus(401).withBody("ERROR")));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(getBaseMockURL() + "/locations/v1/cities/autocomplete");
        URI uri = new URIBuilder(request.getURI())
                .addParameter("apiKey", "D3aGMHZCJhAQqcV4ACYaGCzakyaqYqvw875")
                .build();
        request.setURI(uri);
        logger.info("HTTP-client building is complete");

        //when
        HttpResponse response = httpClient.execute(request);

        //then
        verify(getRequestedFor(urlPathEqualTo("/locations/v1/cities/autocomplete")));
        Assertions.assertEquals(401, response.getStatusLine().getStatusCode());
        Assertions.assertEquals("ERROR", convertResponseToString(response));
    }
}
