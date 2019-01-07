package by.it.vchernetski.calc;

import by.it._examples_.jd01_11.Generics.Demo;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParcerTest {
    private static Parcer parcer = new Parcer();
    private static String actual;
    private static String expected;

    @Test
    public void calcA() throws Exception {
        actual = parcer.calc("A=2+5.3").intern();
        expected = "7.3";
        assertEquals("Incorrect calc A", expected, actual);
        actual = parcer.calc("B=A*3.5").intern();
        expected = "25.55";
        assertEquals("Incorrect calc B", expected, actual);
        actual = parcer.calc("B1=B+0.11*-5").intern();
        expected = "25.0";
        assertEquals("Incorrect calc B1", expected, actual);
        actual = parcer.calc("B2=A/2-1").intern();
        expected = "2.65";
        assertEquals("Incorrect calc B2", expected, actual);
    }

    @Test
    public void calcB() throws Exception {
        actual = parcer.calc("C=B+(A*2)").intern();
        expected = "40.15";
        assertEquals("Incorrect calc C", expected, actual);
        actual = parcer.calc("D=((C-0.15)-20)/(7-5)").intern();
        expected = "10.0";
        assertEquals("Incorrect calc D", expected, actual);
        actual = parcer.calc("E={2,3}*(D/2)").intern();
        expected = "{10.0, 15.0}";
        assertEquals("Incorrect calc E", expected, actual);
    }

    @Test
    public void scalarCreate() throws Exception {
        actual = parcer.calc("S=2").intern();
        expected = "2.0";
        assertEquals("Incorrect creat S", expected, actual);
    }

    @Test
    public void scalarSumScalar() throws Exception {
        actual = parcer.calc("2+2").intern();
        expected = "4.0";
        assertEquals("Incorrect sum S", expected, actual);
    }

    @Test
    public void scalarMulScalar() throws Exception {
        actual = parcer.calc("2*2").intern();
        expected = "4.0";
        assertEquals("Incorrect mul S", expected, actual);
    }

    @Test
    public void scalarSubScalar() throws Exception {
        actual = parcer.calc("2-2").intern();
        expected = "0.0";
        assertEquals("Incorrect sub S", expected, actual);
    }

    @Test
    public void scalarDivScalar() throws Exception {
        actual = parcer.calc("2/2").intern();
        expected = "1.0";
        assertEquals("Incorrect div S", expected, actual);
    }

    @Test(expected = CalcException.class)
    public void scalarDivNull() throws Exception {
        parcer.calc("2/0");
    }

    @Test
    public void vectorCreate() throws Exception {
        actual = parcer.calc("V={2,3,4}").intern();
        expected = "{2.0, 3.0, 4.0}";
        assertEquals("Incorrect creat V", expected, actual);
    }

    @Test
    public void vectorSumScalar() throws Exception {
        actual = parcer.calc("V={2,3,4}+2").intern();
        expected = "{4.0, 5.0, 6.0}";
        assertEquals("Incorrect sum V", expected, actual);
    }

    @Test
    public void vectorSubScalar() throws Exception {
        actual = parcer.calc("V={2,3,4}-2").intern();
        expected = "{0.0, 1.0, 2.0}";
        assertEquals("Incorrect sub V", expected, actual);
    }

    @Test
    public void vectroMulScalar() throws Exception {
        actual = parcer.calc("V={2,3,4}*2").intern();
        expected = "{4.0, 6.0, 8.0}";
        assertEquals("Incorrect mul V", expected, actual);
    }

    @Test
    public void vectorDivScalar() throws Exception {
        actual = parcer.calc("V={2,3,4}/2").intern();
        expected = "{1.0, 1.5, 2.0}";
        assertEquals("Incorrect div V", expected, actual);
    }

    @Test
    public void vectorMulVector() throws Exception {
        actual = parcer.calc("V={2,4,5}*{2,6,10}").intern();
        expected = "78.0";
        assertEquals("Incorrect mul V", expected, actual);
    }

    @Test
    public void vectorSumVector() throws Exception {
        actual = parcer.calc("V={2,3,4}+{4,7,1}").intern();
        expected = "{6.0, 10.0, 5.0}";
        assertEquals("Incorrect sum V", expected, actual);
    }

    @Test
    public void vectorSubVector() throws Exception {
        actual = parcer.calc("V={2,3,4}-{1,4,3}").intern();
        expected = "{1.0, -1.0, 1.0}";
        assertEquals("Incorrect sum V", expected, actual);
    }

    @Test(expected = CalcException.class)
    public void vectorMulBadVector() throws Exception {
        parcer.calc("{1,2,3}*{1,2}");
    }

    @Test
    public void matrixCreate() throws Exception {
        actual = parcer.calc("M={{2,3},{4,2}}").intern();
        expected = "{{2.0, 3.0}, {4.0, 2.0}}";
        assertEquals("Incorrect creat M",expected,actual);
    }
    @Test
    public void matrixSumScalar() throws Exception {
        actual = parcer.calc("M={{2,3},{4,2}}+2").intern();
        expected = "{{4.0, 5.0}, {6.0, 4.0}}";
        assertEquals("Incorrect sum M",expected,actual);
    }
    @Test
    public void matrixSubScalar() throws Exception {
        actual = parcer.calc("M={{2,3},{4,2}}-2").intern();
        expected = "{{0.0, 1.0}, {2.0, 0.0}}";
        assertEquals("Incorrect sub M",expected,actual);
    }
    @Test
    public void matrixMulScalar() throws Exception {
        actual = parcer.calc("M={{2,3},{4,2}}*2").intern();
        expected = "{{4.0, 6.0}, {8.0, 4.0}}";
        assertEquals("Incorrect mul M",expected,actual);
    }
    @Test
    public void matrixDivScalar() throws Exception {
        actual = parcer.calc("M={{2,3},{4,2}}/2").intern();
        expected = "{{1.0, 1.5}, {2.0, 1.0}}";
        assertEquals("Incorrect div M",expected,actual);
    }
    @Test(expected = CalcException.class)
    public void matrixSumVector() throws CalcException{
        parcer.calc("{{1,2},{1,2}}+{1,2}");
    }
    @Test(expected = CalcException.class)
    public void matrixSubVector() throws CalcException{
        parcer.calc("{{1,2},{1,2}}-{1,2}");
    }
    @Test
    public void matrixMulVector() throws CalcException{
        actual = parcer.calc("{{1,2},{1,2}}*{1,2}").intern();
        expected = "{5.0, 5.0}";
        assertEquals("Inccorect mul M",expected,actual);
    }
    @Test(expected = CalcException.class)
    public void matrixDivVector() throws CalcException{
        parcer.calc("{{1,2},{1,2}}/{1,2}");
    }
    @Test
    public void matrixSumMatrix() throws Exception{
        actual = parcer.calc("{{2,3,4},{2,7,1}}+{{2,7,3},{2,4,7}}").intern();
        expected = "{{4.0, 10.0, 7.0}, {4.0, 11.0, 8.0}}";
        assertEquals("Incorrect sum M",expected,actual);
    }
    @Test
    public void matrixSubMatrix() throws Exception{
        actual = parcer.calc("{{2,3,4},{2,7,1}}-{{2,7,3},{2,4,7}}").intern();
        expected = "{{0.0, -4.0, 1.0}, {0.0, 3.0, -6.0}}";
        assertEquals("Incorrect Sub M",expected,actual);
    }
    @Test
    public void matrixMulMatrix() throws Exception{
        actual = parcer.calc("{{2,3},{2,7}}*{{2,7},{2,4}}").intern();
        expected = "{{10.0, 26.0}, {18.0, 42.0}}";
        assertEquals("Incorrect mul M",expected,actual);
    }
    @Test(expected = CalcException.class)
    public void matrixDivMatrix() throws Exception{
        parcer.calc("{{2,3},{2,7}}/{{2,7},{2,4}}").intern();
    }
}