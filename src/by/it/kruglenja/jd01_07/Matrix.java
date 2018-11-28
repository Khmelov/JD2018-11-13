package by.it.kruglenja.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double value[][];

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    Matrix(Matrix matrix2) {
        this.value = new double[matrix2.value.length][matrix2.value[0].length];

        for (int i = 0; i < value.length; i++) {
            System.arraycopy(matrix2.value[i], 0, this.value[i], 0, matrix2.value[i].length);
        }
    }

    Matrix(String strMatrix) {
        Pattern extractor = Pattern.compile("[0-9[^}{]]+");
        Matcher extrMatch = extractor.matcher(strMatrix);
        Pattern clean = Pattern.compile("[0-9[^, ]]+");
        String temCount = " ";
        int len1 = 0;
        int len2 = 0;
        while (extrMatch.find()) {
            if ((", ".equals(extrMatch.group())) || (",".equals(extrMatch.group()))){
                continue;
            }
            temCount = extrMatch.group();
            len1++;
        }
        extrMatch.reset();
        Matcher cleaner = clean.matcher(temCount);
        while (cleaner.find()) {
            len2++;
        }
        String[] arrLines = new String[len1];
        int countLines = 0;
        while (extrMatch.find()) {
            if ((", ".equals(extrMatch.group())) || (",".equals(extrMatch.group()))){
                continue;
            }
            arrLines[countLines] = extrMatch.group();
            countLines++;
        }
        this.value  = new double[len1][len2];
        for (int i = 0; i < arrLines.length; i++) {
            int countColumns = 0;
            Matcher cleaner2 = clean.matcher(arrLines[i]);
            while (cleaner2.find()) {
                System.out.println(cleaner2.group());
                this.value[i][countColumns] = Double.parseDouble(cleaner2.group());
                countColumns++;
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        String curlBrac1 = "{";
        String curlBrac2 = "}, ";
        for (int i = 0; i < value.length; i++) {
            res.append(curlBrac1);
            for (int j = 0; j < value[i].length; j++) {
                res.append(value[i][j]);
                if (j != value[i].length - 1) {
                    res.append(", ");
                }
            }
            if (i == value.length - 1) {
                res.append("}}");
            } else {
                res.append(curlBrac2);
            }
        }
        return res.toString();
    }
}
