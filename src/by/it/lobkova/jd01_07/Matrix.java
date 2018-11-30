package by.it.lobkova.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    public static void main(String[] args) {

    }

    public Matrix(double[][] value) {
        super(value);
    }

    public Matrix(Matrix matrix) {
        super(matrix.getValue());
    }

//    public Matrix(String strScalar) {
//        super(Double.valueOf(strScalar));
//    }

    @Override
    public String toString() {
        return Arrays.toString((double[][]) getValue());
    }
}
