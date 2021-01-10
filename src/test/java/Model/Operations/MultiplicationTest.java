package Model.Operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {
    MathematicalOperation multiplication = OperationFactory.createOperation("*");

    @Test
    void calculate() {
        assertEquals(9, multiplication.calculate(9,1));
        assertEquals(100, multiplication.calculate(10,10));
        assertEquals(0, multiplication.calculate(999999999,0));
        assertEquals(1, multiplication.calculate(0.25,4));
        assertEquals(0.3, multiplication.calculate(0.6,0.5));
        assertEquals(-55, multiplication.calculate(-11,5));
    }
}