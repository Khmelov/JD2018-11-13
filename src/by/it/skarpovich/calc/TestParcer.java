package by.it.skarpovich.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestParcer {
    @Test
    public void calc() throws Exception {
        Parcer parcer=new Parcer();
        String actual = parcer.calc("A=2+5.3").intern();
        String expected="7.3";
        assertEquals("Incorrect calc A",expected,actual);

        actual = parcer.calc("B=A*3.5").intern();
        assertEquals("Incorrect calc B","25.55",actual);

        actual = parcer.calc("C=B+A*2").intern();
        assertEquals("Incorrect calc C","40.15",actual);

        actual = parcer.calc("D=((C-0.15)-20)/(7-5)").intern();
        assertEquals("Incorrect calc D","10",actual);

       actual = parcer.calc("E={2,3}*(D/2)/(7-5)").intern();
       assertEquals("Incorrect calc E","{10,15}",actual);
    }


    @Test
    public void createVarAFromScalar() throws Exception {
        Parcer parcer=new Parcer();
        String actual = parcer.calc("A=2").intern();
        String expected="2.0";
        assertEquals("Incorrect calc A",expected,actual);
    }

}