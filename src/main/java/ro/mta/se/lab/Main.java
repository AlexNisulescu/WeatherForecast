package ro.mta.se.lab;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.mta.se.lab.controller.WeatherViewController;

import java.io.*;
import java.util.Scanner;


/***
 * This is the main class of the application
 * @author Alex Nisulescu
 */
public class Main extends Application {
    private int rows=5;
    private int cols;
    private ObservableList<String> countryList= FXCollections.observableArrayList();

    /***
     * main function
     * @param args are the parameters send as input, but this app doesn't
     *              require any user input
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        launch(args);
    }

    /***
     * This function checks if the country code is already in the list
     * @param cty is the current country code
     * @param list is the country codes list
     * @param j is the current position
     * @return true/false
     */
    public boolean checkExistence(String cty, String list[], int j){

        for (int i=0; i<j; i++)
        {
            if (list[i].equals(cty))
            {
                return false;
            }
        }
        return true;
    }

    /***
     *
     * @param filename is the name of the initialization file
     * @throws FileNotFoundException
     */
    public void initInfo(String filename) throws FileNotFoundException {
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        String[] cityInfo =new String[cols];
        String[] buffer;
        String current;
        int j=0;
        while (myReader.hasNextLine()){
            String data = myReader.nextLine();
            buffer=data.split("\t");
            cityInfo[j]=buffer[4];
            if (checkExistence(buffer[4], cityInfo, j)){
                countryList.add(cityInfo[j]);
            }
            j++;
        }
    }

    /***
     * Sets the variable cols with the number of lines from the file
     * @throws IOException
     */
    public void getCols() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("cities.txt"));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        cols=lines;
    }

    /***
     * Is the method that starts the visual app
     * @param stage is the top level JavaFX container
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        getCols();
        initInfo("cities.txt");
        FXMLLoader loader=new FXMLLoader();
        try {
            loader.setLocation(this.getClass().getResource("/view/WeatherView.fxml"));
            loader.setController(new WeatherViewController(countryList));
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Weather Forecast App");
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

