package ro.mta.se.lab.model;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/***
 * This class implements the logger that will write the data of the cities that
 * have been searched for and also will add new cities to out citi list
 * @author Alexandru Nisulescu
 */

public class Logger {

    private static final String filename="searches.log";
    private static final String cityfilename="city.txt";

    public Logger() {

    }

    public void writeLogs(Weather weather) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        FileWriter myWriter = new FileWriter(filename, true);
        String text="LOG "+  now.toString() + " " + weather.getCity().getName() + " " + weather.getCity().getCountryCode()+ "\n";
        myWriter.write(text);
        myWriter.close();
    }

    public void checkExistence(City city)
    {

    }

    public void addNewCity(City city)
    {

    }
}
