package by.it.naumenko.expirements;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalkExperementTest {

    @Test
    public void testAdd() throws Exception {
        int actual = CalkExperement.add(5, 6);
        int expected = 11;
        assertEquals("ERROR ADD:", expected, actual);

    }

    @Test
    public void testSub() {
        int actual = CalkExperement.sub(5, 6);
        int expected = -1;
        assertEquals("ERROR SUB:", expected, actual);
    }

    @Test
    public void testMul() {
        int actual = CalkExperement.mul(5, 6);
        int expected = 30;
        assertEquals("ERROR MUL:", expected, actual);
    }

    @Test
    public void testDiv() {
        double actual = CalkExperement.div(5, 2);
        double expected = 2.5;
        assertEquals("ERROR div:",expected, actual,0);
    }
}