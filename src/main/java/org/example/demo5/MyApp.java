package org.example.demo5;

import entity.UserRepository;
import jakarta.persistence.Persistence;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MyApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        var emf = Persistence.createEntityManagerFactory("default");
        var em = emf.createEntityManager();
        var userRepository = new UserRepository(em);
        var userService = new UserService(userRepository);

        FXMLLoader fxmlLoader = new FXMLLoader(MyApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Nowy użytkownik");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


