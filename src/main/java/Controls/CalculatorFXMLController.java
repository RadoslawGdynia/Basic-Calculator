package Controls;

import Operations.MathematicalOperation;
import Operations.OperationFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorFXMLController {
    private static final Logger log = LoggerFactory.getLogger(CalculatorFXMLController.class);
    @FXML
    Button Button0;
    @FXML
    Button Button1;
    @FXML
    Button Button2;
    @FXML
    Button Button3;
    @FXML
    Button Button4;
    @FXML
    Button Button5;
    @FXML
    Button Button6;
    @FXML
    Button Button7;
    @FXML
    Button Button8;
    @FXML
    Button Button9;
    @FXML
    Button ButtonComa;
    @FXML
    Button ButtonMultiply;
    @FXML
    Button ButtonDivide;
    @FXML
    Button ButtonMinus;
    @FXML
    Button ButtonPlus;
    @FXML
    Button ButtonCancel;
    @FXML
    Label EquationLabel;
    @FXML
    Label ResultLabel;

    private String input1, input2;
    private SimpleStringProperty equation = new SimpleStringProperty("");
    private SimpleStringProperty active = new SimpleStringProperty("");
    private MathematicalOperation mathOperation;

    public CalculatorFXMLController() {
    }

    public void initialize() {
        input1="";
        input2="";
        EquationLabel.textProperty().bind(equation);
        ResultLabel.textProperty().bind(active);
    }

    public void handleNumberButton(ActionEvent e) {
        Button a = (Button) e.getTarget();
        String text = a.getText();
        active.setValue(active.getValue()+text);

    }

    public void handleOperationButton(ActionEvent action) {
        Button b = (Button) action.getTarget();
        String symbol = b.getText();
        if (input1.isEmpty())  {
            if(active.getValue().isEmpty()) input1 = "0";
            else input1 = active.getValue();
        }
        mathOperation = OperationFactory.createOperation(symbol);

        setEquation(input1,symbol);
        active.setValue("");

    }
    public void handleEqualButton() {
        input2=active.getValue();

        if(input2.equals("")) input2 = "0";
        double value1 = Double.parseDouble(input1);
        double value2 = Double.parseDouble(input2);
        try {
            setEquation(input2);
            double result = mathOperation.calculate(value1, value2);
            active.setValue(result +"");
        } catch (ArithmeticException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Math error: " + e.getMessage());
                alert.setHeaderText("You tried to conduct illegal mathematical operation: " + e.getMessage());
                alert.setContentText("There is no calculator in the world that could calculate that");
                alert.showAndWait();
        }
        initialize();

    }
    public void handleCButton(){
        input1="";
        input2="";
        mathOperation=null;
        equation.set("");
        active.setValue("");
    }
    public void handleComaButton(){

        if (active.getValue().contains(".")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Multiple comas");
            alert.setContentText("Each number you wish to insert to calculator is limited to just one coma. Inserting more than one to a number will result in error.");
            alert.showAndWait();
        } else {
            active.setValue(active.getValue()+".");
        }


    }
    private void setEquation(String input, String sign){
        equation.setValue(input+sign);

    } private void setEquation(String input2){
        equation.setValue(equation.getValue()+input2+"=");
    }

}
