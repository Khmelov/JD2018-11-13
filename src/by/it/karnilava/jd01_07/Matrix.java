package by.it.karnilava.jd01_07;

import java.util.Arrays;

class Matrix extends AbstractVar {
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

        double[][] res = new double[strArr[0].split(",").length][strArr.length];
        for (int j = 0; j < strArr.length; j++) {
            strArr[j] = strArr[j].trim().replaceAll("[{}]", "");
            String[] mas = strArr[j].split(",");
            for (int i = 0; i < mas.length; i++) {
                res[j][i] = Double.parseDouble(mas[i]);
            }
            this.value = res;
        }


    }

    public String toString() {

        String s = Arrays.deepToString(value).replace("[", "{").replace("]", "}");

        return s.toString();

    }


}

