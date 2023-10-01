package co.edu.uniquindio.poo.torneodeportivo.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("torneo-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 920, 450);
        stage.setTitle("Diplomado de Programación!!!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}    
