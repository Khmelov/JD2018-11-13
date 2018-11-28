package by.it.naumenko.jd01_02.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        value = vector.value;
    }


    Vector(String strVector) {
        String[] mas = strVector.split("[{},]");
        double[] mas1 = new double[mas.length - 1];
        int k = 0;
        for (int i = 0; i < mas.length; i++) {
            if (i!=0) {
                mas1[k] = Double.parseDouble(mas[i]);
                k++;
            }
        }
        value = mas1;
    }






    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String del = "";
        for (double v : value) {
            sb.append(del).append(v);
            del = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
