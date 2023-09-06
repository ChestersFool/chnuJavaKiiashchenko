package lab0;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Lab0Test {

    @Test
    public void testIntegerNumberTask() {
        assertEquals(new Lab0().integerNumberTask(123), 312);
        assertEquals(new Lab0().integerNumberTask(101), 110);
        assertEquals(new Lab0().integerNumberTask(480), 48);
    }

    @Test
    public void testBooleanTask() {
        assertFalse(new Lab0().booleanTask(10, 10, 10));
        assertFalse(new Lab0().booleanTask(-10, -10, -10));
        assertFalse(new Lab0().booleanTask(10, -10, -10));
        assertTrue(new Lab0().booleanTask(-10, 10, 10));
    }

    @Test
    public void testIfTask() {
        assertEquals(new Lab0().ifTask(3.,2.,1.), "1.0, 3.0");
    }
}