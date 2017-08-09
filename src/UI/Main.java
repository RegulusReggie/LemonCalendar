package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Connection.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();

        Client.main("SELECT * FROM CALENDAR;");
        //DBAccess.getDBA();
        //System.out.print(EventFactory.searchEventByDate(1984,12,31).getDescription());
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
