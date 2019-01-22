package by.it.karnilava.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScalarParserTest {


    @Test
    public void createScalar() throws CalcException {
        Var var = Var.createVar("4");
        String res = var.toString();

        assertEquals("4.0", res);
    }

    @Test
    public void calcScalarAddTest() throws CalcException {

        Parser parser = new Parser();
        String res = parser.calc("A=2+5.3");
        assertEquals("7.3", res);

    }

    @Test
    public void calcScalarSubTest() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("136-6");
        assertEquals("130.0", res);


    }

    @Test
    public void calcScalarSubNegativeTest() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("-136+6");
        assertEquals("-130.0", res);


    }

    @Test
    public void calcScalarMulTest() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("A=-3*5");
        assertEquals("-15.0", res);

    }

    @Test
    public void calcScalarDivTest() throws CalcException {
        Parser parser = new Parser();
        String res = parser.calc("A=-10/5");
        assertEquals("-2.0", res);

    }

    @Test
    public void calcScalarNullDivTest() {
        Parser parser = new Parser();
        String res;
        try {
            res = parser.calc("A=-10/0");
        } catch (CalcException e) {
            res = e.getMessage();
        }
        assertEquals(SwitchLanguages.rb.getString("ERROR")+" "+SwitchLanguages.rb.getString("NullDivision"), res);


    }

}