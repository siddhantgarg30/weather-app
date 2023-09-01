package com.weather.forecast.app.service;

import com.weather.forecast.app.entity.ForecastResponse;
import com.weather.forecast.app.service.util.ForecastUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class ForecastService {
    @Autowired
    private ForecastUtility forecastUtility;
    private final static int defaultPageSize = 10;

    public ForecastResponse getForecastSummary(String locationName, int pageNo, int pageSize) {
        ForecastResponse forecastResponse = forecastUtility.getForecastSummary(locationName);
        return getPaginatedResponse(forecastResponse, pageNo, pageSize);
    }

    public ForecastResponse getForecastHourly(String locationName, int pageNo, int pageSize) {
        ForecastResponse forecastResponse = forecastUtility.getForecastHourly(locationName);
        return getPaginatedResponse(forecastResponse, pageNo, pageSize);
    }

    private ForecastResponse getPaginatedResponse(ForecastResponse forecastResponse, int pageNo, int pageSize) {
        if (pageNo <= 0) return forecastResponse;
        if (pageSize <= 0) pageSize = defaultPageSize;
        int startOffset = (pageNo - 1) * pageSize;
        int endOffSet = startOffset + pageSize;
        if (startOffset > forecastResponse.getForecast().getItems().size()) return null;
        if (endOffSet >= forecastResponse.getForecast().getItems().size())
            endOffSet = forecastResponse.getForecast().getItems().size();
        forecastResponse.getForecast().getItems().sort(Comparator.comparing(ForecastResponse.Item::getDate));
        forecastResponse.getForecast().setItems(
                forecastResponse.getForecast().getItems().subList(startOffset, endOffSet));
        return forecastResponse;
    }
}
