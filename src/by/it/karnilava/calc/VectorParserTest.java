package by.it.karnilava.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorParserTest {

    @Test
    public void createVector() throws CalcException {
        Var var = Var.createVar("{5,6,7}");
        String res = var.toString();

        assertEquals("{5.0, 6.0, 7.0}", res);
    }

    @Test
    public void addScalar() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("{1,2,3}+4");
        assertEquals("{5.0, 6.0, 7.0}", res);
    }

    @Test
    public void addVector() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("{-1,-2,-3}+{1,2,3}");
        assertEquals("{0.0, 0.0, 0.0}", res);
    }

    @Test
    public void subScalar() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("{1,2,3}-1");
        assertEquals("{0.0, 1.0, 2.0}", res);
    }

    @Test
    public void subVector() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("{-1,-2,-3}-{-9,-8,-7}");
        assertEquals("{8.0, 6.0, 4.0}", res);
    }

    @Test
    public void mulScalar() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("{-1,-2,-3}*4");
        assertEquals("{-4.0, -8.0, -12.0}", res);


    }

    @Test
    public void mulVector() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("{-1,-2,-3}*{-1,-2,-3}");
        assertEquals("14.0", res);


    }

    @Test
    public void mulVectorOtherUnequal() {
        Parser parser = new Parser();
        String res;
        try {
            res = parser.calc("{-1,-2,-3}*{1,2}");
        } catch (CalcException e) {
            res = e.getMessage();
        }
        assertTrue(res.contains("ERROR:"));


    }

    @Test
    public void divScalar() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("{-1,-2,-3}/5");
        assertEquals("{-0.2, -0.4, -0.6}", res);
    }

    @Test
    public void divNull() {
        Parser parser = new Parser();
        String res;
        try {
            res = parser.calc("{-1,-2,-3}/0");
        } catch (CalcException e) {
            res = e.getMessage();
        }
        assertTrue(res.contains( SwitchLanguages.rb.getString("NullDivision")));


    }
}