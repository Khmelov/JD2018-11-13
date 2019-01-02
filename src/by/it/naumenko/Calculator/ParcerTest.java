package by.it.naumenko.Calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParcerTest {

    @Test
    public void calc() throws CalcExeption {
        Parcer parcer = new Parcer();
        String actual = parcer.calc("A=2+5.3").intern();
        String expected = "7.3";
        assertEquals("НЕ корректрое вычисление 1" , expected,actual);
        actual = parcer.calc("B=A*3.5").intern();
        assertEquals("НЕ корректрое вычисление 2","25.55",actual);
        actual = parcer.calc("B1=B+0.11*-5").intern();
        assertEquals("НЕ корректрое вычисление 3","25.0",actual);
        actual = parcer.calc("B2=A/2-1").intern();
        assertEquals("НЕ корректрое вычисление 4","2.65",actual);
    }

    @Test
    public void createVarFormatScalar() throws CalcExeption {
        Parcer parcer = new Parcer();
        String actual = parcer.calc("A=2.5").intern();
        String expected = "2.5";
        assertEquals("НЕ кореккстное создание переменной А", expected, actual);
    }
}