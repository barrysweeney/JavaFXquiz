package quiz;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Arrays;

public class Controller {
    @FXML
    public CheckBox q3a1, q3a2, q3a3, q3a4, q3a5, q5a1, q5a2, q5a3, q5a4, q5a5, q5a6;

    @FXML
    public ToggleGroup equality, wrapper, aioobe;
    public Button submitButton;
    public Label scoreDisplay;

    public int score = 0;


    public void submit() {
        // Question 1
        validateRadioQuestion(equality, "== checks object reference equality (do the references refer to the same object)");
        // Question 2
        validateRadioQuestion(wrapper, "parseInt() returns a primitive and valueOf() returns a wrapper class object");
        // Question 3
        validateCheckBoxQuestion(new String[]{"FileNotFoundException", "IOException"}, q3a1, q3a2, q3a3, q3a4, q3a5);
        // Question 4
        validateRadioQuestion(aioobe, "myArray[1][0]");
        // Question 5
        validateCheckBoxQuestion(new String[]{"myArray.length is 1", "myArray[0].length is 2"}, q3a5, q5a1, q5a2, q5a3, q5a4, q5a5, q5a6);
        // Updating score display
        scoreDisplay.setText("Score: " + score + "/5");
    }

    private void validateCheckBoxQuestion(String[] correctAnswers, CheckBox... checkBox) {
        boolean answerCorrect = true;
        for (CheckBox cb : checkBox) {
            if (Arrays.asList(correctAnswers).contains(cb.getText())) {
                cb.setStyle("-fx-color: #22ca18");
                // if it's the correct answer but isn't selected then it's incorrect
                if (!cb.isSelected()) {
                    answerCorrect = false;
                }
            } else {

                // if it isn't the correct answer and is selected then it's incorrect
                if (cb.isSelected()) {
                    cb.setStyle("-fx-color: #ab0202");
                    answerCorrect = false;
                }
            }
        }
        if (answerCorrect) {
            score += 1;
        }
    }

    private void validateRadioQuestion(ToggleGroup toggleGroup, String correctAnswer) {
        ObservableList<Toggle> toggles = toggleGroup.getToggles();
        for (Toggle toggle : toggles) {
            RadioButton radioButton = (RadioButton) toggle;
            if (radioButton.getText().equals(correctAnswer)) {
                radioButton.setStyle("-fx-color: #22ca18");
                if (radioButton.isSelected()) {
                    score += 1;
                }
            } else {
                if (radioButton.isSelected()) {
                    radioButton.setStyle("-fx-color: #ab0202");
                    score += 1;
                }

            }
        }
    }
}
