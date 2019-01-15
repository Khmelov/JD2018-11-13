package by.it.markelov.jd02_06.Calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorTest {

    @Test
    public void add() throws CalcException {
        Vector vector1 = new Vector("{1, 2}");
        Scalar scalar = new Scalar("1");
        String actual = vector1.add(scalar).toString();
        assertEquals("Operation {1, 2} + 1 is incorrect", "{2.0, 3.0}", actual);

        Vector vector2 = new Vector("{3, 4}");
        actual = vector1.add(vector2).toString();
        assertEquals("Operation {1, 2} + {3, 4} is incorrect", "{4.0, 6.0}", actual);
    }

    @Test
    public void sub() throws CalcException {
        Vector vector1 = new Vector("{3, 4}");
        Scalar scalar = new Scalar("1");
        String actual = vector1.sub(scalar).toString();
        assertEquals("Operation {3, 4} - 1 is incorrect", "{2.0, 3.0}", actual);

        Vector vector2 = new Vector("{1, 2}");
        actual = vector1.sub(vector2).toString();
        assertEquals("Operation {3, 4} - {1, 2} is incorrect", "{2.0, 2.0}", actual);
    }

    @Test
    public void mul() throws CalcException {
        Vector vector1 = new Vector("{3, 4}");
        Scalar scalar = new Scalar("1");
        String actual = vector1.mul(scalar).toString();
        assertEquals("Operation {3, 4} * 1 is incorrect", "{3.0, 4.0}", actual);

        Vector vector2 = new Vector("{1, 2}");
        actual = vector1.mul(vector2).toString();
        assertEquals("Operation {3, 4} * {1, 2} is incorrect", "11.0", actual);

    }

    @Test
    public void div() throws CalcException {
        Vector vector1 = new Vector("{3, 4}");
        Scalar scalar = new Scalar("1");
        String actual = vector1.div(scalar).toString();
        assertEquals("Operation {3, 4} / 1 is incorrect", "{3.0, 4.0}", actual);
    }
}