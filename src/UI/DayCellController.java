package UI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DayCellController {
    @FXML
    public Label date;
    public Button backButton;

    void setDate(String d) {
        date.setText(d);
    }

    @FXML
    private void closeWindow() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
