package lab0;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Lab0Test {

    @Test
    public void testIntegerNumberTask() {
        assertEquals(Lab0.integerNumberTask(123), 312);
        assertEquals(Lab0.integerNumberTask(101), 110);
        assertEquals(Lab0.integerNumberTask(480), 48);
    }

    @Test
    public void testBooleanTask() {
        assertFalse(Lab0.booleanTask(10, 10, 10));
        assertFalse(Lab0.booleanTask(-10, -10, -10));
        assertTrue(Lab0.booleanTask(10, -10, -10));
        assertFalse(Lab0.booleanTask(-10, 10, 10));
    }

    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int p3, boolean expected) {
        assertEquals(Lab0.booleanTask(p1, p2, p3), expected);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][]{{10, 10, 10, false},
                {-10, -10, -10, false}, {10, -10, -10, true}, {-10, 10, 10, false}};
    }

    @Test
    public void testIfTask() {
        assertEquals(Lab0.ifTask(3., 2., 1.), new double[]{1., 3.});
    }

    @Test
    public void testSwitchTask() {
        assertEquals(Lab0.switchTask(1, 1.),
                new double[]{1., 0.28867513459481287, 0.5773502691896257, 0.4330127018922193});
        assertEquals(Lab0.switchTask(2, 1.),
                new double[]{3.464101615137755, 1.0, 2.0, 5.196152422706632});
        assertEquals(Lab0.switchTask(2, 0.28867513459481287),
                new double[]{1., 0.28867513459481287, 0.5773502691896257, 0.4330127018922193});
        assertEquals(Lab0.switchTask(3, 0.5773502691896257),
                new double[]{1., 0.28867513459481287, 0.5773502691896257, 0.4330127018922193});
        assertEquals(Lab0.switchTask(4, 0.4330127018922193),
                new double[]{1., 0.28867513459481287, 0.5773502691896257, 0.4330127018922193});
    }

    @Test
    public void testForTask() {
        assertEquals(Lab0.forTask(1), List.of(1));
        assertEquals(Lab0.forTask(2), List.of(1, 4));
        assertEquals(Lab0.forTask(3), List.of(1, 4, 9));

    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expectedExceptions = AssertionError.class)
    public void testForTaskNeg() {
        Lab0.forTask(-1);
    }

    @Test
    public void testWhileTask() {
        assertEquals(Lab0.whileTask(1.3), new double[]{2., 1.5});
        assertEquals(Lab0.whileTask(2), new double[]{4., 2.083333333333333});
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expectedExceptions = AssertionError.class)
    public void testWhileTaskNeg() {
        Lab0.whileTask(-1.);
    }

    @Test
    public void testMinmaxTask() {
        assertEquals(Lab0.minmaxTask(3, new double[]{1., 1., 1., 1., 1., 1., 1., 1., 0, 0}), "0, 0");
        assertEquals(Lab0.minmaxTask(3, new double[]{3.1, 3.001, 5., 1., 1., 1., 1., 1., 1., 1.}),
                "minmax: 3.001; index: 1");
    }

    @Test
    public void testArrayTask() {
        assertEquals(Lab0.arrayTask(new double[]{1., 2., 3., 4.}), new double[]{2., 4., 1., 3.});
    }


    /*  1 2 3
     *  4 5 6
     *  7 8 9*/
    @Test
    public void testTwoDimensionArrayTask() {
        assertEquals(Lab0.twoDimensionArrayTask(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}), "");
    }
}