package by.it.karnilava.calc;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        strMatrix.trim();
        String strMatrix1 = strMatrix.substring(1, strMatrix.length() - 1);
        String[] strArr = strMatrix1.split("},");

        double[][] res = new double[strArr.length][strArr[0].split(",").length];
            for (int j = 0; j < strArr.length; j++) {
                strArr[j] = strArr[j].trim().replaceAll("[{}]", "");
                String[] mas = strArr[j].split(",");
                for (int i = 0; i < mas.length; i++) {
                    res[j][i] = Double.parseDouble(mas[i]);
                }
            this.value = res;
        }


    }

    public Var add(Var other) throws CalcException {

        if (other instanceof Scalar) {
            // double[][] res = new double[this.value[0].length][this.value.length];
            double[][] res = new double[this.value.length][this.value[0].length];
            double[][] res1 = this.value;
            for (int i = 0; i < res1.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] = res1[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }

        if (other instanceof Matrix) {
            double[][] res = new double[this.value.length][this.value[0].length];
            double[][] res1 = this.value;
            double[][] mat = ((Matrix) other).value;
            if (res1.length != mat.length || res1[0].length != mat[0].length) {
                return super.add(other);
            }

            for (int i = 0; i < res1.length; i++) {
                for (int j = 0; j < res1[0].length; j++) {
                    res[i][j] = res1[i][j] + mat[i][j];
                }


            }
            return new Matrix(res);
        }

        return super.add(other);
    }

    public Var sub(Var other) throws CalcException {

        if (other instanceof Scalar) {
            // double[][] res = new double[this.value[0].length][this.value.length];
            double[][] res = new double[this.value.length][this.value[0].length];
            double[][] res1 = this.value;
            for (int i = 0; i < res1.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] = res1[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }

        if (other instanceof Matrix) {
            double[][] res = new double[this.value.length][this.value[0].length];
            double[][] res1 = this.value;
            double[][] mat = ((Matrix) other).value;
            if (res1.length == mat.length && res1[0].length == mat[0].length) {
                for (int i = 0; i < res1.length; i++) {
                    for (int j = 0; j < res1[0].length; j++) {
                        res[i][j] = res1[i][j] - mat[i][j];
                    }
                }
                return new Matrix(res);
            }
            else {
                return super.sub(other);
            }

        }

        return super.sub(other);
    }

    public Var mul(Var other) throws CalcException {

        if (other instanceof Scalar) {
            // double[][] res = new double[this.value[0].length][this.value.length];
            double[][] res = new double[this.value.length][this.value[0].length];
            double[][] res1 = this.value;
            for (int i = 0; i < res1.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] = res1[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }

        if (other instanceof Matrix) {

            double[][] res1 = this.value;
            double[][] mat = ((Matrix) other).value;
            double[][] res = new double[res1.length][mat[0].length];


            if (res1.length == mat[0].length) {
                for (int i = 0; i < res1.length; i++) {
                    for (int j = 0; j < mat[0].length; j++) {
                        for (int k = 0; k < mat.length; k++) {
                            res[i][j] = res[i][j] + res1[i][k] * mat[k][j];

                        }
                    }
                }
                return new Matrix(res);
            }
            return super.mul(other);
        }


        if (other instanceof Vector) {


            double[][] matri = this.value;
            double[] vect = ((Vector) other).getValue();
            double[] z = new double[matri.length];


            if (matri[0].length == vect.length) {
                for (int i = 0; i < matri.length; i++) {
                    for (int j = 0; j < vect.length; j++) {
                        z[i] = z[i] + matri[i][j] * vect[j];
                    }
                }
                return new Vector(z);
            }
            return super.mul(other);
        }
        return super.mul(other);
    }


    public String toString() {

        String s = Arrays.deepToString(value).replace("[", "{").replace("]", "}");

        return s;

    }
}



