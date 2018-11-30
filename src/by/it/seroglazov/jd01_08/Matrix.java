package by.it.seroglazov.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;
    private static String ErrMessPatternNotFound = "Exception: Ошибка ввода матрицы. Не найден шаблон: {{1,2,...},{3,4,...},...}";
    //private static String ErrMessSecondPatternNotFound = "Exception: Ошибка ввода матрицы. Не найден шаблон: {{строка1}, {строка2}, ...}.";
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

        String strWithoutWhiteSpaces = str.replaceAll("\\s", "");
        if (!strWithoutWhiteSpaces.matches("[{]([{][^{}]+[}],)*[{][^{}]+[}][}]")) { // Pattern to string like {{2.0,3,9},{4.75,6,0},{1e2,0xA,010}}
            System.out.println(ErrMessPatternNotFound);
            //TODO Raise exception instead of println
        }
        Pattern extCurlyBrackets = Pattern.compile("[{](.*)[}]"); // Find all inside external curly brackets
        Matcher m1 = extCurlyBrackets.matcher(strWithoutWhiteSpaces);
        if (m1.find()) {
            Pattern intCurlyBrackets = Pattern.compile("[{]([^}]*)[}]"); // Find all internal curly brackets
            Matcher m2 = intCurlyBrackets.matcher(m1.group(1));
            int counter = 0;
            while (m2.find()) counter++; // First step - simple counting internal {}
            if (counter == 0) {
                System.out.println(ErrMessPatternNotFound);
                //TODO Raise exception instead of println
            }
            value = new double[counter][];
            m2.reset();
            int i = 0;
            while (m2.find()) {
                String[] strRows = m2.group(1).split(",");
                value[i] = new double[strRows.length];
                for (int j = 0; j < strRows.length; j++) {
                    value[i][j] = Double.parseDouble(strRows[j]);
                    //TODO exception check if not double
                }
                i++;
            }
            // Now check is our matrix a rectangle?
            int len = value[0].length; // At this point value has at least one element
            for (double[] v : value) {
                if (v.length != len) {
                    System.out.println(ErrMessDifferentColsCount);
                    //TODO Raise exception instead of println
                    break;
                }
            }
        } else {
            System.out.println(ErrMessPatternNotFound);
            //TODO Raise exception instead of println
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


















