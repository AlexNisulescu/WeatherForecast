package ro.mta.se.lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import ro.mta.se.lab.model.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WeatherViewController {

    ObservableList<String> cityList= FXCollections.observableArrayList();
    ObservableList<String> countryList;

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
    private ImageView weatherImg;
    @FXML
    private Label cityName;
    @FXML
    private Label weather;
    @FXML
    private Label temp;
    @FXML
    private Label feels;
    @FXML
    private Label precipit;
    @FXML
    private Label wind;


    @FXML
    public void buttonPressed(KeyEvent e) throws IOException {
        if(e.getCode() == KeyCode.ENTER)
        {
            System.out.println("Fetching weather for "+ textField.getText());
            WeatherGather w=new WeatherGather(textField.getText());
            w.apiRequest();
            JsonParser p=new JsonParser();
            p.readWeatherJSON();
            String code = p.getWeatherIconCode();
            loadImage(code);
            City current= new City();
            Weather cw=new Weather();
            current= cw.getCity();
            cw=p.getWeather();
            String s="";
            cityName.setText(current.getName());
            s=cw.getWeather();
            weather.setText(s);
            s="Temperature: "+cw.getTemperature()+"°C";
            temp.setText(s);
            s="Feels like: "+cw.getFeels_like()+"°C";
            feels.setText(s);
            s="Humidity: "+cw.getPrecipitations();
            precipit.setText(s);
            Logger l=new Logger();
            l.writeLogs(cw);
            l.addNewCity(cw.getCity());
        }
    }


    public void getCities(String countryCode) throws FileNotFoundException {
        File myObj = new File("cities.txt");
        Scanner myReader = new Scanner(myObj);
        String[] cityInfo =new String[5];
        int j=0;
        cityList.clear();
        while (myReader.hasNext()){
            for (int i=0; i<5; i++)
            {
                String data = myReader.next();
                cityInfo[i]=data;
            }
            if (cityInfo[4].equals(countryCode)){
                cityList.add(cityInfo[1]);
            }
        }
    }


    @FXML
    public void countrySelected(Event e) throws FileNotFoundException {
        cityBox.getItems().clear();
        cityList.clear();
        String cty=countryBox.getValue().toString();
        getCities(cty);
        cityBox.setItems(cityList);

    }


    @FXML
    public void citySelected(Event e) throws IOException {
        //System.out.println("Fetching weather for "+ cityBox.getValue().toString());
        if (cityBox.getValue() != null){
            WeatherGather w=new WeatherGather(cityBox.getValue().toString());
            w.apiRequest();
            JsonParser p=new JsonParser();
            p.readWeatherJSON();
            String code = p.getWeatherIconCode();
            loadImage(code);
            City current= new City();
            Weather cw=new Weather();
            current= cw.getCity();
            cw=p.getWeather();
            String s="";
            cityName.setText(current.getName());
            s=cw.getWeather();
            weather.setText(s);
            s="Temperature: "+cw.getTemperature()+"°C";
            temp.setText(s);
            s="Feels like: "+cw.getFeels_like()+"°C";
            feels.setText(s);
            s="Humidity: "+cw.getPrecipitations();
            precipit.setText(s);
            s="Wind: "+ cw.getWind() + "m/s";
            wind.setText(s);
            Logger l=new Logger();
            l.writeLogs(cw);
        }
    }


    @FXML
    private void initialize() throws FileNotFoundException {
        countryBox.setItems(countryList);
    }


    @FXML
    private void loadImage(String code) throws FileNotFoundException {
        String url1="http://openweathermap.org/img/w/"+code+".png";
        Image img = new Image(url1, true);
        weatherImg.setImage(img);
    }

}
