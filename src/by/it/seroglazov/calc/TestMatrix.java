package by.it.seroglazov.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestMatrix extends TestVector {

    private String mat1 = "{{1, 2, -3}, {1, -1, 8.5}, {-4, 5, 6}, {2.5, 3.5, 0}}";
    private String scal = "2.5";
    private String vec = "{2, -1, 3}";
    private String mat2 = "{{2, 4, 3}, {0, 1, 0}, {7, 2, 2}, {6, 3, 4}}";

    @Test
    public void testCreateMatrix() throws CalcException {
        Parcer parcer = new Parcer();
        parcer.calc("M={{-1.2,23.58, 16}, {0,0, 0.012},{34,-16,-8.55}}");
        String res = parcer.calc("M");
        assertEquals("{{-1.2, 23.58, 16.0}, {0.0, 0.0, 0.012}, {34.0, -16.0, -8.55}}", res);
    }

    @Test
    public void testMatrixAddScalar() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc(mat1 + "+" + scal);
        String wait = "{{3.5, 4.5, -0.5}, {3.5, 1.5, 11.0}, {-1.5, 7.5, 8.5}, {5.0, 6.0, 2.5}}";
        assertEquals(wait, res);
    }

    @Test
    public void testMatrixSubScalar() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc(mat1 + "-" + scal);
        String wait = "{{-1.5, -0.5, -5.5}, {-1.5, -3.5, 6.0}, {-6.5, 2.5, 3.5}, {0.0, 1.0, -2.5}}";
        assertEquals(wait, res);
    }

    @Test
    public void testMatrixMulScalar() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc(mat1 + "*" + scal);
        String wait = "{{2.5, 5.0, -7.5}, {2.5, -2.5, 21.25}, {-10.0, 12.5, 15.0}, {6.25, 8.75, 0.0}}";
        assertEquals(wait, res);
    }

    @Test
    public void testMatrixDivScalar() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc(mat1 + "/" + scal);
        String wait = "{{0.4, 0.8, -1.2}, {0.4, -0.4, 3.4}, {-1.6, 2.0, 2.4}, {1.0, 1.4, 0.0}}";
        assertEquals(wait, res);
    }

    @Test(expected = CalcException.class)
    public void testMatrixAddVector() throws CalcException {
        Parcer parcer = new Parcer();
        parcer.calc(mat1 + "+" + vec);
        fail();
    }

    @Test(expected = CalcException.class)
    public void testMatrixSubVector() throws CalcException {
        Parcer parcer = new Parcer();
        parcer.calc(mat1 + "-" + vec);
        fail();
    }

    @Test(expected = CalcException.class)
    public void testMatrixMulVectorWithWrongSize() throws CalcException {
        Parcer parcer = new Parcer();
        parcer.calc(mat1 + "*{2, -1, 3, 4}");
        fail();
    }

    @Test
    public void testMatrixMulVector() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc(mat1 + "*" + vec);
        assertEquals("{-9.0, 28.5, 5.0, 1.5}", res);
    }

    @Test(expected = CalcException.class)
    public void testMatrixDivVector() throws CalcException {
        Parcer parcer = new Parcer();
        parcer.calc(mat1 + "/" + vec);
        fail();
    }

    @Test
    public void testMatrixAddMatrix() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc(mat1 + "+" + mat2);
        String wait = "{{3.0, 6.0, 0.0}, {1.0, 0.0, 8.5}, {3.0, 7.0, 8.0}, {8.5, 6.5, 4.0}}";
        assertEquals(wait, res);
    }

    @Test(expected = CalcException.class)
    public void testMatrixAddMatrixWithWrongSize() throws CalcException {
        Parcer parcer = new Parcer();
        parcer.calc(mat1 + "+" + "{{1,1,1},{1,1,1},{1,1,1}}");
        fail();
    }

    @Test
    public void testMatrixSubMatrix() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc(mat1 + "-" + mat2);
        String wait = "{{-1.0, -2.0, -6.0}, {1.0, -2.0, 8.5}, {-11.0, 3.0, 4.0}, {-3.5, 0.5, -4.0}}";
        assertEquals(wait, res);
    }

    @Test(expected = CalcException.class)
    public void testMatrixSubMatrixWithWrongSize() throws CalcException {
        Parcer parcer = new Parcer();
        parcer.calc(mat1 + "-" + "{{1,1,1},{1,1,1},{1,1,1}}");
        fail();
    }

    @Test
    public void testMatrixMulMatrix() throws CalcException {
        Parcer parcer = new Parcer();
        String res = parcer.calc("{{2, -1, 8}, {-6, 2, 1}}*{{1, -2}, {3, 4}, {0, 5}}");
        String wait = "{{-1.0, 32.0}, {0.0, 25.0}}";
        assertEquals(wait, res);
    }

    @Test(expected = CalcException.class)
    public void testMatrixMulMatrixWithWrongSize() throws CalcException {
        Parcer parcer = new Parcer();
        parcer.calc(mat1 + "*" + "{{1,1,1},{1,1,1}}");
        fail();
    }
}


























