package Model.Operations;

public class Addition implements MathematicalOperation {
    @Override
    public double calculate(double value1, double value2) {
        return value1+value2;
    }
}
