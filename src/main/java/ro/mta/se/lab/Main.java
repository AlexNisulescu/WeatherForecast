package ro.mta.se.lab;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ro.mta.se.lab.controller.WeatherViewController;
import ro.mta.se.lab.model.City;
import ro.mta.se.lab.model.WeatherGather;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {
    private int rows=5;
    private int cols=7;
    private ObservableList<String> countryList= FXCollections.observableArrayList();

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    public boolean checkExistence(String cty, String list[][], int j){

        for (int i=0; i<j; i++)
        {
            if (list[4][i].equals(cty))
            {
                return false;
            }
        }
        return true;
    }

    public void initInfo(String filename) throws FileNotFoundException {
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        String[][] cityInfo =new String[rows][cols];
        String current;
        int j=0;
        while (myReader.hasNext()){
            for (int i=0; i<rows; i++)
            {
                String data = myReader.next();
                cityInfo[i][j]=data;
            }
            current=cityInfo[rows-1][j];
            if (checkExistence(current, cityInfo, j)){
                countryList.add(cityInfo[rows-1][j]);
            }
            j++;
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
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

