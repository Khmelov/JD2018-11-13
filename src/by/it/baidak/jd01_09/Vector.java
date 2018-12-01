package by.it.baidak.jd01_09;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value){
        double[] mas = new double[value.length];
        System.arraycopy(value,0,mas,0,value.length);
        this.value = mas;
    }

    Vector(Vector other){
        double[] mas = new double[other.value.length];
        System.arraycopy(other.value,0,mas,0,other.value.length);
        this.value = mas;
    }

    Vector(String value){
        String s = value.substring(1,value.length() - 1);
        String[] mas1 = s.split(",");
        double[] mas2 = new double[mas1.length];
        for (int i = 0; i < mas1.length; i++) {
            mas2[i] = Double.parseDouble(mas1[i]);
        }
        this.value = mas2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(this.value[0]);
        for (int i = 1; i < this.value.length; i++) {
            sb.append(", " + this.value[i]);
        }
        sb.append("}");
        return sb.toString();
    }
}
