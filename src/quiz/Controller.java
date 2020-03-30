package quiz;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Controller {

    /*
     TODO:
      checkbox question for which are unchecked exceptions
      checkbox question for which are methods of StringBuilder
      checkbox question, which of the following are true about Arrays... mutable, fixed size etc
      what line fo the following doesn't compile question
    */

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
