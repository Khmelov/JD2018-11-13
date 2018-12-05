package by.it.berdnik.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(String strVector) {
        Matcher matcher = Pattern.compile("[\\w]").matcher(strVector);
        int str = 0;
        while (matcher.find()) {
            str++;
        }
        value = new double[str];
        str = 0;
        matcher.reset();
        while (matcher.find()) {
            value[str++] = Double.parseDouble(matcher.group());
        }
    }


    Vector(Vector vector) {
        this.value = vector.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
