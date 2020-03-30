package quiz;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Controller {

    @FXML
    ToggleGroup fruit;

    public Button submitButton;
    public Label scoreDisplay;

    public int score = 0;

    public void submit() {
        // Question 1
        if (fruit.getSelectedToggle() != null) {
            RadioButton selectedRadioButton = (RadioButton) fruit.getSelectedToggle();
            String toogleGroupValue = selectedRadioButton.getText();
            if (toogleGroupValue.equals("Banana")) {
                score += 1;
            }
        }
        // Updating score display
        scoreDisplay.setText("Score: " + score);
    }


}
