package by.it.skarpovich.calc;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static org.junit.Assert.*;

public class TestVector {

    @Rule  // Fixture для теста (+ @Before, @After fixtures in ...)
    public TestWatcher watcher = new TestWatcher() {

        @Override
        protected void starting(Description description) {
            //new Object(){}.getClass().getEnclosingMethod().getName();
            System.out.println("Test Started");
        }

        @Override
        protected void finished(Description description) {
            System.out.println("Test Completed");
            System.out.println();
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("TEST FAILED!!!");
        }
    };



    @Test
    public void add() throws CalcException {
        Vector vector1 = new Vector("{1, 1}");
        Scalar scalar = new Scalar("1");
        String actual = vector1.add(scalar).toString();
        assertEquals("Operation {1, 1} + 1 is incorrect", "{2.0, 2.0}", actual);

        Vector vector2 = new Vector("{1, 1}");
        actual = vector1.add(vector2).toString();
        assertEquals("Operation {1, 1} + {1, 1} is incorrect", "{2.0, 2.0}", actual);
    }

    @Test
    public void sub() throws CalcException {
        Vector vector1 = new Vector("{1, 1}");
        Scalar scalar = new Scalar("1");
        String actual = vector1.sub(scalar).toString();
        assertEquals("Operation {1, 1} - 1 is incorrect", "{0.0, 0.0}", actual);

        Vector vector2 = new Vector("{1, 1}");
        actual = vector1.sub(vector2).toString();
        assertEquals("Operation {1, 1} - {1, 1} is incorrect", "{0.0, 0.0}", actual);
    }

    @Test
    public void mul() throws CalcException {
        Vector vector1 = new Vector("{1, 1}");
        Scalar scalar = new Scalar("1");
        String actual = vector1.mul(scalar).toString();
        assertEquals("Operation {1, 1} * 1 is incorrect", "{1.0, 1.0}", actual);

        Vector vector2 = new Vector("{1, 1}");
        actual = vector1.mul(vector2).toString();
        assertEquals("Operation {1, 1} * {1, 1} is incorrect", "2.0", actual);

    }

    @Test
    public void div() throws CalcException {
        Vector vector1 = new Vector("{1, 1}");
        Scalar scalar = new Scalar("1");
        String actual = vector1.div(scalar).toString();
        assertEquals("Operation {1, 1} / 1 is incorrect", "{1.0, 1.0}", actual);
    }
}