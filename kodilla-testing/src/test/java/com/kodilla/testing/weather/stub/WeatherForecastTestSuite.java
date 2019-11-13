package com.kodilla.testing.weather.stub;

import org.junit.*;

public class WeatherForecastTestSuite {
    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Test WeatherForecast start ..");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("Test WeatherForecast end ..");
    }

    @Test
    public void testCalculateForecastWithStub() {
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assert.assertEquals(5, quantityOfSensors);
    }
}
