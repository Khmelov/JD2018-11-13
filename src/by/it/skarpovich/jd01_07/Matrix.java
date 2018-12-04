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


    Matrix(String value){
        value = value.replaceAll("[{|}]{2,}", "");
        String[] stringValue = value.split("[}][\\s]?,[\\s]?[{]");

        this.value = new double[stringValue.length][];
        for (int i = 0; i < stringValue.length; i++) {

            String[] valueStringNumber = stringValue[i].trim().split(",");
            double[] tempArr = new double[valueStringNumber.length];

            for (int j = 0; j < valueStringNumber.length; j++) {
                tempArr[j] = Double.parseDouble(valueStringNumber[j]);
                this.value[i] = tempArr;
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


