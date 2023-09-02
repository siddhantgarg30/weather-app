# weather-app Readme

This is a Java-based Weather App that provides weather forecast information. It includes user authentication using JWT tokens and offers two main endpoints for weather forecasts - one for daily summaries and another for hourly summaries.

## Requirements

- Java 1.8
- Maven
- Any supporting IDE

## Setup

1. Clone the repository to your local machine.

```bash
git clone https://github.com/siddhantgarg30/weather-forecast-app.git
```

2. Install project dependencies using Maven.

```bash
mvn clean install
```

3. Start the server.

```bash
mvn spring-boot:run
```

The server will run on port 8089.

## User Authentication

To access the weather forecast endpoints, you need to create a user and obtain a JWT token.

### Create User

Use the `/user/signup` endpoint to create a user. Send a POST request with the following request body:

```json
{
    "username": "your_username",
    "password": "your_password"
}
```

### Generate JWT Token

To generate a JWT token, use the `/user/authenticate` endpoint. Send a POST request with the following request body:

```json
{
    "username": "your_username",
    "password": "your_password"
}
```

The generated token will be valid for 1 hour.

## Weather Forecast APIs

### 1. Forecast Summary

- Full Response:
  - Endpoint: `/weather/forecast/summary`
  - Request Parameters:
    - `locationName`

- Paginated Response:
  - Endpoint: `/weather/forecast/summary`
  - Request Parameters:
    - `locationName`
    - `pageNo`
    - `pageSize`

### 2. Forecast Hourly Summary

- Endpoint: `/weather/forecast/hourly`
- Request Parameters:
  - `locationName`

- Paginated Response:
  - Endpoint: `/weather/forecast/hourly`
  - Request Parameters:
    - `locationName`
    - `pageNo`
    - `pageSize`

## Example Usage

Here's an example of how to access the weather forecast summary:

```bash
# Full Response
curl -X GET "http://localhost:8089/weather/forecast/summary?locationName=your_location" -H "Authorization: Bearer your_jwt_token"

# Paginated Response
curl -X GET "http://localhost:8089/weather/forecast/summary?locationName=your_location&pageNo=1&pageSize=10" -H "Authorization: Bearer your_jwt_token"
```

Similarly, you can access the hourly summary with the appropriate endpoint and parameters.

Enjoy using the Weather App!
