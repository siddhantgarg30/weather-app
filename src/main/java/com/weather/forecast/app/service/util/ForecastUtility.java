package com.weather.forecast.app.service.util;

import com.weather.forecast.app.entity.ForecastResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ForecastUtility {
    private final static String BASE_URL = "https://forecast9.p.rapidapi.com/rapidapi/forecast/";
    private final static String RAPID_KEY = "56ae348d4emsh3de6c40fbdbd549p100544jsn7cf6ddc97b92";
    private final static String RAPID_HOST = "forecast9.p.rapidapi.com";
    @Autowired
    private RestTemplate restTemplate;

    public ForecastResponse getForecastSummary(String locationName) {
        String URL = BASE_URL.concat(locationName).concat("/summary/");
        HttpEntity<String> entity = new HttpEntity<>(getHttpHeaders());
        log.info("[ForecastUtility#getForecastSummary], Calling forecast summary api, URL: {}", URL);
        ForecastResponse response
                = restTemplate.exchange(URL, HttpMethod.GET, entity, ForecastResponse.class).getBody();
        log.info("[ForecastUtility#getForecastSummary], forecast summary response: {}", response);
        return response;
    }

    public ForecastResponse getForecastHourly(String locationName) {
        String URL = BASE_URL.concat(locationName).concat("/hourly/");
        HttpEntity<String> entity = new HttpEntity<>(getHttpHeaders());
        log.info("[ForecastUtility#getForecastHourly], Calling forecast summary api, URL: {}", URL);
        ForecastResponse response
                = restTemplate.exchange(URL, HttpMethod.GET, entity, ForecastResponse.class).getBody();
        log.info("[ForecastUtility#getForecastHourly], forecast hourly response: {}", response);
        return response;
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-RapidAPI-Key", RAPID_KEY);
        httpHeaders.add("X-RapidAPI-Host", RAPID_HOST);
        return httpHeaders;
    }
}
