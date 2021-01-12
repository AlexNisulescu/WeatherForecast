package ro.mta.se.lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ro.mta.se.lab.model.City;
import ro.mta.se.lab.model.WeatherGather;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WeatherViewController {

    ObservableList<String> cityList= FXCollections.observableArrayList();
    ObservableList<String> countryList= FXCollections.observableArrayList();

    public WeatherViewController(ObservableList<String> countryList) {
        this.countryList = countryList;

    }

    @FXML
    private ChoiceBox cityBox;
    @FXML
    private ChoiceBox countryBox;
    @FXML
    private TextField textField;

    @FXML
    public void buttonPressed(KeyEvent e) throws IOException {
        if(e.getCode() == KeyCode.ENTER)
        {
            System.out.println("Fetching weather for "+ textField.getText());
            WeatherGather w=new WeatherGather(textField.getText());
            w.apiRequest();
        }
    }
    public void getCities(String countryCode) throws FileNotFoundException {
        File myObj = new File("cities.txt");
        Scanner myReader = new Scanner(myObj);
        String[] cityInfo =new String[5];
        String current;
        int j=0;
        cityList.clear();
        while (myReader.hasNext()){
            for (int i=0; i<5; i++)
            {
                String data = myReader.next();
                cityInfo[i]=data;
            }
            current=cityInfo[4];
            if (cityInfo[4].equals(countryCode)){
                //countryList.add(cityInfo[rows-1][j]);
                cityList.add(cityInfo[1]);
            }
        }
    }

    @FXML
    public void countrySelected(Event e) throws FileNotFoundException {
        //System.out.println("ai ales");
        String cty=countryBox.getValue().toString();
        System.out.println(cty);
        getCities(cty);
        cityBox.setItems(cityList);

    }@FXML
    public void citySelected(Event e) throws IOException {
        System.out.println("Fetching weather for "+ cityBox.getValue().toString());
        WeatherGather w=new WeatherGather(cityBox.getValue().toString());
        w.apiRequest();

    }

    @FXML
    private void initialize()
    {
        countryBox.setItems(countryList);
    }

}
