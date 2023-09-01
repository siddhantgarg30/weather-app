package com.weather.forecast.app.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.forecast.app.entity.ForecastResponse;
import com.weather.forecast.app.entity.TokenResponse;
import com.weather.forecast.app.entity.UserRequest;
import com.weather.forecast.app.repository.UserDetailRepository;
import com.weather.forecast.app.service.util.ForecastUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


import java.util.Objects;

import static com.weather.forecast.app.ResponsePayloadHelper.FORECAST_HOURLY_RESPONSE;
import static com.weather.forecast.app.ResponsePayloadHelper.FORECAST_SUMMARY_RESPONSE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ForecastControllerTest {
    @Autowired
    @MockBean
    private RestTemplate restTemplate;
    @Autowired
    private TestRestTemplate template;
    @Autowired
    private ForecastUtility forecastUtility;
    @Autowired
    private UserDetailRepository userDetailRepository;
    private ObjectMapper objectMapper;

    private UserRequest userRequest;

    @BeforeEach
    public void setUp() {
        userDetailRepository.deleteAll();
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        userRequest = UserRequest.builder()
                .username("testUsername")
                .password("testPassword")
                .build();
    }

    @Test
    public void successForGetForecastSummaryTest() throws JsonProcessingException {
        String locationName = "Berlin";
        template.postForEntity("/user/signup", userRequest, String.class);
        ResponseEntity<TokenResponse> tokenResponse = template
                .postForEntity("/user/authenticate", userRequest, TokenResponse.class);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer ".concat(Objects.requireNonNull(tokenResponse.getBody()).getToken()));
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        ForecastResponse forecastResponse = objectMapper.readValue(FORECAST_SUMMARY_RESPONSE, ForecastResponse.class);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(ForecastResponse.class)))
                .thenReturn(new ResponseEntity<>(forecastResponse, HttpStatus.OK));
        ResponseEntity<ForecastResponse> response = template
                .exchange("/weather/forecast/summary?locationName=".concat(locationName),
                        HttpMethod.GET, httpEntity, ForecastResponse.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void successForGetForecastSummaryWithPaginationTest() throws JsonProcessingException {
        String locationName = "Berlin";
        template.postForEntity("/user/signup", userRequest, String.class);
        ResponseEntity<TokenResponse> tokenResponse = template
                .postForEntity("/user/authenticate", userRequest, TokenResponse.class);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer ".concat(Objects.requireNonNull(tokenResponse.getBody()).getToken()));
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        ForecastResponse forecastResponse = objectMapper.readValue(FORECAST_SUMMARY_RESPONSE, ForecastResponse.class);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(ForecastResponse.class)))
                .thenReturn(new ResponseEntity<>(forecastResponse, HttpStatus.OK));
        ResponseEntity<ForecastResponse> response = template
                .exchange("/weather/forecast/summary?locationName=".concat(locationName).concat("&pageNo=1&pageSize=2"),
                        HttpMethod.GET, httpEntity, ForecastResponse.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void unauthorizedStatusCodeForGetForecastSummaryTest() throws JsonProcessingException {
        ForecastResponse forecastResponse = objectMapper.readValue(FORECAST_SUMMARY_RESPONSE, ForecastResponse.class);
        when(restTemplate.exchange(any(), any(), any(), eq(ForecastResponse.class)))
                .thenReturn(new ResponseEntity<>(forecastResponse, HttpStatus.OK));
        String locationName = "Berlin";

        ResponseEntity<ForecastResponse> response = template
                .getForEntity("/weather/forecast/summary?{locationName}", ForecastResponse.class, locationName);
        assertEquals(response.getStatusCode(), HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void successForGetForecastHourlyTest() throws JsonProcessingException {
        String locationName = "Berlin";
        template.postForEntity("/user/signup", userRequest, String.class);
        ResponseEntity<TokenResponse> tokenResponse = template
                .postForEntity("/user/authenticate", userRequest, TokenResponse.class);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer ".concat(Objects.requireNonNull(tokenResponse.getBody()).getToken()));
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        ForecastResponse forecastResponse = objectMapper.readValue(FORECAST_HOURLY_RESPONSE, ForecastResponse.class);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(ForecastResponse.class)))
                .thenReturn(new ResponseEntity<>(forecastResponse, HttpStatus.OK));
        ResponseEntity<ForecastResponse> response = template
                .exchange("/weather/forecast/hourly?locationName=".concat(locationName),
                        HttpMethod.GET, httpEntity, ForecastResponse.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void successForGetForecastHourlyWithPaginationTest() throws JsonProcessingException {
        String locationName = "Berlin";
        template.postForEntity("/user/signup", userRequest, String.class);
        ResponseEntity<TokenResponse> tokenResponse = template
                .postForEntity("/user/authenticate", userRequest, TokenResponse.class);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer ".concat(Objects.requireNonNull(tokenResponse.getBody()).getToken()));
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        ForecastResponse forecastResponse = objectMapper.readValue(FORECAST_HOURLY_RESPONSE, ForecastResponse.class);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(ForecastResponse.class)))
                .thenReturn(new ResponseEntity<>(forecastResponse, HttpStatus.OK));
        ResponseEntity<ForecastResponse> response = template
                .exchange("/weather/forecast/hourly?locationName=".concat(locationName).concat("&pageNo=1&pageSize=2"),
                        HttpMethod.GET, httpEntity, ForecastResponse.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void unauthorizedStatusCodeForGetForecastHourlyTest() throws JsonProcessingException {
        ForecastResponse forecastResponse = objectMapper.readValue(FORECAST_HOURLY_RESPONSE, ForecastResponse.class);
        when(restTemplate.exchange(anyString(), any(), any(), eq(ForecastResponse.class)))
                .thenReturn(new ResponseEntity<>(forecastResponse, HttpStatus.OK));
        String locationName = "Berlin";

        ResponseEntity<ForecastResponse> response = template
                .getForEntity("/weather/forecast/hourly?{locationName}", ForecastResponse.class, locationName);
        assertEquals(response.getStatusCode(), HttpStatus.UNAUTHORIZED);
    }
}
