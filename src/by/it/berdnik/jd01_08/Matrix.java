package by.it.berdnik.jd01_08;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    public Matrix(String strMatrix) {
        super();
    }

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value.length);
        }
    }

    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] add = new double[this.value[0].length][this.value.length];
            double[][] add1 = this.value;
            for (int i = 0; i < add1.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    add[i][j] = add1[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(add);
        }
        if (other instanceof Matrix) {
            double[][] add = new double[this.value[0].length][this.value.length];
            double[][] add2 = this.value;
            double[][] mat = ((Matrix) other).value;
            if (add2.length == mat.length && add2[0].length == mat[0].length) {
                for (int i = 0; i < add2[0].length; i++) {
                    for (int j = 0; j < add2.length; j++) {
                        add[i][j] = add2[i][j] + mat[i][j];
                    }
                }
                return new Matrix(add);
            }
        }
        return super.add(other);
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public String toString() {
        String s = Arrays.deepToString(value).replace("[", "{").replace("]", "}");
        return s.toString();
    }

}
