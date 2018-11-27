package by.it.seroglazov.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;
    private static String ErrMessPatternNotFound = "Exception: Ошибка ввода матрицы. Не найден шаблон: { элементы матрицы }.";
    private static String ErrMessSecondPatternNotFound = "Exception: Ошибка ввода матрицы. Не найден шаблон: {{строка1}, {строка2}, ...}.";
    private static String ErrMessDifferentColsCount = "Exception: Количество столбцов в каждой строке матрицы должно быть задано одинаковым.";

    Matrix(double[][] value) {
        if (value.length == 0) {
            this.value = new double[0][];
        } else {
            int cols = value[0].length;
            for (double[] aValue : value) { // Check: matrix should be rectangle
                if (aValue.length != cols) {
                    // Call exception
                }
            }
            this.value = new double[value.length][cols];
            for (int i = 0; i < value.length; i++) {
                System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
            }
        }
    }

    Matrix(Matrix anMatr) {
        if (anMatr.value.length == 0) {
            value = new double[0][0];
        } else {
            value = new double[anMatr.value.length][anMatr.value[0].length];
            for (int i = 0; i < anMatr.value.length; i++) {
                System.arraycopy(anMatr.value[i], 0, value[i], 0, anMatr.value[i].length);
            }
        }
    }

    Matrix(String str) {
        Matcher m1 = Pattern.compile("\\{(.*)\\}").matcher(str); // Find global { }
        if (m1.find()) {
            String[] strRows =  m1.group(1).replaceAll(" ", "").split(",");
            for (int i = 0; i < strRows.length; i++) {
                Pattern p = Pattern.compile("\\{([^\\}]*)\\}");
                Matcher m2 = p.matcher(strRows[i]);
            }

            // NOT FINISHED, DON'T TRY TO UNDERSTAND, I AM REBUILDING ALL THIS METHOD



            Pattern p = Pattern.compile("\\{([^\\}]*)\\}");
            Matcher m2 = p.matcher(m1.group(1)); // Find internal {}, {}, {}
            // Check if m2 contains any symbols outside the {},
            String testSym = m1.group(1);
            testSym = testSym.replaceAll(p.toString(), "");
            System.out.println(testSym);

            int counter = 0;
            while (m2.find()) counter++; // First step - simple counting internal {}
            if (counter == 0) {
                System.out.println(ErrMessSecondPatternNotFound);
                // Raise exception
            }
                value = new double[counter][];
            m2.reset();
            int i = 0;
            while (m2.find()) { // For each {1, 2, 3, ...} we split it into the value[i][...]
                String[] sArr = m2.group(1).replace(" ", "").split(",");
                value[i] = new double[sArr.length];
                for (int j = 0; j < sArr.length; j++) {
                    value[i][j] = Double.parseDouble(sArr[j]);
                }
                i++;
            }
            // Now check is our matrix rectangle?
            if (value.length > 0) {
                int len = value[0].length;
                for (double[] v : value) {
                    if (v.length != len) {
                        System.out.println(ErrMessDifferentColsCount);
                        // Raise exception
                    }
                }
            }

        } else {
            System.out.println(ErrMessPatternNotFound);
            // Raise exception
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            sb.append(value[i][0]);
            for (int j = 1; j < value[0].length; j++) {
                sb.append(", ");
                sb.append(String.valueOf(value[i][j]));
            }
            if (i == value.length - 1) sb.append("}");
            else sb.append("}, ");
        }
        sb.append("}");
        return sb.toString();
    }
}


















