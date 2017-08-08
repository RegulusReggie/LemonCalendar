package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;


public class AddEventController {
    public Button btcancel;
    public Button btadd;
    public DatePicker datepicker;
    public TextArea description;
    public IntegerStringConverter integerStringConverter;


    public void bt_cancel(ActionEvent actionEvent) {
        Stage stage= (Stage) btcancel.getScene().getWindow();
        stage.close();
    }

    public void bt_add(ActionEvent actionEvent) {
        String desc=description.getText();
        if(datepicker.isManaged()&& !desc.isEmpty()) {
            String raw_date= datepicker.getValue().toString();
            System.out.println(raw_date);

            String yyyy= raw_date.substring(0,4);
            String mm=raw_date.substring(5,7);
            String dd=raw_date.substring(8,10);
            System.out.println(yyyy+mm+dd);

            int year= Integer.parseInt(yyyy);
            int month= Integer.parseInt(mm);
            int day=  Integer.parseInt(dd);
            try {
                EventFactory.insertEvent(year,month,day,desc,1);
            }catch (Exception e){

            }

            Stage stage = (Stage) btadd.getScene().getWindow();
            stage.close();
        }
    }
}
