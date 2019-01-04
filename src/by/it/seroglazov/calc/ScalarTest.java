package by.it.seroglazov.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScalarTest {

    @Test
    public void Constructor() {
        Scalar s1 = new Scalar(-23.16);
        Scalar s2 = new Scalar("-7.8534");
        Scalar other = new Scalar(123456);
        Scalar s3 = new Scalar(other);
        assertEquals("-23.16", s1.toString());
        assertEquals("-7.8534", s2.toString());
        assertEquals("123456.0", s3.toString());
    }

    @Test
    public void add() throws CalcException {
        Scalar s1 = new Scalar(3.2);
        Scalar s2 = new Scalar(16.8);
        Scalar s3 = new Scalar(-20.8);
        Scalar resA = (Scalar) s1.add(s2);
        Scalar resB = (Scalar) s2.add(s3);
        assertEquals("20.0", resA.toString());
        assertEquals("-4.0", resB.toString());
    }

    @Test
    public void sub() throws CalcException {
        Var s1 = new Scalar(10.22);
        Var s2 = new Scalar(12.4);
        Var s3 = new Scalar(-13.2);
        Var resA = s1.sub(s2);
        Var resB = s1.sub(s3);
        assertEquals("-2.1799999999999997", resA.toString());
        assertEquals("23.42", resB.toString());

    }

    @Test
    public void mul() throws CalcException {
        Var s1 = new Scalar(2.2);
        Var s2 = new Scalar(-15);
        Var res = s1.mul(s2);
        assertEquals("-33.0", res.toString());
    }

    @Test(expected = CalcException.class)
    public void divByZero() throws CalcException {
        Var s1 = new Scalar(156);
        Var zero = new Scalar(0);
        Var res = s1.div(zero);
        fail();
    }

    @Test
    public void div() throws CalcException {
        Var s1 = new Scalar(156);
        Var s2 = new Scalar(12);
        Var res = s1.div(s2);
        assertEquals("13.0", res.toString());
    }
}