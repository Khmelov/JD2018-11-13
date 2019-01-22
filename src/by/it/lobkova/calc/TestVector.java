package by.it.lobkova.calc;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class TestVector {
    @Test
    public void testCreateVector() throws CalcException {
        Parcer parcer = new Parcer();
        parcer.calc("V={-1,2,4.5, -5.6, 7.00}");
        String res = parcer.calc("V");
        assertEquals("{-1.0, 2.0, 4.5, -5.6, 7.0}", res);
    }

    @Test
    public void testVectorAddScalar() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc("A={1,1,4.1,4}+5.1");
        assertEquals("{6.1, 6.1, 9.2, 9.1}", res);
    }

    @Test
    public void testVectorAddVector() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc("A={1,2,3}+{4,5,6}");
        assertEquals("{5.0, 7.0, 9.0}", res);
    }

    @Test
    public void testVectorSubScalar() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc("A={1,2,3}-2");
        assertEquals("{-1.0, 0.0, 1.0}", res);
    }

    @Test
    public void testVectorSubVector() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc("A={1, 2, 3.2}-{4, 5.5, 6.2}");
        assertEquals("{-3.0, -3.5, -3.0}", res);
    }

    @Test
    public void testVectorMulScalar() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc("A={1, 2, 3.2}*1.2");
        assertEquals("{1.2, 2.4, 3.84}", res);
    }

    @Test
    public void testVectorMulVector() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc("A={2,3,4}*{1,2,3}");
        assertEquals("20.0", res);
    }

    @Test(expected = CalcException.class)
    public void testVectorMulVectorWithNullResult() throws CalcException {
        Parcer parcer = new Parcer();
        parcer.calc("A={1,1,1}*{33,33}");
        fail();
    }

    @Test
    public void testVectorDivScalar() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc("A={2.4,-2,3}/-2");
        assertEquals("{-1.2, 1.0, -1.5}", res);
    }

    @Test(expected = CalcException.class)
    public void testVectorDivVector() throws CalcException {
        Parcer parcer = new Parcer();
        parcer.calc("A={1,1,1}/{2,2,2}");
        fail();
    }

    @Test
    public void testMultiVectorArgumentsAndParentheses() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc("A=({10,-3,5.5}+{1,1,-1}*2)*{0.5, -1.0, 1}");
        assertEquals("10.5", res);
    }
}
