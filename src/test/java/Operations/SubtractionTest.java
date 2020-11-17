package Operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionTest {
    MathematicalOperation subtraction = OperationFactory.createOperation("-");

    @Test
    void calculate() {
        assertEquals(1, subtraction.calculate(2,1));
        //assertEquals(-0.09, subtraction.calculate(0.01,0.1));
        assertEquals(1000000, subtraction.calculate(1001000,1000));
        assertEquals(-10, subtraction.calculate(-7,3));
        assertEquals(9, subtraction.calculate(99,90));
        assertEquals(0, subtraction.calculate(0,0));


    }
}