package by.it.akhmelev.jd01_07;

import java.util.Arrays;

class Vector extends Var{

    private double[] value;


    Vector(double[] value) {
        this.value=new double[value.length];
        System.arraycopy(value, 0, this.value, 0, this.value.length);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");

        String delimiter="";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter=", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
