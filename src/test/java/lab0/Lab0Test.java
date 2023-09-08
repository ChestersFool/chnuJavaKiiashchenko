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

    @Test
    public void testSwitchTask() {
        assertEquals(new Lab0().switchTask(1, 1),
                "a: 1.0; R1: 0.28867513459481287; R2: 0.5773502691896257; S: 0.4330127018922193;");
    }
}