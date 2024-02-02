package org.example.demo5;

//import entity.UserRepository;
import jakarta.persistence.Persistence;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class     MyApp extends Application {
    /**
     * Main class for starting the user registration window.
     */
    @Override
    public void start(Stage stage) throws IOException {
        /**
         * Starts the user registration window.
         *
         * @param stage The primary stage for the application.
         * @throws IOException If an I/O error occurs.
         */

        FXMLLoader fxmlLoader = new FXMLLoader(MyApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Nowy użytkownik");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        /**
         * Main method to launch the application.
         *
         * @param args Command line arguments.
         */
        launch();
    }
}


