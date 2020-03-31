package quiz;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Arrays;

public class Controller {
    @FXML
    public CheckBox q3a1, q3a2, q3a3, q3a4, q3a5;



    /*
     TODO:
      checkbox question for which are unchecked exceptions
      checkbox question for which are methods of StringBuilder
      checkbox question, which of the following are true about Arrays... mutable, fixed size etc
      what line fo the following doesn't compile question
    */

    @FXML
    public ToggleGroup equality;
    @FXML
    public ToggleGroup color;

    public Button submitButton;
    public Label scoreDisplay;

    public int score = 0;

    public void submit() {
        // Question 1
        validateRadioQuestion(equality, "== checks object reference equality (do the references refer to the same object)");
        // Question 2
        validateRadioQuestion(color, "Purple");
        // Question 3
        validateCheckBoxQuestion(new String[]{"FileNotFoundException", "IOException"}, q3a1,q3a2, q3a3, q3a4, q3a5);

        // Updating score display
        scoreDisplay.setText("Score: " + score);
    }

    private void validateCheckBoxQuestion(String[] correctAnswers, CheckBox... checkBox) {
        for (CheckBox cb : checkBox) {
            if (Arrays.asList(correctAnswers).contains(cb.getText())) {
                cb.setStyle("-fx-color: green");
                if ((cb.isSelected())) {
                    score += 1;
                }
            } else {
                cb.setStyle("-fx-color: red");
            }
        }
    }

    private void validateRadioQuestion(ToggleGroup toggleGroup, String correctAnswer) {
        ObservableList<Toggle> toggles = toggleGroup.getToggles();
        for (Toggle toggle : toggles) {
            RadioButton radioButton = (RadioButton) toggle;
            if (radioButton.getText().equals(correctAnswer)) {
                radioButton.setStyle("-fx-color:green");
                if (radioButton.isSelected()) {
                    score += 1;
                }
            } else {
                radioButton.setStyle("-fx-color: red;");
            }
        }
    }


}
