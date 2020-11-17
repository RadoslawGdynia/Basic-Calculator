package Operations;

public class OperationFactory {
    private static boolean alreadyUsed = false;

    public static MathematicalOperation createOperation(String x) {

        alreadyUsed=true;
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

    public static boolean isAlreadyUsed() {
        return alreadyUsed;
    }

    public static void setAlreadyUsed(boolean alreadyUsed) {
        OperationFactory.alreadyUsed = alreadyUsed;
    }
}
