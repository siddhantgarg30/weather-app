package com.weather.forecast.app;

public class ResponsePayloadHelper {
    public final static String FORECAST_SUMMARY_RESPONSE =
            "{\n" +
                    "  \"location\": {\n" +
                    "    \"code\": \"DE0004130\",\n" +
                    "    \"timezone\": \"Europe/Berlin\",\n" +
                    "    \"name\": \"Hamburg\",\n" +
                    "    \"coordinates\": {\n" +
                    "      \"latitude\": 0,\n" +
                    "      \"longitude\": 0\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"forecast\": {\n" +
                    "    \"items\": [\n" +
                    "      {\n" +
                    "        \"date\": \"2019-01-25\",\n" +
                    "        \"dateWithTimezone\": \"2020-11-02T14:59:00Z\",\n" +
                    "        \"freshSnow\": 1.1,\n" +
                    "        \"snowHeight\": 1.1,\n" +
                    "        \"weather\": {\n" +
                    "          \"state\": 0,\n" +
                    "          \"text\": \"\",\n" +
                    "          \"icon\": \"\"\n" +
                    "        },\n" +
                    "        \"prec\": {\n" +
                    "          \"sum\": 0,\n" +
                    "          \"sumAsRain\": 0,\n" +
                    "          \"probability\": 0,\n" +
                    "          \"class\": 0\n" +
                    "        },\n" +
                    "        \"sunHours\": 5.17,\n" +
                    "        \"rainHours\": 1.2,\n" +
                    "        \"temperature\": {\n" +
                    "          \"min\": 0,\n" +
                    "          \"max\": 0,\n" +
                    "          \"avg\": 0\n" +
                    "        },\n" +
                    "        \"wind\": {\n" +
                    "          \"unit\": \"km/h\",\n" +
                    "          \"direction\": \"SW\",\n" +
                    "          \"avg\": 5,\n" +
                    "          \"min\": 1,\n" +
                    "          \"max\": 8,\n" +
                    "          \"text\": \"Südwestwind\",\n" +
                    "          \"significationWind\": true,\n" +
                    "          \"gusts\": {\n" +
                    "            \"value\": 100,\n" +
                    "            \"text\": \"Sturm mit Orkanböen\"\n" +
                    "          }\n" +
                    "        },\n" +
                    "        \"windchill\": {\n" +
                    "          \"avg\": 0,\n" +
                    "          \"min\": 0,\n" +
                    "          \"max\": 0\n" +
                    "        },\n" +
                    "        \"snowLine\": {\n" +
                    "          \"avg\": 0,\n" +
                    "          \"min\": 0,\n" +
                    "          \"max\": 0,\n" +
                    "          \"unit\": \"\"\n" +
                    "        },\n" +
                    "        \"astronomy\": {\n" +
                    "          \"dawn\": \"\",\n" +
                    "          \"sunrise\": \"\",\n" +
                    "          \"suntransit\": \"\",\n" +
                    "          \"sunset\": \"\",\n" +
                    "          \"dusk\": \"\",\n" +
                    "          \"moonrise\": \"\",\n" +
                    "          \"moontransit\": \"\",\n" +
                    "          \"moonset\": \"\",\n" +
                    "          \"moonphase\": 0,\n" +
                    "          \"moonzodiac\": 0\n" +
                    "        }\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"forecastDate\": \"2019-02-07T10:00:00\",\n" +
                    "    \"nextUpdate\": \"2019-02-07T10:00:00\",\n" +
                    "    \"source\": \"w3Data\",\n" +
                    "    \"point\": \"global\"\n" +
                    "  }\n" +
                    "}";

    public final static String FORECAST_HOURLY_RESPONSE =
            "{\n" +
                    "  \"location\": {\n" +
                    "    \"code\": \"DE0004130\",\n" +
                    "    \"timezone\": \"Europe/Berlin\",\n" +
                    "    \"name\": \"Hamburg\",\n" +
                    "    \"coordinates\": {\n" +
                    "      \"latitude\": 0,\n" +
                    "      \"longitude\": 0\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"forecast\": {\n" +
                    "    \"items\": [\n" +
                    "      {\n" +
                    "        \"date\": \"2019-02-25T03:00:00Z\",\n" +
                    "        \"period\": 1,\n" +
                    "        \"freshSnow\": 1.1,\n" +
                    "        \"weather\": {\n" +
                    "          \"state\": 0,\n" +
                    "          \"text\": \"\",\n" +
                    "          \"icon\": \"\"\n" +
                    "        },\n" +
                    "        \"sunHours\": 1.2,\n" +
                    "        \"rainHours\": 1.2,\n" +
                    "        \"prec\": {\n" +
                    "          \"sum\": 0,\n" +
                    "          \"sumAsRain\": 0,\n" +
                    "          \"probability\": 0,\n" +
                    "          \"class\": 0\n" +
                    "        },\n" +
                    "        \"temperature\": {\n" +
                    "          \"avg\": 0,\n" +
                    "          \"min\": 0,\n" +
                    "          \"max\": 0\n" +
                    "        },\n" +
                    "        \"pressure\": 1001.7,\n" +
                    "        \"relativeHumidity\": 92,\n" +
                    "        \"clouds\": {\n" +
                    "          \"high\": 0,\n" +
                    "          \"low\": 0,\n" +
                    "          \"middle\": 0\n" +
                    "        },\n" +
                    "        \"wind\": {\n" +
                    "          \"unit\": \"km/h\",\n" +
                    "          \"direction\": \"SW\",\n" +
                    "          \"avg\": 5,\n" +
                    "          \"min\": 1,\n" +
                    "          \"max\": 8,\n" +
                    "          \"text\": \"Südwestwind\",\n" +
                    "          \"significationWind\": true,\n" +
                    "          \"gusts\": {\n" +
                    "            \"value\": 100,\n" +
                    "            \"text\": \"Sturm mit Orkanböen\"\n" +
                    "          }\n" +
                    "        },\n" +
                    "        \"windchill\": {\n" +
                    "          \"avg\": 0,\n" +
                    "          \"min\": 0,\n" +
                    "          \"max\": 0\n" +
                    "        },\n" +
                    "        \"snowLine\": {\n" +
                    "          \"avg\": 0,\n" +
                    "          \"min\": 0,\n" +
                    "          \"max\": 0,\n" +
                    "          \"unit\": \"\"\n" +
                    "        },\n" +
                    "        \"isNight\": true\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"forecastDate\": \"2019-02-07T10:00:00\",\n" +
                    "    \"nextUpdate\": \"2019-02-07T10:00:00\",\n" +
                    "    \"source\": \"w3Data\",\n" +
                    "    \"point\": \"global\"\n" +
                    "  }\n" +
                    "}";
}
