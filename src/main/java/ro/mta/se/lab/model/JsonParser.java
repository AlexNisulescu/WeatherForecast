package ro.mta.se.lab.model;


import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonParser {
    private City city=new City();
    private Weather weather=new Weather();
    String weatherIconCode;

    public JsonParser() {
    }

    public void readWeatherJSON() throws IOException {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get("F:\\Ingineria Programarii\\Tema 2 - Weather Forecast App\\weather.json")));

        JsonObject obj = Json.parse(data).asObject();

        city.setName(obj.get("name").asString());
        city.setLon(obj.get("coord").asObject().get("lon").asFloat());
        city.setLat(obj.get("coord").asObject().get("lat").asFloat());
        city.setCountryCode(obj.get("sys").asObject().get("country").asString());
        city.setId(obj.get("id").asInt());

        JsonArray items = Json.parse(data).asObject().get("weather").asArray();
        weatherIconCode="";
        weatherIconCode = items.get(0).asObject().getString("icon", "Unknown Item");

        weather.setCity(city);
        weather.setTemperature(obj.get("main").asObject().get("temp").asFloat());
        weather.setFeels_like(obj.get("main").asObject().get("feels_like").asFloat());
        weather.setPrecipitations(obj.get("main").asObject().get("humidity").asInt());
        weather.setWeather(items.get(0).asObject().getString("description", "Unknown Item"));
        weather.setWind(obj.get("wind").asObject().get("speed").asFloat());

    }

    public City getCity() {
        return city;
    }

    public String getWeatherIconCode()
    {
        return weatherIconCode;
    }

    public Weather getWeather() {
        return weather;
    }


}
