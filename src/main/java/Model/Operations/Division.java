package Model.Operations;

public class Division implements MathematicalOperation {
    @Override
    public double calculate(double value1, double value2) throws ArithmeticException {
        if(value2 == 0){
            throw new ArithmeticException("Division by 0");
        }
        return value1/value2;
    }
}
