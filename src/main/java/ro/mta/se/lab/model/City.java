package ro.mta.se.lab.model;

/***
 *  This is the class that stores all the data about the weather
 *
 *  @author Alexandru Nisulescu
 */
public class City {
    /***
     * ------------------------------------------------------------------------
     * From here start all of the variables
     */
    private String name;
    private float lat;
    private float lon;
    private String countryCode;
    private int id;

    /***
     * ------------------------------------------------------------------------
     * From here start all of the methods
     */
    public City() {
    }

    public City(String name, float lat, float lon, String countryCode) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.countryCode = countryCode;
    }

    /***
     * This is the method that prints all details of the city
     * It was primary used for debugging purposes
     */
    public void showDetails()
    {
        System.out.println(name);
        System.out.println(lat);
        System.out.println(lon);
        System.out.println(countryCode);
    }

    /***
     * ------------------------------------------------------------------------
     * All setters start from here
     *
     */

    /***
     * Sets the city's ID
     * @param id is the ID to be set
     */
    public void setId(int id) {
        this.id = id;
    }
    /***
     * Sets the city's name
     * @param name is the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * Sets the city's Latitude
     * @param lat is the Latitude to be set
     */
    public void setLat(float lat) {
        this.lat = lat;
    }

    /***
     * Sets the city's Longitude
     * @param lon is the Longitude to be set
     */
    public void setLon(float lon) {
        this.lon = lon;
    }

    /***
     * Sets the city's Country Code
     * @param countryCode is the Country Code to be set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /***
     * ------------------------------------------------------------------------
     * All getters start from here
     *
     */

    /***
     *
     * @return City ID
     */
    public int getId() {
        return id;
    }

    /***
     *
     * @return City name
     */
    public String getName() {
        return name;
    }

    /***
     *
     * @return City Latitude
     */
    public float getLat() {
        return lat;
    }

    /***
     *
     * @return City Longitude
     */
    public float getLon() {
        return lon;
    }

    /***
     *
     * @return City Country code
     */
    public String getCountryCode() {
        return countryCode;
    }
}
