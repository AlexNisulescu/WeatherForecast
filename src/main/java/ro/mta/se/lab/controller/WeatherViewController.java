package ro.mta.se.lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ro.mta.se.lab.model.City;
import ro.mta.se.lab.model.WeatherGather;

import java.io.IOException;

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

    @FXML
    private void initialize()
    {
        countryBox.setItems(countryList);
        //cityBox.setItems(cityList);
    }

}
