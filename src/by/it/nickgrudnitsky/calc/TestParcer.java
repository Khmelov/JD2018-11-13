package by.it.nickgrudnitsky.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestParcer {
    private Parcer parcer = new Parcer();
    private String res = null;
    private String expected;

    @Test
    public void testA() throws CalcException {
        res = parcer.calc("A=2+5.3").toString();
        expected = "7.3";
        assertEquals("Incorrect result", expected, res);
        res = parcer.calc("B=A*3.5").toString();
        expected = "25.55";
        assertEquals("Incorrect result", expected, res);
        res = parcer.calc("B1=B+0.11*-5").toString();
        expected = "25.0";
        assertEquals("Incorrect result", expected, res);
        res = parcer.calc("B2=A/2-1").toString();
        expected = "2.65";
        assertEquals("Incorrect result", expected, res);
    }

    @Test
    public void testB() throws CalcException {
        res = parcer.calc("C=B+(A*2)").toString();
        expected = "40.15";
        assertEquals("Incorrect result", expected, res);
        res = parcer.calc("D=((C-0.15)-20)/(7-5)").toString();
        expected = "10.0";
        assertEquals("Incorrect result", expected, res);
        res = parcer.calc("E={2,3}*(D/2)").toString();
        expected = "{10.0, 15.0}";
        assertEquals("Incorrect result", expected, res);
    }

    @Test
    public void scalarCreate() throws Exception {
        res = parcer.calc("S=2").toString();
        expected = "2.0";
        assertEquals("Incorrect creat S", expected, res);
    }

    @Test
    public void scalarSumScalar() throws Exception {
        res = parcer.calc("2+2").toString();
        expected = "4.0";
        assertEquals("Incorrect sum S", expected, res);
    }

    @Test
    public void scalarMulScalar() throws Exception {
        res = parcer.calc("2*2").toString();
        expected = "4.0";
        assertEquals("Incorrect mul S", expected, res);
    }

    @Test
    public void scalarSubScalar() throws Exception {
        res = parcer.calc("2-2").toString();
        expected = "0.0";
        assertEquals("Incorrect sub S", expected, res);
    }

    @Test
    public void scalarDivScalar() throws Exception {
        res = parcer.calc("2/2").toString();
        expected = "1.0";
        assertEquals("Incorrect div S", expected, res);
    }

    @Test(expected = CalcException.class)
    public void scalarDivNull() throws Exception {
        parcer.calc("2/0");
    }

    @Test
    public void vectorCreate() throws Exception {
        res = parcer.calc("V={2,3,4}").toString();
        expected = "{2.0, 3.0, 4.0}";
        assertEquals("Incorrect creat V", expected, res);
    }

    @Test
    public void vectorSumScalar() throws Exception {
        res = parcer.calc("V={2,3,4}+2").toString();
        expected = "{4.0, 5.0, 6.0}";
        assertEquals("Incorrect sum V", expected, res);
    }

    @Test
    public void vectorSubScalar() throws Exception {
        res = parcer.calc("V={2,3,4}-2").toString();
        expected = "{0.0, 1.0, 2.0}";
        assertEquals("Incorrect sub V", expected, res);
    }

    @Test
    public void vectroMulScalar() throws Exception {
        res = parcer.calc("V={2,3,4}*2").toString();
        expected = "{4.0, 6.0, 8.0}";
        assertEquals("Incorrect mul V", expected, res);
    }

    @Test
    public void vectorDivScalar() throws Exception {
        res = parcer.calc("V={2,3,4}/2").toString();
        expected = "{1.0, 1.5, 2.0}";
        assertEquals("Incorrect div V", expected, res);
    }

    @Test
    public void vectorMulVector() throws Exception {
        res = parcer.calc("V={2,4,5}*{2,6,10}").toString();
        expected = "78.0";
        assertEquals("Incorrect mul V", expected, res);
    }

    @Test
    public void vectorSumVector() throws Exception {
        res = parcer.calc("V={2,3,4}+{4,7,1}").toString();
        expected = "{6.0, 10.0, 5.0}";
        assertEquals("Incorrect sum V", expected, res);
    }

    @Test
    public void vectorSubVector() throws Exception {
        res = parcer.calc("V={2,3,4}-{1,4,3}").toString();
        expected = "{1.0, -1.0, 1.0}";
        assertEquals("Incorrect sum V", expected, res);
    }

    @Test(expected = CalcException.class)
    public void vectorMulBadVector() throws Exception {
        parcer.calc("{1,2,3}*{1,2}");
    }

    @Test
    public void matrixCreate() throws Exception {
        res = parcer.calc("M={{2,3},{4,2}}").toString();
        expected = "{{2.0, 3.0}, {4.0, 2.0}}";
        assertEquals("Incorrect creat M",expected,res);
    }
    @Test
    public void matrixSumScalar() throws Exception {
        res = parcer.calc("M={{2,3},{4,2}}+2").toString();
        expected = "{{4.0, 5.0}, {6.0, 4.0}}";
        assertEquals("Incorrect sum M",expected,res);
    }
    @Test
    public void matrixSubScalar() throws Exception {
        res = parcer.calc("M={{2,3},{4,2}}-2").toString();
        expected = "{{0.0, 1.0}, {2.0, 0.0}}";
        assertEquals("Incorrect sub M",expected,res);
    }
    @Test
    public void matrixMulScalar() throws Exception {
        res = parcer.calc("M={{2,3},{4,2}}*2").toString();
        expected = "{{4.0, 6.0}, {8.0, 4.0}}";
        assertEquals("Incorrect mul M",expected,res);
    }
    @Test
    public void matrixDivScalar() throws Exception {
        res = parcer.calc("M={{2,3},{4,2}}/2").toString();
        expected = "{{1.0, 1.5}, {2.0, 1.0}}";
        assertEquals("Incorrect div M",expected,res);
    }
    @Test(expected = CalcException.class)
    public void matrixSumVector() throws CalcException {
        parcer.calc("{{1,2},{1,2}}+{1,2}");
    }
    @Test(expected = CalcException.class)
    public void matrixSubVector() throws CalcException {
        parcer.calc("{{1,2},{1,2}}-{1,2}");
    }
    @Test
    public void matrixMulVector() throws CalcException {
        res = parcer.calc("{{1,2},{1,2}}*{1,2}").toString();
        expected = "{5.0, 5.0}";
        assertEquals("Inccorect mul M",expected,res);
    }
    @Test(expected = CalcException.class)
    public void matrixDivVector() throws CalcException {
        parcer.calc("{{1,2},{1,2}}/{1,2}");
    }
    @Test
    public void matrixSumMatrix() throws Exception{
        res = parcer.calc("{{2,3},{2,7}}+{{2,7},{2,4}}").toString();
        expected = "{{4.0, 10.0}, {4.0, 11.0}}";
        assertEquals("Incorrect sum M",expected,res);
    }
    @Test
    public void matrixSubMatrix() throws Exception{
        res = parcer.calc("{{2,3},{2,7}}-{{2,7},{2,4}}").toString();
        expected = "{{0.0, -4.0}, {0.0, 3.0}}";
        assertEquals("Incorrect Sub M",expected,res);
    }
    @Test
    public void matrixMulMatrix() throws Exception{
        res = parcer.calc("{{2,3},{2,7}}*{{2,7},{2,4}}").toString();
        expected = "{{10.0, 26.0}, {18.0, 42.0}}";
        assertEquals("Incorrect mul M",expected,res);
    }
    @Test(expected = CalcException.class)
    public void matrixDivMatrix() throws Exception{
        res = parcer.calc("{{2,3},{2,7}}/{{2,7},{2,4}}").toString();
        expected = "{{10,26},{18,42}}";
        assertEquals("Incorect", expected, res);
    }
}
