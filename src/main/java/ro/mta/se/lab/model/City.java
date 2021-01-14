package ro.mta.se.lab.model;

public class City {
    private String name;
    private float lat;
    private float lon;
    private String countryCode;
    private int id;

    public City() {
    }

    public City(String name, float lat, float lon, String countryCode) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.countryCode = countryCode;
    }

    public void showDetails()
    {
        System.out.println(name);
        System.out.println(lat);
        System.out.println(lon);
        System.out.println(countryCode);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getId() {
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
