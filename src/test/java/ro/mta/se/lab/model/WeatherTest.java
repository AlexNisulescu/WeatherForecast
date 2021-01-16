package ro.mta.se.lab.model;

import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class WeatherTest {

    private Weather weather=new Weather();
    @Test
    void getWind() {
        weather.setWind((float)12.3);
        assertEquals((float)12.3, weather.getWind());
    }

    @Test
    void getPrecipitations() {
        weather.setPrecipitations(123);
        assertEquals(123, weather.getPrecipitations());
    }

    @Test
    void getTemperature() {
        weather.setTemperature((float)12.3);
        assertEquals((float)12.3, weather.getTemperature());

    }

    @Test
    void getFeels_like() {
        weather.setFeels_like((float)12.3);
        assertEquals((float)12.3, weather.getFeels_like());
    }

    @Test
    void getWeather() {
        weather.setWeather("test");
        assertEquals("test", weather.getWeather());
    }

    @Test
    void getCity() {
        City city=new City();
        city.setName("bucuresti");
        weather.setCity(city);

        assertEquals("bucuresti", weather.getCity().getName());
    }

    @Test
    void convertToKelvin() {
        weather.setTemperature((float)12.3);
        assertEquals((float)285.45, weather.convertToKelvin(weather.getTemperature()));
    }

    @Test
    void convertToFahrenheit() {
        weather.setTemperature((float)12.3);
        assertEquals((float)54.14, weather.convertToFahrenheit(weather.getTemperature()));
    }
}