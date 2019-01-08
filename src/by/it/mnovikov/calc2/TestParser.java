package by.it.mnovikov.calc2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestParser {

    private static String actual;
    private static String expected;

    @Test
    public void calc() throws Exception {
        Parcer parc = new Parcer();
        actual = parc.calc("A=2+5.3").intern();
        expected = "7.3";
        assertEquals("Incorrect calc A", expected, actual);
        actual = parc.calc("B=A*3.5").intern();
        expected = "25.55";
        assertEquals("Incorrect calc B", expected, actual);
        actual = parc.calc("B1=B+0.11*-5").intern();
        expected = "25.0";
        assertEquals("Incorrect calc B1", expected, actual);
        actual = parc.calc("B2=A/2-1").intern();
        expected = "2.65";
        assertEquals("Incorrect calc B2", expected, actual);
    }

    @Test
    public void createVarAFromScalar() throws Exception {
        Parcer parc = new Parcer();
        actual = parc.calc("A=2").intern();
        expected = "2.0";
        assertEquals("Incorrect create A", expected, actual);
    }

    @Test
    public void scalarSumScalar() throws Exception {
        Parcer parc = new Parcer();
        actual = parc.calc("2+2").intern();
        expected = "4.0";
        assertEquals("Incorrect sum S", expected, actual);
    }

    @Test
    public void scalarMulScalar() throws Exception {
        Parcer parc = new Parcer();
        actual = parc.calc("2*2").intern();
        expected = "4.0";
        assertEquals("Incorrect mul S", expected, actual);
    }

    @Test
    public void scalarSubScalar() throws Exception {
        Parcer parc = new Parcer();
        actual = parc.calc("2-2").intern();
        expected = "0.0";
        assertEquals("Incorrect sub S", expected, actual);
    }

    @Test
    public void scalarDivScalar() throws Exception {
        Parcer parc = new Parcer();
        actual = parc.calc("2/2").intern();
        expected = "1.0";
        assertEquals("Incorrect div S", expected, actual);
    }
}
