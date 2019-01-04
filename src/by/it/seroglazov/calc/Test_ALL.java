package by.it.seroglazov.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test_ALL extends TestMatrix{

    @Test
    public void testFromHomeTask() throws CalcException {
        Parcer parcer = new Parcer();
        parcer.calc("A=2+5.3");
        parcer.calc("B=A*3.5");
        parcer.calc("C=B+(A*2)");
        parcer.calc("D=((C-0.15)-20)/(7-5)");
        String res = parcer.calc("E={2,3}*(D/2)");
        assertEquals("{10.0, 15.0}", res);
    }

}