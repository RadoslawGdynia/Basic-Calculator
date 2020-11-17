package Operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorOperationTest {
    @Test
    void calculate() {
        assertEquals(0, OperationFactory.createOperation("j").calculate(9,44));
    }
}