package by.it.skarpovich.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestParser {
    @Test
    public void calc() throws Exception {
        Parser parser=new Parser();
        String actual = parser.calc("A=2+5.3").intern();
        String expected="7.3";
        assertEquals("Incorrect calc A",expected,actual);

        actual = parser.calc("B=A*3.5").intern();
        assertEquals("Incorrect calc B","25.55",actual);

        actual = parser.calc("C=B+A*2").intern();
        assertEquals("Incorrect calc C","40.15",actual);
        //actual = parser.calc("D=((C-0.15)-20)/(7-5)").intern();
        //assertEquals("Incorrect calc D","10",actual);

        //actual = parser.calc("E={2,3}*C/2").intern();
        //assertEquals("Incorrect calc E","{10,15}",actual);
    }


    @Test
    public void createVarAFromScalar() throws Exception {
        Parser parser=new Parser();
        String actual = parser.calc("A=2").intern();
        String expected="2.0";
        assertEquals("Incorrect calc A",expected,actual);
    }

}