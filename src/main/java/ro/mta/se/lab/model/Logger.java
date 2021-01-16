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

    /***
     * ------------------------------------------------------------------------
     * From here start all of the variables
     */
    /***
     * The names of the files where the logger will write
     */
    private static final String filename="searches.log";
    private static final String cityfilename="cities.txt";

    /***
     * The variables used to initiate the the size of the array where we are
     * going to store the table with the cities details
     */
    private int cols;
    private int rows=5;

    /***
     * ------------------------------------------------------------------------
     * From here start all of the methods
     */
    public Logger() {

    }


    /***
     * This is the method which needs to be called in order to write the log
     * after the user requests the weather for a city
     *
     * @param weather is the weather variable of the city selected
     * @throws IOException
     */
    public void writeLogs(Weather weather) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        FileWriter myWriter = new FileWriter(filename, true);
        String text="LOG "+  now.toString() + " " + weather.getCity().getName() + " " + weather.getCity().getCountryCode()+ "\n";
        myWriter.write(text);
        myWriter.close();
    }

    /***
     * Is the method that sets the number of columns in the cities table
     * This method is only called when the program tries to add a new city
     *
     * @param Filename is the file where is the cities table
     * @throws IOException
     */
    public void getCols(String Filename) throws IOException {
        try{
        BufferedReader reader = new BufferedReader(new FileReader(Filename));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        cols=lines;
        }
        catch (IOException e){
            e.printStackTrace();
            e=new FileNotFoundException("The file you are trying to open doesn't exist");
            throw e;
        }
    }

    /***
     * This is the method that checks if the city is already in the list
     * in order to avoid duplicates
     * This method is only called when the program tries to add a new city
     *
     * @param city is the city to be added
     * @param file s the file where is the cities table
     * @return false is the city exists and true if it doesn't
     * @throws FileNotFoundException
     */
    public boolean checkExistence(City city, String file) throws FileNotFoundException {
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            String[] buffer;
            while (myReader.hasNextLine())
            {
                String data=myReader.nextLine();
                buffer=data.split("\t");
                if (city.getName().equals(buffer[4]))
                {
                    return false;
                }
            }
            return true;
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            e=new FileNotFoundException("The file you are trying to open doesn't exist");
            throw e;
        }
    }

    /***
     * Is the method that is called whenever the user searches for a new city
     *
     * @param city Is  the city that was searched
     * @throws IOException
     */
    public void addNewCity(City city) throws IOException {
        getCols(cityfilename);
        if (checkExistence(city, cityfilename))
        {
            FileWriter myWriter = new FileWriter(cityfilename, true);
            String text ="\n" + city.getId() + "\t" + city.getName() + "\t" + city.getLat() + "\t" + city.getLon() + "\t" + city.getCountryCode();
            myWriter.write(text);
            myWriter.close();
        }
    }

}
