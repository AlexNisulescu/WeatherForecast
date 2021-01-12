package ro.mta.se.lab.model;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherGather {
    private String city;
    URL myUrl;
    InputStream in;
    ByteArrayOutputStream out;
    byte[] response;

    public WeatherGather(String city) {
        this.city = city;
    }

    public void apiRequest() throws IOException {
        this.myUrl = new URL("http://api.openweathermap.org/data/2.5/weather?q="+ city+ "&appid=6159a870c03b130d2571733f23ffcbb6");
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
