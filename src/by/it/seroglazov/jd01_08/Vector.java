package by.it.seroglazov.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector v){
        value = new double[v.value.length];
        System.arraycopy(v.value, 0, value, 0, v.value.length);
    }

    Vector(String str) {
        Matcher mch = Pattern.compile("\\{(.*)\\}").matcher(str);
        if (mch.find()){
            String[] sArr = mch.group(1).replace(" ", "").split(",");
            value = new double[sArr.length];
            for (int i = 0; i < sArr.length; i++) {
                value[i] = Double.parseDouble(sArr[i]);
            }
        } else {
            // Action if wrong string
        }
    }

    @Override
    public String toString() {
        if (value.length == 0) return "";
        StringBuilder sb = new StringBuilder("{");
        sb.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            sb.append(", ");
            sb.append(String.valueOf(value[i]));
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[] nv = new double[value.length];
            for (int i = 0; i < nv.length; i++) {
                nv[i] = value[i] + ((Scalar) other).getValue();
            }
            return new Vector(nv);
        } else if (other instanceof Vector){
            Vector otherV = (Vector) other;
            double[] nv = new double[value.length];
            if (value.length == otherV.value.length){
                for (int i = 0; i < value.length; i++) {
                    nv[i] = value[i] + otherV.value[i];
                }
                return new Vector(nv);
            } else return super.add(other);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }




}



























