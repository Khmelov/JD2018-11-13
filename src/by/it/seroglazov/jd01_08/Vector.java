package by.it.seroglazov.jd01_08;

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
    private Var addOrSubScal(Var other, boolean operation) {
        int op = operation ? 1 : -1;
        double sc = ((Scalar) other).getValue();
        double[] nv = new double[value.length];
        for (int i = 0; i < nv.length; i++) {
            nv[i] = value[i] + op * sc;
        }
        return new Vector(nv);
    }

    // Vector + Scalar = Vector
    private Var addScal(Var other) {
        return addOrSubScal(other, true);
    }

    // Vector - Scalar = Vector
    private Var subScal(Var other) {
        return addOrSubScal(other, false);
    }

    // Vector (+-) Vector = Vector or null (true - add; false - subtract)
    private Var addOrSubVec(Var other, boolean operation) {
        int op = operation ? 1 : -1;
        Vector v = (Vector) other;
        double[] nv = new double[value.length];
        if (value.length == v.value.length) {
            for (int i = 0; i < value.length; i++) {
                nv[i] = value[i] + op * v.value[i];
            }
            return new Vector(nv);
        } else { // Impossible if different length
            return operation ? super.add(other) : super.sub(other);
        }
    }

    // Vector + Vector = Vector or null
    private Var addVec(Var other) {
        return addOrSubVec(other, true);
    }

    // Vector - Vector = Vector or null
    private Var subVec(Var other) {
        return addOrSubVec(other, false);
    }

    // Vector + Matrix = null
    private Var addMatr(Var other) {
        return super.add(other);
    }

    // Vector - Matrix = null
    private Var subMatr(Var other) {
        return super.sub(other);
    }

    // Vector (* or /) Scalar = Vector (true - multiply; false - division)
    private Var mulOrDivScal(Var other, boolean operation) {
        double sc = ((Scalar) other).getValue();
        double[] nv = new double[value.length];
        for (int i = 0; i < nv.length; i++) {
            nv[i] = operation ? value[i] * sc : value[i] / sc;
        }
        return new Vector(nv);
    }

    // Vector * Scalar = Vector
    private Var mulScal(Var other) {
        return mulOrDivScal(other, true);
    }

    // Vector / Scalar = Vector
    private Var divScal(Var other) {
        return mulOrDivScal(other, false);
    }

    // Vector * Vector = Scalar or null
    private Var mulVec(Var other) {
        Vector v = (Vector) other;
        double a = 0;
        if (value.length == v.value.length) {
            for (int i = 0; i < value.length; i++) {
                a += value[i] * v.value[i];
            }
            return new Scalar(a);
        } else return super.mul(other);
    }

    // Vector / Vector = null
    private Var divVec(Var other) {
        return super.div(other);
    }

    // Vector * Matrix = null
    private Var mulMatr(Var other) {
        return super.mul(this);
    }

    // Vector / Matrix = null
    private Var divMatr(Var other) {
        return super.div(other);
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

    /*@Override
    public Var add(Var other) {
        if (other instanceof Scalar) return addScal(other);
        else if (other instanceof Vector) return addVec(other);
        else if (other instanceof Matrix) return addMatr(other);
        else return other.add(this); // For the future possible extend
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) return subScal(other);
        else if (other instanceof Vector) return subVec(other);
        else if (other instanceof Matrix) return subMatr(other);
        else return other.sub(this).mul(new Scalar(-1)); // For the future possible extend
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) return mulScal(other);
        else if (other instanceof Vector) return mulVec(other);
        else if (other instanceof Matrix) return mulMatr(other);
        else return other.mul(this); // For the future possible extend
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) return divScal(other);
        else if (other instanceof Vector) return divVec(other);
        else if (other instanceof Matrix) return divMatr(other);
        else return super.div(other); // For the future possible extend
    }*/


}



























