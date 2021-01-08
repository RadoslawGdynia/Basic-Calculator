package Model;

import Operations.MathematicalOperation;
import Operations.OperationFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;

public class CalculatorModel {
    private Double firstNumber, secondNumber;
    private final SimpleStringProperty equationDisplayText = new SimpleStringProperty("");
    private final SimpleStringProperty currentlyCreatedNumber = new SimpleStringProperty("");
    private MathematicalOperation mathOperation;

    public SimpleStringProperty equationDisplayTextProperty() {
        return equationDisplayText;
    }

    public SimpleStringProperty currentlyCreatedNumberProperty() {
        return currentlyCreatedNumber;
    }
    public void updateCurrentlyCreatedNumber(String numberText){
        currentlyCreatedNumber.setValue(currentlyCreatedNumber.getValue()+numberText);
    }

    public void mathOperationChoiceResults(String operationSymbol) {
        createFirstNumberSetZeroIfAbsent();
        mathOperation = OperationFactory.createOperation(operationSymbol);
        setFirstHalfOfDisplayText(currentlyCreatedNumber.getValue(), operationSymbol);
        currentlyCreatedNumber.setValue("");
    }
    private void createFirstNumberSetZeroIfAbsent(){
        if (firstNumber==null)  {
            if(currentlyCreatedNumber.getValue().isEmpty()) firstNumber = 0d;
            else firstNumber = Double.parseDouble(currentlyCreatedNumber.getValue());
        }
    }
    private void setFirstHalfOfDisplayText(String number, String operationSymbol){
        equationDisplayText.setValue(number + operationSymbol);
    }
    public void equalSignLogic() {
        if(firstNumber!=null) {
          performEqualSignLogic(currentlyCreatedNumber.getValue());
        }
    }
    private void performEqualSignLogic(String secondNumberText){
        createSecondNumberSetZeroIfAbsent(secondNumberText);
        setSecondHalfOfDisplayText(secondNumberText);
        conductCalculations(firstNumber, secondNumber);
        setInitialValues();
    }
    private void createSecondNumberSetZeroIfAbsent(String secondNumberText){
        secondNumber = (secondNumberText.isEmpty())? secondNumber = 0d : Double.parseDouble(secondNumberText);
    }
    private void setSecondHalfOfDisplayText(String secondNumberText){
        equationDisplayText.setValue(equationDisplayText.getValue()+secondNumberText+"=");
    }
    private void conductCalculations(double numberValue1, double numberValue2){
        try {
            double result = mathOperation.calculate(numberValue1, numberValue2);
            currentlyCreatedNumber.setValue(result + "");
        } catch (ArithmeticException e) {
            createMathematicalErrorAlert(e.getMessage());
        }
    }
    private void createMathematicalErrorAlert(String errorMessage){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Math error: " + errorMessage);
        alert.setHeaderText("You tried to conduct illegal mathematical operation: " + errorMessage);
        alert.setContentText("There is no calculator in the world that could calculate that");
        alert.showAndWait();
    }

    public void setInitialValues() {
        firstNumber = null;
        secondNumber = null;
        mathOperation = null;
    }
    public void resetButtonLogic(){
        setInitialValues();
        currentlyCreatedNumber.setValue("");
        equationDisplayText.setValue("");
    }
    public void comaButtonLogic(){
        if (currentlyCreatedNumber.getValue().contains(".")) {
            createMultipleComasAlert();
        } else {
            currentlyCreatedNumber.setValue(currentlyCreatedNumber.getValue()+".");
        }
    }
    private void createMultipleComasAlert(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Multiple comas");
        alert.setContentText("Each number you wish to insert to calculator is limited to just one coma. Inserting more than one to a number will result in error.");
        alert.showAndWait();
    }



}
