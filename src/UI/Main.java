package UI;

import Controller.CalendarFactory;
import Entity.Calendar;
import Util.DBAccess;
import Util.Commons;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static Util.Commons.convertStringToList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("LemonCalender Login");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
        DBAccess.getDBA();
        //CalendarFactory.insertCal(convertStringToList("1 2 3 4 5 6"), 3, convertStringToList("2 3 4 5 6 7 8"), 5400, 12);
        //Calendar cal = CalendarFactory.searchCalendar(1);
        //System.out.println(cal.getEventId());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
