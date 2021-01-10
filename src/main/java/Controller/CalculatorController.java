package Controller;

import Model.CalculatorModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {

    @FXML
    Label EquationLabel;
    @FXML
    Label ResultLabel;

    private final CalculatorModel model = new CalculatorModel();

    public void initialize() {
        EquationLabel.textProperty().bind(model.equationDisplayTextProperty());
        ResultLabel.textProperty().bind(model.currentlyCreatedNumberProperty());
    }

    public void handleNumberButton(ActionEvent action) {
        String numberValue = ((Button) action.getSource()).getText();
        model.updateCurrentlyCreatedNumber(numberValue);
    }

    public void handleOperationButton(ActionEvent action) {
        String mathOperator = ((Button) action.getSource()).getText();
        model.mathOperationChoiceResults(mathOperator);

    }
    public void handleEqualButton() {
        model.equalSignLogic();

    }
    public void handleCButton(){
        model.resetButtonLogic();
    }
    public void handleComaButton(){
        model.comaButtonLogic();
    }



}
