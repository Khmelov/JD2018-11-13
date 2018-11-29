package by.it.markelov.jd01_07;

class Vector extends Var {
    double value[];

    public Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    public Vector(Vector vector) {
        //value = vector.value;
        this.value = new double[vector.value.length];
        System.arraycopy(vector.value, 0, this.value, 0, vector.value.length);
    }

    public Vector(String strVector) {
        String withoutPunct = strVector.replaceAll("[}{]", "");
        String[] s = withoutPunct.split(",");
        value = new double[s.length];
        for (int i = 0; i < s.length; i++) {
            value[i] = Double.parseDouble(s[i]);
        }

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
