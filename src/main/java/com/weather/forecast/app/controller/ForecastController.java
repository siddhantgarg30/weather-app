package com.weather.forecast.app.controller;

import com.weather.forecast.app.entity.ForecastResponse;
import com.weather.forecast.app.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class ForecastController {
    @Autowired
    private ForecastService forecastService;

    @GetMapping("/forecast/summary")
    public ForecastResponse getForecastSummary(@RequestParam String locationName,
                                               @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                               @RequestParam(value = "pageSize", defaultValue = "0") Integer pageSize) throws Exception {
        try {
            return forecastService.getForecastSummary(locationName, pageNo, pageSize);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/forecast/hourly")
    public ForecastResponse getForecastHourly(@RequestParam String locationName,
                                              @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                              @RequestParam(value = "pageSize", defaultValue = "0") Integer pageSize) throws Exception {
        try {
            return forecastService.getForecastHourly(locationName, pageNo, pageSize);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
