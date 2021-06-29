package mr.cell.diffblue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ComplexOperationsTest {
    @Test
    public void testPublicMethod() {
        assertEquals("Parameter", (new ComplexOperations()).publicMethod("Parameter", true));
        assertEquals("ParameterParameter", (new ComplexOperations()).publicMethod("Parameter", false));
    }
}

