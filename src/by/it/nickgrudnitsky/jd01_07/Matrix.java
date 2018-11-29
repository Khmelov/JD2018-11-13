package by.it.nickgrudnitsky.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i], value.length);
        }
    }

     Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

     Matrix(String strMatrix) {
        Pattern pattern1 = Pattern.compile("[0-9]+,[0-9]+");
        Matcher matcher1 = pattern1.matcher(strMatrix);
        int i1 = 0;
        int rowsCount = 0;
        int columnsCount = 0;
        while (matcher1.find()) {
            rowsCount++;
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(matcher1.group());
            while (matcher.find()){
                columnsCount++;
            }
        }
        matcher1.reset();
        this.value = new double[rowsCount][columnsCount];

        while (matcher1.find()) {
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(matcher1.group());
            double[] array = new double[0];
            int i = 0;
            while (matcher.find()) {
                int last = array.length;
                array = Arrays.copyOf(array, last + 1);
                array[i] = Double.parseDouble(matcher.group());
                i++;
            }
            this.value[i1] = Arrays.copyOf(array, array.length);
            i1++;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i1 = 0; i1 < value.length; i1++) {
            stringBuilder.append("{");
            for (int i = 0; i < value.length; i++) {
                stringBuilder.append(value[i1][i]);
                if (i != value.length - 1) {
                    stringBuilder.append(", ");
                } else {
                    if (i1 != value.length - 1) {
                        stringBuilder.append("}, ");
                    } else {
                        break;
                    }
                }
            }
        }
        stringBuilder.append("}}");
        return new String(stringBuilder);
    }
}
