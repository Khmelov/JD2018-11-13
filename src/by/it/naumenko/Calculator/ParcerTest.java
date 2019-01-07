package by.it.naumenko.Calculator;

import by.it.naumenko.Calculator.resourse.ResourceManager;
import by.it.naumenko.Calculator.resourse.TextTranslate;
import org.junit.Test;

import java.io.IOException;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ParcerTest {
    ResourceManager resVar = ResourceManager.INSTANCE;

    Locale locale = new Locale("be","BY");

    @Test
    public void calc() throws CalcExeption {
        resVar.setLocale(locale);
        Parcer parcer = new Parcer();
        String actual = parcer.calc("A=2+5.3").intern();
        String expected = "7.3";
        assertEquals(resVar.get(TextTranslate.INCORRECT_CALCULATION1), expected, actual);//"НЕ корректрое вычисление 1"
        actual = parcer.calc("B=A*3.5").intern();
        assertEquals(resVar.get(TextTranslate.INCORRECT_CALCULATION2), "25.55", actual);
        actual = parcer.calc("B1=B+0.11*-5").intern();
        assertEquals(resVar.get(TextTranslate.INCORRECT_CALCULATION3), "25", actual);
        actual = parcer.calc("B2=A/2-1").intern();
        assertEquals(resVar.get(TextTranslate.INCORRECT_CALCULATION4), "2.65", actual);

        actual = parcer.calc("C=B+(A*2)").intern();
        //actual = parcer.calc("C=b+c1").intern();
        assertEquals(resVar.get(TextTranslate.INCORRECT_CALCULATION5), "40.15",actual);

        actual = parcer.calc("D=((C-0.15)-20)/(7-5)").intern();
        //actual = parcer.calc("D=c22/c23").intern();
        assertEquals(resVar.get(TextTranslate.INCORRECT_CALCULATION6), "10",actual);
    }

    @Test
    public void createVarFormatScalar() throws CalcExeption {
        resVar.setLocale(locale);
        Parcer parcer = new Parcer();
        String actual = parcer.calc("A=2.5").intern();
        String expected = "2.5";
        assertEquals(resVar.get(TextTranslate.INCORRECT_VARIABLE_A), expected, actual);
    }

    @Test
    public void calcVector() throws CalcExeption, IOException {
        resVar.setLocale(locale);
        Parcer parcer = new Parcer();
//        String actual = parcer.calc("N={1.0, 2.0, 3.0}").intern();
//        String expected = "{1.0, 2.0, 3.0}";
//        assertEquals("НЕ кореккстное создание вектора N", expected, actual);
//        actual = parcer.calc("v={5.0, 10.0, 15.0}").intern();
//        assertEquals("НЕ кореккстное создание вектора v", "{5.0, 10.0, 15.0}", actual);
        Var.readVarFile();
        String actual = parcer.calc("N+v*5").intern();
        String expected = "{26, 52, 78}";
        assertEquals(resVar.get(TextTranslate.INCORRECT_FIRST_VECTOR), expected,actual);//"НЕ корректное первое вычисение с вектором"


        actual = parcer.calc("E={2,3}*(d/2)").intern();
        //actual = parcer.calc("E={2,3}*c32").intern();
        assertEquals(resVar.get(TextTranslate.INCORRECT_SECOND_VECTOR), "{10, 15}",actual);




    }

    @Test
    public void createVarFormatVector() throws CalcExeption {
        resVar.setLocale(locale);
        Parcer parcer = new Parcer();
        String actual = parcer.calc("N={1.0, 2.0, 3.0}").intern();
        String expected = "{1, 2, 3}";
        assertEquals(resVar.get(TextTranslate.INCORRECT_VECTOR_N), expected, actual);//НЕ кореккстное создание вектора N
    }

    @Test
    public void calcMatrix() throws CalcExeption, IOException {
        resVar.setLocale(locale);
        Parcer parcer = new Parcer();;
        Var.readVarFile();
        String actual = parcer.calc("m1=N*v").intern();
        String expected = "70";
        assertEquals(resVar.get(TextTranslate.INCORRECT_FIRST_MATRIX), expected,actual);

        actual = parcer.calc("m2=m*d").intern();//m={{1,2,3},{4,5,6},{7,8,9}}
        assertEquals(resVar.get(TextTranslate.INCORRECT_SECOND_MATRIX), "{{10, 20, 30}, " +
                                                                        "{40, 50, 60}, " +
                                                                        "{70, 80, 90}}",actual);

        actual = parcer.calc("m3=m*m2").intern();//m={{1,2,3},{4,5,6},{7,8,9}}
        assertEquals(resVar.get(TextTranslate.INCORRECT_THIRD_MATRIX),  "{{300, 360, 420}, " +
                                                                        "{660, 810, 960}, " +
                                                                        "{1020, 1260, 1500}}", actual);
    }

    @Test
    public void createVarFormatMatrix() throws CalcExeption {
        resVar.setLocale(locale);
        Parcer parcer = new Parcer();
        String actual = parcer.calc("m={{1,2,3},{4,5,6},{7,8,9}}").intern();
        String expected = "{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}";
        assertEquals(resVar.get(TextTranslate.INCORRECT_MATRIX_M), expected, actual);
    }
}