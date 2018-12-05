package by.it.medvedeva.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    public double[] value;
    public Vector(double[] v) {
        int len = v.length;
        this.value = new double[len];
        System.arraycopy(v,0, this.value, 0, len);
    }
    public Vector(Vector v) {
        int len = v.value.length;
        this.value = new double[len];
        System.arraycopy(v.value,0, this.value, 0, len);
    }
    public Vector(String s) {

        this.value = new double[3];
        Pattern pdigit = Pattern.compile("[1-9\\.]+");
        Matcher matcher = pdigit.matcher(s);
        int i = 0;
        while (matcher.find()) {
            this.value[i] = Double.parseDouble(matcher.group());
            i++;
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        for (int i=0; i<this.value.length-1;i++){
            res.append(Double.toString(value[i])).append(", ");
        }
        res.append(Double.toString(this.value[this.value.length - 1])).append("}");
        return res.toString();
    }



}

