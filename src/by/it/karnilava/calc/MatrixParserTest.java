package by.it.karnilava.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixParserTest {

    @Test
    public void createMatrix() throws CalcException {
        Var var = Var.createVar("{{5,6,7},{5,6,7}}");
        String res = var.toString();

        assertEquals("{{5.0, 6.0, 7.0}, {5.0, 6.0, 7.0}}", res);
    }

    @Test
    public void addScalar() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("{{1,2,3},{1,2,3}}+4");
        assertEquals("{{5.0, 6.0, 7.0}, {5.0, 6.0, 7.0}}", res);
    }

    @Test
    public void addMatrix() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("{{4.0, 5.0, 6.0}, {4.0, 5.0, 6.0}}+{{4.0, 5.0, 6.0}, {4.0, 5.0, 6.0}}");
        assertEquals("{{8.0, 10.0, 12.0}, {8.0, 10.0, 12.0}}", res);
    }

    @Test
    public void subScalar() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("{{1,2,3},{1,2,3}}-4");
        assertEquals("{{-3.0, -2.0, -1.0}, {-3.0, -2.0, -1.0}}", res);
    }

    @Test
    public void subMatrix() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("{{4.0, 5.0, 6.0}, {4.0, 5.0, 6.0}}-{{4.0, 5.0, 6.0}, {4.0, 5.0, 6.0}}");
        assertEquals("{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}", res);
    }


    @Test
    public void mulScalar() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("{{1,2,3},{1,2,3}}*4");
        assertEquals("{{4.0, 8.0, 12.0}, {4.0, 8.0, 12.0}}", res);
    }

    @Test
    public void mulVector() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("{{1,2,3},{1,2,3}}*{5,10,15}");
        assertEquals("{70.0, 70.0}", res);
    }

    @Test
    public void mulMatrix() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("{{1,2,3},{1,2,3}}*{{5,10},{3,9},{2,4}}");
        assertEquals("{{17.0, 40.0}, {17.0, 40.0}}", res);
    }


}