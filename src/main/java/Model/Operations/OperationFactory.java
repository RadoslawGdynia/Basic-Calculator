package Model.Operations;

public class OperationFactory {

    public static MathematicalOperation createOperation(String x) {
        switch(x) {
            case "+":
                return new Addition();
            case "-":
                return  new Subtraction();
            case "*":
                return new Multiplication();
            case "/":
                return new Division();
            default:
                return new ErrorOperation();
        }
    }
}
