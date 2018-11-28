package by.it.markelov.jd01_07;

import java.util.Arrays;

class Vector extends Var {
    double value[];

    public Vector(double[] value) {
        this.value = value;
        //System.arraycopy(this.value,0,value,0,value.length);
    }

    public Vector(Vector vector) {
        value = vector.value;
        //System.arraycopy(this.value,0,vector.value,0,value.length);
    }

    public Vector(String strVector) {
        String withoutPunct = strVector.replace("[,{}]", "");
        String[] s = withoutPunct.split(" ");
        double temp[] = new double[s.length];
        for (int i = 0; i < s.length; i++) {
            temp[i] = Double.parseDouble(s[i]);
        }
        value = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String demiliter = "";
        for (double element : value) {
            sb.append(demiliter).append(element);
            demiliter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
