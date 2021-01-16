package ro.mta.se.lab.model;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/***
 *  This is the class that is used to get the json file with the weather
 *  for a specific city
 *
 * @author Alexandru Nisulescu
 */
public class WeatherGather {
    /***
     * ------------------------------------------------------------------------
     * From here start all of the variables
     */
    private String city;
    URL myUrl;
    InputStream in;
    ByteArrayOutputStream out;
    byte[] response;

    /***
     * ------------------------------------------------------------------------
     * From here start all of the methods
     */
    public WeatherGather(String city) {
        this.city = city;
    }

    /***
     * This is the method that is called to download the Json file with the
     * weather forecast
     *
     * @throws IOException
     */
    public void apiRequest() throws IOException {
        this.myUrl = new URL("http://api.openweathermap.org/data/2.5/weather?q="
                + city+ "&appid=6159a870c03b130d2571733f23ffcbb6&units=metric");
        HttpURLConnection con =(HttpURLConnection) myUrl.openConnection();
        con.setRequestMethod("HEAD");
        if (con.getResponseCode() == HttpURLConnection.HTTP_OK)
        {
            in = new BufferedInputStream(myUrl.openStream());
            out = new ByteArrayOutputStream();
        }
        else{
            System.out.println("The website is not available");
        }
        byte[] buffer = new byte[2048];
        int n = 0;
        while (-1 != (n = in.read(buffer))) {
            out.write(buffer, 0, n);
        }
        out.close();
        in.close();
        response = out.toByteArray();
        writeToFile("weather.json");
    }

    /***
     * This is the method that writes the weather forecast to the file
     *
     * @param Filename is the name of the file where the json will be stored
     * @throws FileNotFoundException
     */
    public void writeToFile(String Filename) throws FileNotFoundException {
        try {
            FileOutputStream fos = new FileOutputStream(Filename);
            fos.write(response);
            fos.close();
        }
        catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
            throw new FileNotFoundException("The file you are trying to open " +
                    "doesn't exist...");
        }
    }
}
