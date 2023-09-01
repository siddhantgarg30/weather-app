package com.weather.forecast.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ForecastResponse {
    Location location;
    Forecast forecast;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Location {
        String code;
        String name;
        String timezone;
        Coordinates coordinates;

    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Coordinates{
        String latitude;
        String longitude;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Forecast {
        List<Item> items;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Item {
        String date;
        String dateWithTimezone;
        String period;
        String freshSnow;
        String snowHeight;
        Weather weather;
        Prec prec;
        String sunHours;
        String rainHours;
        String pressure;
        String relativeHumidity;
        Temperature temperature;
        Wind wind;
        Windchill windchill;
        SnowLine snowLine;
        Astronomy astronomy;
        Boolean isNight;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Weather {
        String state;
        String text;
        String icon;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Temperature {
        String min;
        String max;
        String avg;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Prec {
        String sum;
        String sumAsRain;
        String probability;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Wind {
        String unit;
        String direction;
        String text;
        String min;
        String max;
        Gust gusts;
        String significationWind;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Gust {
        String value;
        String text;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Windchill {
        String min;
        String max;
        String avg;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class SnowLine {
        String avg;
        String min;
        String max;
        String unit;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Cloud{
        String high;
        String low;
        String middle;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Astronomy {
        String dawn;
        String sunrise;
        String sunTransit;
        String sunset;
        String dusk;
        String moonrise;
        String moonTransit;
        @JsonProperty("moonset")
        String moonSet;
        @JsonProperty("moonphase")
        String moonPhase;
        @JsonProperty("moonzodiac")
        String moonZodiac;
    }
}
