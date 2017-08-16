package Controller;

import Entity.Calendar;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.function.BiConsumer;


public class AddEventController {
    public Button btcancel;
    public Button btadd;
    public DatePicker datepicker;
    public TextArea description;
    private int groupid;

    private BiConsumer<Integer, Integer> callback;

    void setCallback(BiConsumer<Integer, Integer> callback) {
        this.callback = callback;
    }

    void setGroupId(int gid) {groupid = gid; }

    public void bt_cancel(ActionEvent actionEvent) {
        Stage stage= (Stage) btcancel.getScene().getWindow();
        stage.close();
    }

    public void bt_add(ActionEvent actionEvent) {
        String desc=description.getText();
        if(datepicker.isManaged()&& !desc.isEmpty()) {
            String raw_date= datepicker.getValue().toString();

            String yyyy= raw_date.substring(0,4);
            String mm=raw_date.substring(5,7);
            String dd=raw_date.substring(8,10);

            int year= Integer.parseInt(yyyy);
            int month= Integer.parseInt(mm);
            int day=  Integer.parseInt(dd);

            try {
                Calendar calendar = CalendarFactory.searchCalendar(groupid, year, month);
                if (calendar == null) {
                    int cid = CalendarFactory.insertCal(new ArrayList<>(), year, month);
                    GroupToCalendarDB.insertG2C(groupid, cid);
                    calendar = CalendarFactory.searchCalendar(cid);
                }
                int eid = EventFactory.insertEvent(year, month, day, desc, calendar.getCalendarId());
                calendar.getEventIds().add(eid);
                CalendarFactory.updateCalEvent(calendar.getCalendarId(), calendar.getEventIds());

                if (callback != null) callback.accept(year, month);
            }catch (Exception e){
                e.printStackTrace();
            }

            Stage stage = (Stage) btadd.getScene().getWindow();
            stage.close();
        }
    }
}
