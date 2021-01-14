package ro.mta.se.lab.model;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;

/***
 * This class implements the logger that will write the data of the cities that
 * have been searched for and also will add new cities to out citi list
 * @author Alexandru Nisulescu
 */

public class Logger {

    private static final String filename="searches.log";
    private static final String cityfilename="cities.txt";
    private int cols;
    private int rows=5;

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

    public void getCols() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("cities.txt"));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        cols=lines;
    }

    public boolean checkExistence(City city) throws FileNotFoundException {
        File myObj = new File(cityfilename);
        Scanner myReader = new Scanner(myObj);
        String[][] cityInfo =new String[rows][cols];
        int j=0;
        while (myReader.hasNext()) {
            for (int i = 0; i < rows; i++) {
                if (i==2)
                {
                    String data=myReader.next();
                }
                else {
                    cityInfo[i][j] = myReader.next();
                }
            }
            if (city.getName().equals(cityInfo[4][j]))
            {
                return false;
            }
            j++;
        }
        return true;
    }

    public void addNewCity(City city) throws IOException {
        getCols();
        if (checkExistence(city))
        {
            FileWriter myWriter = new FileWriter(cityfilename, true);
            String text ="\n" + city.getId() + "\t" + city.getName() + "\t" + city.getLat() + "\t" + city.getLon() + "\t" + city.getCountryCode();
            myWriter.write(text);
            myWriter.close();
        }
    }
}
