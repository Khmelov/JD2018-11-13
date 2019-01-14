package by.it.baidak.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

    private Parser parser = new Parser();

    @Test
    public void testScalar(){
        assertEquals("WrongADD","6.0",parser.calc("4+2"));
        assertEquals("WrongSUB","2.0",parser.calc("4-2"));
        assertEquals("WrongMUL","8.0",parser.calc("4*2"));
        assertEquals("WrongDIV","2.0",parser.calc("4/2"));
    }

    @Test
    public void restVector(){
        assertEquals("WrongADD","{4.0,6.0}",parser.calc("2+{2,4}"));
        assertEquals("WrongSUB","{-0.0,-2.0}",parser.calc("2-{2,4}"));
        assertEquals("WrongMUL","{4.0,8.0}",parser.calc("2*{2,4}"));
        assertEquals("WrongDIV","{1.0,2.0}",parser.calc("{2,4}/2"));
    }
}
