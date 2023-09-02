package com.weather.forecast.app.controller;

import com.weather.forecast.app.entity.ForecastResponse;
import com.weather.forecast.app.service.ForecastService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/weather")
@Slf4j
public class ForecastController {
    @Autowired
    private ForecastService forecastService;

    @GetMapping("/forecast/summary")
    public ForecastResponse getForecastSummary(@RequestParam String locationName,
                                               @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                               @RequestParam(value = "pageSize", defaultValue = "0") Integer pageSize) throws Exception {
        log.info("[ForecastController#getForecastSummary], locationName: {}, " +
                "pageNo: {}, pageSize: {}", locationName, pageNo, pageSize);
        try {
            return forecastService.getForecastSummary(locationName, pageNo, pageSize);
        } catch (HttpClientErrorException.NotFound e) {
            throw new Exception("Location name is incorrect");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/forecast/hourly")
    public ForecastResponse getForecastHourly(@RequestParam String locationName,
                                              @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                              @RequestParam(value = "pageSize", defaultValue = "0") Integer pageSize) throws Exception {
        log.info("[ForecastController#getForecastHourly], locationName: {}, " +
                "pageNo: {}, pageSize: {}", locationName, pageNo, pageSize);
        try {
            return forecastService.getForecastHourly(locationName, pageNo, pageSize);
        } catch (HttpClientErrorException.NotFound e) {
            throw new Exception("Location name is incorrect");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
