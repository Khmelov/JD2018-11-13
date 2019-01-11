package by.it.akhmelev.calc_v4;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestParcer {
    @Test
    public void calc() throws Exception {
        Parcer parcer=new Parcer();
        String actual = parcer.calc("A=2+5.3").intern();
        String expected="7.3";
        assertEquals("Incorrect calc A",expected,actual);
        actual = parcer.calc("B=A*3.5").intern();
        assertEquals("Incorrect calc B","25.55",actual);
    }

    @Test
    public void createVarAFromScalar() throws Exception {
        Parcer parcer=new Parcer();
        String actual = parcer.calc("A=2").intern();
        String expected="2.0";
        assertEquals("Incorrect calc A",expected,actual);
    }
}