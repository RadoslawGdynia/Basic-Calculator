package Operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {
    MathematicalOperation addition = OperationFactory.createOperation("+");

    @Test
    public void calculate(){
        assertEquals(5, addition.calculate(2.5,2.5));
        assertEquals(1, addition.calculate(1,0));
        assertEquals(447, addition.calculate(-1,448));
        assertEquals(-15, addition.calculate(-7,-8));
        assertEquals(6, addition.calculate(9,-3));
        assertEquals(10000000000.00, addition.calculate(9999999999.6,0.4));

    }

}