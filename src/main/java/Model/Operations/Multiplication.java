package Model.Operations;

public class Multiplication implements MathematicalOperation {
    @Override
    public double calculate(double value1, double value2) {
        return value1*value2;
    }
}
