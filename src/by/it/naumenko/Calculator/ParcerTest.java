package by.it.naumenko.Calculator;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParcerTest {

    @Test
    public void calc() throws CalcExeption {
        Parcer parcer = new Parcer();
        String actual = parcer.calc("A=2+5.3").intern();
        String expected = "7.3";
        assertEquals("НЕ корректрое вычисление 1", expected, actual);
        actual = parcer.calc("B=A*3.5").intern();
        assertEquals("НЕ корректрое вычисление 2", "25.55", actual);
        actual = parcer.calc("B1=B+0.11*-5").intern();
        assertEquals("НЕ корректрое вычисление 3", "25.0", actual);
        actual = parcer.calc("B2=A/2-1").intern();
        assertEquals("НЕ корректрое вычисление 4", "2.65", actual);

        //actual = parcer.calc("C=B+(A*2)").intern();
        actual = parcer.calc("C=b+c1").intern();
        assertEquals("НЕ корректрое вычисление 5", "40.15",actual);

        //actual = parcer.calc("D=((C-0.15)-20)/(7-5)").intern();
        actual = parcer.calc("D=c22/c23").intern();
        assertEquals("НЕ корректрое вычисление 6", "10.0",actual);
    }

    @Test
    public void createVarFormatScalar() throws CalcExeption {
        Parcer parcer = new Parcer();
        String actual = parcer.calc("A=2.5").intern();
        String expected = "2.5";
        assertEquals("НЕ кореккстное создание переменной А", expected, actual);
    }

    @Test
    public void calcVector() throws CalcExeption, IOException {
        Parcer parcer = new Parcer();
//        String actual = parcer.calc("N={1.0, 2.0, 3.0}").intern();
//        String expected = "{1.0, 2.0, 3.0}";
//        assertEquals("НЕ кореккстное создание вектора N", expected, actual);
//        actual = parcer.calc("v={5.0, 10.0, 15.0}").intern();
//        assertEquals("НЕ кореккстное создание вектора v", "{5.0, 10.0, 15.0}", actual);
        Var.readVarFile();
        String actual = parcer.calc("N+v*5").intern();
        String expected = "{26.0, 52.0, 78.0}";
        assertEquals("НЕ корректное первое вычисение с вектором", expected,actual);


        //actual = parcer.calc("E={2,3}*(D/2)").intern();
        actual = parcer.calc("E={2,3}*c32").intern();
        assertEquals("НЕ корректное первое вычисение с вектором", "{10.0, 15.0}",actual);




    }

    @Test
    public void createVarFormatVector() throws CalcExeption {
        Parcer parcer = new Parcer();
        String actual = parcer.calc("N={1.0, 2.0, 3.0}").intern();
        String expected = "{1.0, 2.0, 3.0}";
        assertEquals("НЕ кореккстное создание вектора N", expected, actual);
    }

    @Test
    public void calcMatrix() throws CalcExeption, IOException {
        Parcer parcer = new Parcer();;
        Var.readVarFile();
        String actual = parcer.calc("m1=N*v").intern();
        String expected = "70.0";
        assertEquals("НЕ корректное первое вычисение с матрицей", expected,actual);

        actual = parcer.calc("m2=m*d").intern();//m={{1,2,3},{4,5,6},{7,8,9}}
        assertEquals("НЕ корректное второе вычисение с матрицей", "{{10.0, 20.0, 30.0}, " +
                                                                   "{40.0, 50.0, 60.0}, " +
                                                                   "{70.0, 80.0, 90.0}}",actual);

        actual = parcer.calc("m3=m*m2").intern();//m={{1,2,3},{4,5,6},{7,8,9}}
        assertEquals("НЕ корректное третье вычисение с матрицей", "{{300.0, 360.0, 420.0}, " +
                                                                   "{660.0, 810.0, 960.0}, " +
                                                                   "{1020.0, 1260.0, 1500.0}}", actual);
    }

    @Test
    public void createVarFormatMatrix() throws CalcExeption {
        Parcer parcer = new Parcer();
        String actual = parcer.calc("N={1.0, 2.0, 3.0}").intern();
        String expected = "{1.0, 2.0, 3.0}";
        assertEquals("НЕ кореккстное создание вектора N", expected, actual);
    }
}