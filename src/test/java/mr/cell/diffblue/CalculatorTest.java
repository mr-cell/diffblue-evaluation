package mr.cell.diffblue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testAdd() {
        assertEquals(20.0, Calculator.add(10.0, 10.0), 0.0);
    }

    @Test
    public void testMin() {
        assertEquals(0.0, Calculator.min(10.0, 10.0), 0.0);
        assertThrows(IllegalArgumentException.class, () -> Calculator.min(10.0, 0.0));
    }

    @Test
    public void testDiv() {
        assertEquals(1.0, Calculator.div(10.0, 10.0), 0.0);
    }

    @Test
    public void testMul() {
        assertEquals(100.0, Calculator.mul(10.0, 10.0), 0.0);
    }
}

