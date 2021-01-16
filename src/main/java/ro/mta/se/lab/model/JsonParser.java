package ro.mta.se.lab.model;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/***
 *  This is the class that is used to parse the json file that is returned
 *  from the Openweathermap API
 *
 * @author Alexandru Nisulescu
 */

public class JsonParser {
    /***
     * ------------------------------------------------------------------------
     * From here start all of the variables
     */
    private City city=new City();
    private Weather weather=new Weather();
    String weatherIconCode;

    /***
     * ------------------------------------------------------------------------
     * From here start all of the methods
     */
    public JsonParser() {
    }

    /***
     * This is the method that needs to be called to read the Json file and
     * load all the data that is used by the application
     *
     * @throws IOException
     */
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

    /***
     * ------------------------------------------------------------------------
     * All getters start from here
     *
     */
    /***
     * This is the method that need to be called in order to get the
     * icon code for that specific weather
     *
     * @return the weatherIconCode
     */
    public String getWeatherIconCode()
    {
        return weatherIconCode;
    }

    /***
     * This is the method that need to be called in order to get the
     * city for which the weather is
     *
     * @return City
     */
    public City getCity() {
        return city;
    }

    /***
     * This is the method that need to be called in order to get the
     * weather for which the selected city
     *
     * @return Weather
     */
    public Weather getWeather() {
        return weather;
    }

}
