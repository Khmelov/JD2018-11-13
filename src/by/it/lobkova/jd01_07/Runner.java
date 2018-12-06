package by.it.lobkova.jd01_07;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector;

public class Runner {
    public static void main(String[] args) {
        String matrixB =
                "{{ 1.0, 2.0 },{ 3.0, 4.0 }}"
        ;
Var mat = new Matrix(matrixB);
        System.out.println(mat);

        Var scalar = new Scalar(3.14);
    }
}
