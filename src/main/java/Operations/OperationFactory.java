package Operations;

public class OperationFactory {


    public static MathematicalOperation createOperation(String x) {

      if(x.equals("+")){
            return new Addition();
        } else if (x.equals("-")){
            return  new Subtraction();
        } else if (x.equals("*")){
            return new Multiplication();
        } else if (x.equals("/")) {
            return new Division();
        } else {
            return new ErrorOperation();
        }


    }
}
