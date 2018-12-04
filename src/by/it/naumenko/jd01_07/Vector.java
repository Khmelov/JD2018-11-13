package by.it.naumenko.jd01_07;

class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        value = vector.value;
    }


    Vector(String strVector) {
        strVector=strVector.replaceAll("[{}]","");
        String[] mas = strVector.split(",\\s*");
        double[] mas1 = new double[mas.length];
        for (int i = 0; i < mas.length; i++) {
            mas1[i] = Double.parseDouble(mas[i]);
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
