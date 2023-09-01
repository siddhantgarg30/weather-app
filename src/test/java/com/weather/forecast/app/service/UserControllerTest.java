package com.weather.forecast.app.service;

import com.weather.forecast.app.entity.TokenResponse;
import com.weather.forecast.app.entity.UserRequest;
import com.weather.forecast.app.repository.UserDetailRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @Autowired
    private TestRestTemplate template;
    @Autowired
    private UserDetailRepository userDetailRepository;
    private UserRequest userRequest;

    @BeforeEach
    void setUp() {
        userDetailRepository.deleteAll();
        userRequest = UserRequest.builder()
                .username("testUser")
                .password("testPassword")
                .build();
    }

    @Test
    public void generateJwtTokenForValidUsername() {
        template.postForEntity("/user/signup", userRequest, String.class);
        ResponseEntity<TokenResponse> response = template.postForEntity("/user/authenticate", userRequest, TokenResponse.class);
        assertThat(Objects.requireNonNull(response.getBody()).getToken()).isNotEqualTo(null);
    }

    @Test
    public void throwErrorForInvalidUsernameForJwtToken() {
        ResponseEntity<String> response = template.postForEntity("/user/authenticate", userRequest, String.class);
        assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }
}
