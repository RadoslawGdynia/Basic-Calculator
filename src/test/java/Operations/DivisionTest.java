package Operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {
    MathematicalOperation division = OperationFactory.createOperation("/");

    @Test
    void calculate_correct() {
        assertEquals(5, division.calculate(25,5));
        assertEquals(1, division.calculate(1,1));
        assertEquals(0.25, division.calculate(1,4));
        assertEquals(-5, division.calculate(-25,5));
        assertEquals(-5, division.calculate(25,-5));
        assertEquals(0.1, division.calculate(10,100));
        assertEquals(4, division.calculate(5,1.25));

    }
    @Test
    void calculate_error() {
        assertThrows(ArithmeticException.class, () -> {division.calculate(1,0);});
    }
}