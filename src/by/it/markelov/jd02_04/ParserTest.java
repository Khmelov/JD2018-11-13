package by.it.markelov.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void calc() throws CalcException {
        Parser parser=new Parser();
        String actual = parser.calc("A=2+5.3").intern();
        String expected="7.3";
        assertEquals("Incorrect calc A",expected,actual);

        actual = parser.calc("B=A*3.5").intern();
        expected="25.55";
        assertEquals("Incorrect calc B",expected,actual);

        actual = parser.calc("B1=B+0.11*-5").intern();
        expected="25.0";
        assertEquals("Incorrect calc B1",expected,actual);

        actual = parser.calc("B2=A/2-1").intern();
        expected="2.65";
        assertEquals("Incorrect calc B2",expected,actual);
    }

    @Test
    public void createVarAFromScalar() throws Exception {
        Parser parser=new Parser();
        String actual = parser.calc("A=2").intern();
        String expected="2.0";
        assertEquals("Incorrect calc A",expected,actual);
    }
}