package org.example.accuweather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.example.accuweather.location.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class CountryTest extends AbstractTest {

    private static Logger logger = LoggerFactory.getLogger(CountryTest.class);

    @Test
    void get_shouldReturnCode200() throws IOException, URISyntaxException {
        logger.debug("Starting test for responseCode200");

        ObjectMapper objectMapper = new ObjectMapper();
        Country countryOK = new Country();
        countryOK.setLocalizedName("RU");

//        Country countryError = new Country();
//        countryError.setLocalizedName("ERROR");

        logger.info("Building Mock for GET-request /locations/v1/adminareas/");
        stubFor(get(urlPathEqualTo("/locations/v1/adminareas/")).willReturn(aResponse()
                .withStatus(200).withBody(objectMapper.writeValueAsString(countryOK))));

//        stubFor(get(urlPathEqualTo("/locations/v1/adminareas/")).willReturn(aResponse()
//                .withStatus(200).withBody(objectMapper.writeValueAsString(countryError))));

        CloseableHttpClient httpClient = HttpClients.createDefault();
        logger.info("HTTP-client building is complete");

        //when
        HttpGet request = new HttpGet(getBaseMockURL() + "/locations/v1/adminareas/");
        URI uriOK = new URIBuilder(request.getURI())
                .build();

        request.setURI(uriOK);
        HttpResponse responseOK = httpClient.execute(request);

//        URI uriError = new URIBuilder(request.getURI())
//                .build();
//
//        request.setURI(uriError);
//        HttpResponse responseError = httpClient.execute(request);

        //then
        verify(1, getRequestedFor(urlPathEqualTo("/locations/v1/adminareas/")));
        Assertions.assertEquals(200, responseOK.getStatusLine().getStatusCode());
        Assertions.assertEquals("RU", objectMapper.readValue(responseOK.getEntity().getContent(), Country.class).getLocalizedName());
//        Assertions.assertEquals(200, responseError.getStatusLine().getStatusCode());
//        Assertions.assertEquals("ERROR", objectMapper.readValue(responseError.getEntity().getContent(), Country.class).getLocalizedName());

    }
}
