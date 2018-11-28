package by.it.mnovikov.jd01_07;

import java.util.Arrays;

/**
 * Created by user on 27.11.2018.
 */
class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = value[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter="";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
