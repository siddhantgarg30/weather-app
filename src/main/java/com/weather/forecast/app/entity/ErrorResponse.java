package com.weather.forecast.app.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String errorMessage;
}
