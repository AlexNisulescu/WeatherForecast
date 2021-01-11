package ro.mta.se.lab.model;

public class City {
    private String id;
    private String name;
    private float lat;
    private float lon;
    private String countryCode;

    public City(String id, String name, float lat, float lon, String countryCode) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.countryCode = countryCode;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
