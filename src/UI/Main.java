package UI;

import Controller.CalendarFactory;
import Controller.GroupFactory;
import Entity.*;
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
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
        DBAccess.getDBA();
        System.out.print(GroupFactory.searchGroups(6).getGroupName());
        //GroupFactory.updateGpMember(1, convertStringToList("1 2 8 4"));
        //GroupFactory.insertGp("NewGroup", convertStringToList("3 4 6"), convertStringToList("1"), 3);
        //CalendarFactory.insertCal(3, convertStringToList("2 3 4 5 6 7 8"), 5400, 12);
        //Calendar cal = CalendarFactory.searchCalendar(1);
        //System.out.println(cal.getEventId());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
