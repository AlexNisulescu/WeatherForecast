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


/***
 * This is the controller class of the application. Everything that changes in
 * the visual app takes place first here
 * @author Alex Nisulescu
 */
public class WeatherViewController {

    /***
     * ------------------------------------------------------------------------
     * From here start all of the variables
     */
    /***
     * Both ObservableList's are here
     */
    ObservableList<String> cityList= FXCollections.observableArrayList();
    ObservableList<String> countryList= FXCollections.observableArrayList();

    /***
     * All FXML's are here
     */
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

    /***
     * ------------------------------------------------------------------------
     * From here start all of the methods
     */
    /***
     * This is the constructor of the controller which is initiated in the main
     * class with the list of the countries from the file
     * @param countryList is the ObservableList used to initiate the first
     *                    choicebox
     */
    public WeatherViewController(ObservableList<String> countryList) {
        this.countryList = countryList;
    }

    /***
     *  Is the event that gets triggered when user searches a city.
     *  This is the function that makes the api request if the user uses the
     *  search box from the interface
     *
     * @param e Is the event that triggers the action
     *          The method only does something if you press ENTER
     * @throws IOException
     */
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
            current=p.getCity();
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

    /***
     *  Is the method that sets the list of cities to the city choicebox
     *
     * @param countryCode Is the country code of the selected country
     * @throws FileNotFoundException
     */
    public void getCities(String countryCode) throws FileNotFoundException {
        try {
            File myObj = new File("cities.txt");
            Scanner myReader = new Scanner(myObj);
            String[] buffer;
            while (myReader.hasNextLine())
            {
                String data=myReader.nextLine();
                buffer=data.split("\t");
                if (buffer[4].equals(countryCode)){
                    cityList.add(buffer[1]);
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            e=new FileNotFoundException("The file you are trying to open doesn't exist");
            throw e;
        }
    }

    /***
     *  Is the event that gets triggered when the user selects a country.
     *  This calls getCities() method
     *
     * @param e is the event that triggeres this action
     * @throws FileNotFoundException
     */
    @FXML
    public void countrySelected(Event e) throws FileNotFoundException {
        cityBox.getItems().clear();
        cityList.clear();
        String cty=countryBox.getValue().toString();
        getCities(cty);
        cityBox.setItems(cityList);

    }

    /***
     *Is the event that gets triggered when the use selects a city
     *  This is the function that makes the api request if the user selects the
     *  city from the choicebox from the interface
     * @param e is the event that triggeres this action
     * @throws IOException
     */
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
            current=p.getCity();
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

    /***
     *  This is the event that initializes the interface with the country list
     *
     * @throws FileNotFoundException
     */
    @FXML
    private void initialize() throws FileNotFoundException {
        countryBox.setItems(countryList);
    }

    /***
     *  This is the event that downloads the image from the API and loads it
     *  in the interface
     *
     * @param code is the weather icon code
     * @throws FileNotFoundException
     */
    @FXML
    private void loadImage(String code) throws FileNotFoundException {
        String url1="http://openweathermap.org/img/w/"+code+".png";
        Image img = new Image(url1, true);
        weatherImg.setImage(img);
    }

}