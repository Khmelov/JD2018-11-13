package by.it.skarpovich.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value.length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.value = value;
            }
        }
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {

        Matcher matcher = Pattern.compile("\\{(.*)\\}").matcher(strMatrix);
        while (matcher.find()) {
            String[] strMatrixArray = matcher.group().replace(" ", "").split(",");
            value = new double[strMatrixArray.length][strMatrixArray.length];
            for (int i = 0; i < strMatrixArray.length; i++) {
                for (int j = 0; j <strMatrixArray.length; j++) {
                    value[i][j] = Double.parseDouble(strMatrixArray[i]);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        int row = 0;
        int i, j;
        for (i = 0; i < 2; i++) {
            sb.append("{");
            for (j = 0; j < 2; j++) {
                sb.append(value[i][j]);
                if (j < value.length - 1) {
                    sb.append(",");
                }
            }
            sb.append("}");
            row++;
            if (row - value.length != 0) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}


