package by.it.seroglazov.jd01_10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {

    private double[] value;

    @Override
    String getType() {
        return "Vector";
    }

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector v) {
        value = new double[v.value.length];
        System.arraycopy(v.value, 0, value, 0, v.value.length);
    }

    Vector(String str) {
        Matcher mch = Pattern.compile("\\{(.*)\\}").matcher(str);
        if (mch.find()) {
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

    // Vector (+-) Scalar = Vector (true - add; false - subtract)
    private Var addOrSub(Scalar other, boolean operation) {
        int op = operation ? 1 : -1;
        double sc = other.getValue();
        double[] nv = new double[value.length];
        for (int i = 0; i < nv.length; i++) {
            nv[i] = value[i] + op * sc;
        }
        return new Vector(nv);
    }

    // Vector + Scalar = Vector
    @Override
    public Var add(Scalar other) {
        return addOrSub(other, true);
    }

    // Vector - Scalar = Vector
    @Override
    public Var sub(Scalar other) {
        return addOrSub(other, false);
    }

    // Vector (+-) Vector = Vector or null (true - add; false - subtract)
    private Var addOrSub(Vector v, boolean operation) {
        int op = operation ? 1 : -1;
        double[] nv = new double[value.length];
        if (value.length == v.value.length) {
            for (int i = 0; i < value.length; i++) {
                nv[i] = value[i] + op * v.value[i];
            }
            return new Vector(nv);
        } else { // Impossible if different length
            return operation ? super.add((Var)v) : super.sub((Var)v);
        }
    }

    // Vector + Vector = Vector or null
    @Override
    public Var add(Vector other) {
        return addOrSub(other, true);
    }

    // Vector - Vector = Vector or null
    @Override
    public Var sub(Vector other) {
        return addOrSub(other, false);
    }

    // Vector + Matrix = null
    @Override
    public Var add(Matrix other) {
        return super.add((Var)other);
    }

    // Vector - Matrix = null
    @Override
    public Var sub(Matrix other) {
        return super.sub((Var)other);
    }

    // Vector (* or /) Scalar = Vector (true - multiply; false - division)
    private Var mulOrDiv(Scalar other, boolean operation) {
        double sc = other.getValue();
        double[] nv = new double[value.length];
        for (int i = 0; i < nv.length; i++) {
            nv[i] = operation ? value[i] * sc : value[i] / sc;
        }
        return new Vector(nv);
    }

    // Vector * Scalar = Vector
    @Override
    public Var mul(Scalar other) {
        return mulOrDiv(other, true);
    }

    // Vector / Scalar = Vector
    @Override
    public Var div(Scalar other) {
        return mulOrDiv(other, false);
    }

    // Vector * Vector = Scalar or null
    @Override
    public Var mul(Vector other) {
        double a = 0;
        if (value.length == other.value.length) {
            for (int i = 0; i < value.length; i++) {
                a += value[i] * other.value[i];
            }
            return new Scalar(a);
        } else return super.mul((Var)other);
    }

    // Vector / Vector = null
    @Override
    public Var div(Vector other) {
        return super.div((Var)other);
    }

    // Vector * Matrix = null
    @Override
    public Var mul(Matrix other) {
        return super.mul((Var)other);
    }

    // Vector / Matrix = null
    @Override
    public Var div(Matrix other) {
        return super.div((Var)other);
    }

    @Override
    public Var add(Var other) {
        if (other.getType() == "Scalar") return addScal(other);
        else if (other.getType() == "Vector") return addVec(other);
        else if (other.getType() == "Matrix") return addMatr(other);
        else return other.add(this); // For the future possible extend
    }

    @Override
    public Var sub(Var other) {
        if (other.getType() == "Scalar") return subScal(other);
        else if (other.getType() == "Vector") return subVec(other);
        else if (other.getType() == "Matrix") return subMatr(other);
        else return other.sub(this).mul(new Scalar(-1)); // For the future possible extend
    }

    @Override
    public Var mul(Var other) {
        if (other.getType() == "Scalar") return mulScal(other);
        else if (other.getType() == "Vector") return mulVec(other);
        else if (other.getType() == "Matrix") return mulMatr(other);
        else return other.mul(this); // For the future possible extend
    }

    @Override
    public Var div(Var other) {
        if (other.getType() == "Scalar") return divScal(other);
        else if (other.getType() == "Vector") return divVec(other);
        else if (other.getType() == "Matrix") return divMatr(other);
        else return super.div(other); // For the future possible extend
    }

}



























