package by.it.denisova.jd01_07;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {
        this.value = new double[value.length];
        // this.value = value;
        System.arraycopy(value, 0, this.value, 0, this.value.length);
    }

    public Vector(Vector otherValue) {
        this.value = new double[otherValue.value.length];
        System.arraycopy(otherValue.value, 0, this.value, 0, this.value.length);
    }


    public Vector(String value) {
        value = value.replaceAll("[{|}]", "");
        String[] stringValues = value.split(",");
        this.value = new double[stringValues.length];
        for (int i = 0; i < stringValues.length; i++) {
            this.value[i] = Double.parseDouble(stringValues[i].trim());
        }
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
