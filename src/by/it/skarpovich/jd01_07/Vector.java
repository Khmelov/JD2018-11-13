package by.it.skarpovich.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, this.value.length);
    }




    Vector(Vector vector){
        value = new double[vector.value.length];
        System.arraycopy(vector.value, 0, value, 0, vector.value.length);
    }

    Vector(String strVector) {
        //StringBuilder sBuilder= new StringBuilder(strVector);
        Matcher matcher = Pattern.compile("\\{(.*)\\}").matcher(strVector);
        while (matcher.find()) {
            String[] strVectorArray = matcher.group(1).replace(" ", "").split(",");
            value = new double[strVectorArray.length];
            for (int i = 0; i <strVectorArray.length; i++) {
                value[i] = Double.parseDouble(strVectorArray[i]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double v2 : value) {
            sb.append(delimiter).append(v2);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();

    }
}
