package UI;

import Controller.CalendarFactory;
import Entity.Calendar;
import Util.DBAccess;
import Util.Commons;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
        DBAccess.getDBA();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
