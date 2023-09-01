package com.weather.forecast.app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class TokenManager {
    public static final long TOKEN_VALIDITY = 60 * 60;
    @Value("${secrets.jwt.key}")
    private String jwtSecret;

    public String generateJwtToken(String username) {
        log.info("Inside [TokenManager#generateJwtToken], param: {}", username);
        Map<String, Object> claims = new HashMap<>();
        String token = Jwts.builder().setClaims(claims).setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
        log.info("[TokenManager#generateJwtToken], generated token for username: {}, token:{}", username, token);
        return token;
    }

    public Boolean validateJwtToken(String token, UserDetails userDetails) {
        log.info("Inside [TokenManager#validateJwtToken], token: {}, username: {}", token, userDetails.getUsername());
        String username = getUsernameFromToken(token);
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        boolean isTokenExpired = claims.getExpiration().before(new Date());
        boolean isValidToken = username.equals(userDetails.getUsername()) && !isTokenExpired;
        log.info("[TokenManager#validateJwtToken], isValidToken: {}", isValidToken);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired);
    }

    public String getUsernameFromToken(String token) {
        final Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
