package ro.mta.se.lab.model;

public class Weather {
    private String precipitations[];
    private int wind[];
    private float temperature[];
    private City city;

    public Weather(String[] precipitations, int[] wind, float[] temperature, City City) {
        this.precipitations = precipitations;
        this.wind = wind;
        this.temperature = temperature;
        this.city=City;
    }

}
