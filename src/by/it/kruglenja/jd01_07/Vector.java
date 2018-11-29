package by.it.kruglenja.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 27.11.2018.
 */
public class Vector extends Var {
    private double value[];

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        this.value = new double[vector.value.length];
        System.arraycopy(vector.value, 0, this.value, 0, vector.value.length);
    }

    Vector(String strVector) {
        Pattern extractor = Pattern.compile("[0-9.]+");
        Matcher extrMatcher = extractor.matcher(strVector);
        int len = 0;
        while (extrMatcher.find()) {
            len++;
        }
        extrMatcher.reset();
        this.value = new double[len];
        int count = 0;
        while (extrMatcher.find()) {
            this.value[count] = Double.parseDouble(extrMatcher.group());
            count++;
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            res.append(value[i]);
            if (i != value.length - 1) {
                res.append(", ");
            }
            if (i == value.length - 1) {
                res.append("}");
            }
        }
        return res.toString();
    }
}
