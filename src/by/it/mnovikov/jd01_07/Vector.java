package by.it.mnovikov.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 27.11.2018.
 */
class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, this.value.length);
//        for (int i = 0; i < this.value.length; i++) {
//            this.value[i] = value[i];
    }

    Vector(Vector vector) {
        value = new double[vector.value.length];
        System.arraycopy(vector.value, 0, value, 0, value.length);
//      for (int i = 0; i < value.length; i++) {
//      value[i] = vector.value[i];
//      }

    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("[{|}]","");
        Pattern p1 = Pattern.compile("[0-9.,]*");
        Matcher m1 = p1.matcher(strVector);
        if (m1.find()) {
            String[] str = m1.group().split(",");
            value = new double[str.length];
            for (int i = 0; i < value.length; i++) {
                value[i] = Double.parseDouble(str[i]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
