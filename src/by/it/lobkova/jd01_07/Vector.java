package by.it.lobkova.jd01_07;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector){
        this.value = vector.value;
    }

    Vector(String str){
        String[] string = str.replaceAll("[{}]", "").split("[,]");
        double[] vector = new double[string.length];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = Double.parseDouble(string[i]);
        }
        this.value = vector;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String dilimiter = "";
        for (double element : value){
            sb.append(dilimiter).append(element);
            dilimiter = ", ";
        }
        sb.append("}");

        return sb.toString();
    }

}
