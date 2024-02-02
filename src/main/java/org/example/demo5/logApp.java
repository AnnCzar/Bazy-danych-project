//package org.example.demo5;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class logApp extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(MyApp.class.getResource("log_view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 350, 350);
//        stage.setTitle("Logowanie");
//
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}
//
//
package org.example.demo5;

import org.example.demo5.UsersRepository;
import jakarta.persistence.Persistence;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class logApp extends Application {

    private static UserService userService;  // Dodaj pole do przechowywania UserService

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MyApp.class.getResource("log_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 350);
        stage.setTitle("Logowanie");


        stage.setScene(scene);
        stage.show();
        try{
            var emf = Persistence.createEntityManagerFactory("default");
            var em = emf.createEntityManager();
            var userRepository = new UsersRepository(em);
            userService = new UserService(userRepository);
        }catch(Exception e){
            e.printStackTrace();
        }

//        emf.close();
    }



    public static void main(String[] args) {
        launch();
    }

}