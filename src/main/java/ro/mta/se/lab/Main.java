package ro.mta.se.lab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args){

        System.out.println("hello world");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader=new FXMLLoader();
        try {
            loader.setLocation(this.getClass().getResource("/view/WeatherView.fxml"));
            stage.setScene(new Scene(loader.load()));
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

