package by.it.markelov.jd02_06.Calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    @Test
    public void toStringVariable() {
        Scalar scalar = new Scalar("1");
        String expected = "1.0";
        String actual = scalar.toString();
        assertEquals("Operation with Scalar is incorrect", expected, actual);

        Vector vector = new Vector("{1, 2}");
        expected = "{1.0, 2.0}";
        actual = vector.toString();
        assertEquals("Operation with Vector is incorrect", expected, actual);

        Matrix matrix = new Matrix("{{1, 2}, {3, 4}}");
        expected = "{{1.0, 2.0}, {3.0, 4.0}}";
        actual = matrix.toString();
        assertEquals("Operation with Matrix is incorrect", expected, actual);
    }

    @Test
    public void add() throws CalcException {
        Matrix matrix1 = new Matrix("{{1, 2}, {3, 4}}");
        Scalar scalar = new Scalar("1");
        String actual = matrix1.add(scalar).toString();
        assertEquals("Operation {{1, 2}, {3, 4}} + 1 is incorrect", "{{2.0, 3.0}, {4.0, 5.0}}", actual);

        Matrix matrix2 = new Matrix("{{5, 6}, {7, 8}}");
        actual = matrix1.add(matrix2).toString();
        assertEquals("Operation {{1, 2}, {3, 4}} + {{5, 6}, {7, 8}} is incorrect", "{{6.0, 8.0}, {10.0, 12.0}}", actual);
    }

    @Test
    public void sub() throws CalcException {
        Matrix matrix1 = new Matrix("{{5, 6}, {7, 8}}");
        Scalar scalar = new Scalar("1");
        String actual = matrix1.sub(scalar).toString();
        assertEquals("Operation {{5, 6}, {7, 8}} - 1 is incorrect", "{{4.0, 5.0}, {6.0, 7.0}}", actual);

        Matrix matrix2 = new Matrix("{{1, 2}, {3, 4}}");
        actual = matrix1.sub(matrix2).toString();
        assertEquals("Operation {{5, 6}, {7, 8}} - {{1, 2}, {3, 4}} is incorrect", "{{4.0, 4.0}, {4.0, 4.0}}", actual);
    }

    @Test
    public void mul() throws CalcException {
        Matrix matrix1 = new Matrix("{{1, 2}, {3, 4}}");
        Scalar scalar = new Scalar("1");
        String actual = matrix1.mul(scalar).toString();
        assertEquals("Operation {{1, 2}, {3, 4}} * 1 is incorrect", "{{1.0, 2.0}, {3.0, 4.0}}", actual);


        Vector vector = new Vector("{1,1}");
        actual = matrix1.mul(vector).toString();
        assertEquals("Operation {{1, 2}, {3, 4}} * {1,1} is incorrect", "{3.0, 7.0}", actual);

        Matrix matrix2 = new Matrix("{{5, 6}, {7, 8}}");
        actual = matrix1.mul(matrix2).toString();
        assertEquals("Operation {{1, 2}, {3, 4}} * {{5, 6}, {7, 8}} is incorrect", "{{19.0, 22.0}, {43.0, 50.0}}", actual);
    }

    @Test
    public void div() throws CalcException {
        Matrix matrix1 = new Matrix("{{1, 2}, {3, 4}}");
        Scalar scalar = new Scalar("1");
        String actual = matrix1.div(scalar).toString();
        assertEquals("Operation {{1, 2}, {3, 4}} / 1 is incorrect", "{{1.0, 2.0}, {3.0, 4.0}}", actual);
    }
}