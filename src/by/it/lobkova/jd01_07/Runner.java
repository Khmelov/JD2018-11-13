package by.it.lobkova.jd01_07;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector;

public class Runner {
    public static void main(String[] args) {
        double[][] matrixB = {
                {-9,1,0},
                {4,1,1},
                {-2,2,-1}
        };

        System.out.println(new Matrix(new Matrix(matrixB)));
    }
}
