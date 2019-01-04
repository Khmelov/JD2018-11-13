package by.it.seroglazov.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParcerTest {

    @Test
    public void testA() throws CalcException {
        Parcer parcer = new Parcer();
        Var res = parcer.calc("A=2+5.3");
        assertEquals("7.3", res.toString());
        res = parcer.calc("B=A*3.5");
        assertEquals("25.55", res.toString());
        res = parcer.calc("B1=B+0.11*-5");
        assertEquals("25.0", res.toString());
        res = parcer.calc("B2=A/2-1");
        assertEquals("2.65", res.toString());
    }
}