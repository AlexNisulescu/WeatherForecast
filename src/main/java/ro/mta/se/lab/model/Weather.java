package ro.mta.se.lab.model;

public class Weather {
    private int precipitations;
    private float temperature;
    private float feels_like;
    private float wind;
    private String weather;
    private City city;

    public Weather() {
    }

    public Weather(int precipitations, float temperature, float feels_like, String weather, City city) {
        this.precipitations = precipitations;
        this.temperature = temperature;
        this.feels_like = feels_like;
        this.weather = weather;
        this.city = city;
    }

    public void setWind(float wind) {
        this.wind = wind;
    }

    public void setPrecipitations(int precipitations) {
        this.precipitations = precipitations;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setFeels_like(float feels_like) {
        this.feels_like = feels_like;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public float getWind() {
        return wind;
    }

    public int getPrecipitations() {
        return precipitations;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getFeels_like() {
        return feels_like;
    }

    public String getWeather() {
        return weather;
    }

    public City getCity() {
        return city;
    }
}
