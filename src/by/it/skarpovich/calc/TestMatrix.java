package by.it.skarpovich.calc;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import static org.junit.Assert.*;

public class TestMatrix {
//    @Before
//    public void before() {
//        System.out.println("before");
//    }
//    @After
//    public void after() {
//        System.out.println("after");
//    }

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
        System.out.println("method " + new Object(){}.getClass().getEnclosingMethod().getName() + "()" + " is being tested...");

        Matrix matrix1 = new Matrix("{{1, 2}, {3, 4}}");
        Matrix matrix2 = new Matrix("{{5, 6}, {7, 8}}");
        Scalar scalar = new Scalar("1");
        String actualMatrix = matrix1.add(matrix2).toString();
        String actualScalar = matrix1.add(scalar).toString();
        assertEquals("Operation {{1, 2}, {3, 4}} + {{5, 6}, {7, 8}} is incorrect", "{{6.0, 8.0}, {10.0, 12.0}}", actualMatrix);
        assertEquals("Operation {{1, 2}, {3, 4}} + 1 is incorrect", "{{2.0, 3.0}, {4.0, 5.0}}", actualScalar);
    }

    @Test
    public void sub() throws CalcException {
        System.out.println("method " + new Object(){}.getClass().getEnclosingMethod().getName() + "()" + " is being tested...");

        Matrix matrix1 = new Matrix("{{5, 6}, {7, 8}}");
        Matrix matrix2 = new Matrix("{{1, 2}, {3, 4}}");
        Scalar scalar = new Scalar("1");
        String actualMatrix = matrix1.sub(matrix2).toString();
        String actualScalar = matrix1.sub(scalar).toString();
        assertEquals("Operation {{5, 6}, {7, 8}} - {{1, 2}, {3, 4}} is incorrect", "{{4.0, 4.0}, {4.0, 4.0}}", actualMatrix);
        assertEquals("Operation {{5, 6}, {7, 8}} - 1 is incorrect", "{{4.0, 5.0}, {6.0, 7.0}}", actualScalar);
    }

    @Test
    public void mul() throws CalcException {
        System.out.println("method " + new Object(){}.getClass().getEnclosingMethod().getName() + "()" + " is being tested...");

        Matrix matrix1 = new Matrix("{{1, 2}, {3, 4}}");
        Matrix matrix2 = new Matrix("{{5, 6}, {7, 8}}");
        Scalar scalar = new Scalar("1");
        Vector vector = new Vector("{1,1}");
        String actualMatrix = matrix1.mul(matrix2).toString();
        String actualScalar = matrix1.mul(scalar).toString();
        String actualVector = matrix1.mul(vector).toString();

        assertEquals("Operation {{1, 2}, {3, 4}} * {{5, 6}, {7, 8}} is incorrect", "{{19.0, 22.0}, {43.0, 50.0}}", actualMatrix);
        assertEquals("Operation {{1, 2}, {3, 4}} * 1 is incorrect", "{{1.0, 2.0}, {3.0, 4.0}}", actualScalar);
        assertEquals("Operation {{1, 2}, {3, 4}} * {1,1} is incorrect", "{3.0, 7.0}", actualVector);
    }

    @Test
    public void toStringTest() {
        System.out.println("method " + new Object(){}.getClass().getEnclosingMethod().getName() + "()" + " is being tested...");
        Scalar scalar = new Scalar("1");
        Vector vector = new Vector("{1, 2}");
        Matrix matrix = new Matrix("{{1, 2}, {3, 4}}");
        String expectedScalar ="1.0";
        String expectedVector ="{1.0, 2.0}";
        String expectedMatrix ="{{1.0, 2.0}, {3.0, 4.0}}";
        String actualScalar = scalar.toString();
        String actualVector= vector.toString();
        String actualMatrix = matrix.toString();

        assertEquals("Operation Scalar toString is incorrect", expectedScalar, actualScalar);
        assertEquals("Operation Vector toString is incorrect", expectedVector, actualVector);
        assertEquals("Operation Matrix toString is incorrect", expectedMatrix, actualMatrix);
    }
}
