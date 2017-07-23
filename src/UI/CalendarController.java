package UI;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class CalendarController {

    private final static double tileSize = 60.0;
    private final static String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    public BorderPane calendarPane;
    public Button calendarBack;
    public Button calendarNext;

    private LocalDate anchorDate;

    public TilePane calendarTile;
    public AnchorPane calendarAnchor;
    public Label monthYear;

    public void initialize() {
        anchorDate = LocalDate.now();
        calendarTile.setMinSize(tileSize * 7, tileSize * 6 + 10);
        refreshCalendar(anchorDate);
    }

    public void goToLastMonth(ActionEvent actionEvent) {
        int year = anchorDate.getYear();
        int month = anchorDate.getMonthValue() - 1;
        if (month == 0) {
            year--;
            month = 12;
        }
        anchorDate = LocalDate.of(year, month, 1);
        refreshCalendar(anchorDate);
    }

    public void goToNextMonth(ActionEvent actionEvent) {
        int year = anchorDate.getYear();
        int month = anchorDate.getMonthValue() + 1;
        if (month == 13) {
            year++;
            month = 1;
        }
        anchorDate = LocalDate.of(year, month, 1);
        refreshCalendar(anchorDate);
    }

    private void refreshCalendar(LocalDate anchorDate) {
        calendarTile.getChildren().clear();
        int firstDayOfWeek = (anchorDate.getDayOfWeek().getValue() + 7 - anchorDate.getDayOfMonth() % 7 + 1) % 7;
        Month month = anchorDate.getMonth();
        monthYear.setText(month.getDisplayName(TextStyle.FULL, Locale.US) + ' ' + anchorDate.getYear());

        for (String day : days) {
            VBox box = new VBox();
            box.setPrefSize(tileSize, 10.0);
            box.getChildren().add(new Label(day));
            calendarTile.getChildren().add(box);
        }

        // populating empty tiles before the first day of the month
        for (int i = 0; i < firstDayOfWeek; i++) {
            VBox box = new VBox();
            box.setPrefSize(tileSize, tileSize);
            calendarTile.getChildren().add(box);
        }

        for (int i = 1; i <= month.length(anchorDate.getYear() % 4 == 0); i++) {
            VBox box = new VBox();
            box.setPrefSize(tileSize, tileSize);
            box.getChildren().add(new Label(String.valueOf(i)));
            calendarTile.getChildren().add(box);
        }
    }
}
