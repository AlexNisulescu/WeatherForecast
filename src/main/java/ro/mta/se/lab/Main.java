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

public class Main extends Application {
    private int rows=5;
    private int cols;
    private ObservableList<String> countryList= FXCollections.observableArrayList();

    public static void main(String[] args) throws IOException {
        launch(args);
    }

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

    public void getCols() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("cities.txt"));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        cols=lines;
    }

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

