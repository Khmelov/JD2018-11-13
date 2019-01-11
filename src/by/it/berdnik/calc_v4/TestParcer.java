package by.it.berdnik.calc_v4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestParcer {

    @Test
    public void calc() throws Exception {
        Parcer parcer = new Parcer();
        String expected = "7.3";
        String actual = parcer.calc("A=2+5.3").intern();
        assertEquals("Incorrect calc A", expected, actual);
        System.out.println("calc A=2+5.3" + " expected:" + expected + " actual:" + actual);

        actual = parcer.calc("B=A*3.5").intern();
        assertEquals("Incorrect calc B", "25.55", actual);
        System.out.println("calc B=A*3.5 expected:25.55 actual:" + actual);

        actual = parcer.calc("B1=B+0.11*-5").intern();
        assertEquals("Incorrect calc B1", "25.0", actual);
        System.out.println("calc B1=B+0.11*-5 expected:25.0 actual:" + actual);

        actual = parcer.calc("B2=A/2-1").intern();
        assertEquals("Incorrect calc B2", "2.65", actual);
        System.out.println("calc B2=A/2-1 expected:2.65 actual:" + actual);

        actual = parcer.calc("C=B+A*2").intern();
        assertEquals("Incorrect calc C", "40.15", actual);
        System.out.println("calc C=B+A*2 expected:40.15 actual:" + actual);

        actual = parcer.calc("D=((C-0.15)-20)/(7-5)").intern();
        assertEquals("Incorrect calc D", "10", actual);
        System.out.println("calc D=((C-0.15)-20)/(7-5) expected:10 actual:" + actual);

        actual = parcer.calc("E={2,3}*(D/2)/(7-5)").intern();
        assertEquals("Incorrect calc E", "{10,15}", actual);
        System.out.println("calc E={2,3}*(D/2)/(7-5) expected:{10,15} actual:" + actual);
    }

    @Test
    public void createVarAFromScalar() throws Exception {
        Parcer parcer = new Parcer();
        String actual = parcer.calc("A=2").intern();
        String expected = "2.0";
        assertEquals("Incorrect calc A", expected, actual);
    }
}