package com.weather.forecast.app.controller;

import com.weather.forecast.app.entity.UserRequest;
import com.weather.forecast.app.entity.TokenResponse;
import com.weather.forecast.app.service.JwtUserDetailService;
import com.weather.forecast.app.service.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private JwtUserDetailService jwtUserDetailService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenManager tokenManager;

    @PostMapping("/signup")
    public String createUser(@RequestBody UserRequest userRequest) {
        try {
            jwtUserDetailService.createUser(userRequest);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Username already exists");
        }
        return "Hurray..!!  You have singed up successfully.";
    }

    @PostMapping("/authenticate")
    public TokenResponse getSecurityToken(@RequestBody UserRequest userRequest) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));

        return TokenResponse.builder()
                .token(tokenManager.generateJwtToken(userRequest.getUsername())).build();
    }
}
