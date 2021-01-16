package ro.mta.se.lab.model;

/***
 *  This is the class that stores all the data about the weather
 *
 *  @author Alexandru Nisulescu
 */
public class Weather {
    /***
     * ------------------------------------------------------------------------
     * From here start all of the variables
     */
    private int precipitations;
    private float temperature;
    private float feels_like;
    private float wind;
    private String weather;
    private City city;

    /***
     * ------------------------------------------------------------------------
     * From here start all of the methods
     */
    public Weather() {
    }

    public Weather(City c){
        this.city=c;
    }

    public Weather(int precipitations, float temperature, float feels_like, String weather, City city) {
        this.precipitations = precipitations;
        this.temperature = temperature;
        this.feels_like = feels_like;
        this.weather = weather;
        this.city = city;
    }

    /***
     * ------------------------------------------------------------------------
     * All setters start from here
     */

    /***
     * Sets the weather's wind
     * @param wind is the wind to be set
     */
    public void setWind(float wind) {
        this.wind = wind;
    }
    /***
     * Sets the weather's precipitations
     * @param precipitations is the humidity to be set
     */
    public void setPrecipitations(int precipitations) {
        this.precipitations = precipitations;
    }

    /***
     * Sets the weather's temperature
     * @param temperature is the temperature to be set
     */
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    /***
     * Sets the weather's real temperature
     * @param feels_like is the temperature feeled by humans to be set
     */
    public void setFeels_like(float feels_like) {
        this.feels_like = feels_like;
    }

    /***
     * Sets the weather's description
     * @param weather is the description to be set
     */
    public void setWeather(String weather) {
        this.weather = weather;
    }

    /***
     * Sets the weather's city
     * @param city is the city to be set
     */
    public void setCity(City city) {
        this.city = city;
    }

    /***
     * ------------------------------------------------------------------------
     * All getters start from here
     */
    /***
     *
     * @return the wind speed
     */
    public float getWind() {
        return wind;
    }

    /***
     *
     * @return the humidity
     */
    public int getPrecipitations() {
        return precipitations;
    }

    /***
     *
     * @return the temperature
     */
    public float getTemperature() {
        return temperature;
    }

    /***
     *
     * @return the temperature felt by the people
     */
    public float getFeels_like() {
        return feels_like;
    }

    /***
     *
     * @return the weather description
     */
    public String getWeather() {
        return weather;
    }

    /***
     *
     * @return the city for the forecast
     */
    public City getCity() {
        return city;
    }

    /***
     * This method converts celsius to fahrenheit
     *
     * @param temp is the temperature you want converted to F
     * @return fahrenheit temperature
     */
    public float convertToFahrenheit(float temp){
        float k=(float) (this.temperature*9/5+32);
        return k;
    }

    /***
     * This method converts celsius to kelvin
     *
     * @param temp is the temperature you want converted to K
     * @return kelvin temperature
     */
    public float convertToKelvin(float temp){
        float fh= (float) (this.temperature+273.15);
        return fh;
    }
}
