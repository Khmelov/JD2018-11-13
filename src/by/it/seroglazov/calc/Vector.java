package by.it.seroglazov.calc;

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

    // Vector (* or /) Scalar = Vector (true - multiply; false - division)
    private Var mulOrDiv(Scalar other, boolean operation) {
        double sc = other.getValue();
        double[] nv = new double[value.length];
        for (int i = 0; i < nv.length; i++) {
            nv[i] = operation ? value[i] * sc : value[i] / sc;
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

    // Vector (+-) Vector = Vector or null (true - add; false - subtract)
    private Var addOrSub(Vector v, boolean operation) throws CalcException {
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
    public Var add(Vector other) throws CalcException {
        return addOrSub(other, true);
    }

    // Vector - Vector = Vector or null
    @Override
    public Var sub(Vector other) throws CalcException {
        return addOrSub(other, false);
    }

    // Vector * Vector = Scalar or null
    @Override
    public Var mul(Vector other) throws CalcException {
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
    public Var div(Vector other) throws CalcException {
        return super.div((Var)other);
    }

    // Vector + Matrix = null
    @Override
    public Var add(Matrix other) throws CalcException {
        return super.add((Var)other);
    }

    // Vector - Matrix = null
    @Override
    public Var sub(Matrix other) throws CalcException {
        return super.sub((Var)other);
    }

    // Vector * Matrix = null
    @Override
    public Var mul(Matrix other) throws CalcException {
        return super.mul((Var)other);
    }

    // Vector / Matrix = null
    @Override
    public Var div(Matrix other) throws CalcException {
        return super.div((Var)other);
    }

    @Override
    public Var add(Var other) throws CalcException {
        return other.addDispatch(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return other.subDispatch(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return other.mulDispatch(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return other.divDispatch(this);
    }

    @Override
    public Var addDispatch(Var other) throws CalcException {
        return other.add(this);
    }

    @Override
    public Var subDispatch(Var other) throws CalcException {
        return other.sub(this);
    }

    @Override
    public Var mulDispatch(Var other) throws CalcException {
        return other.mul(this);
    }

    @Override
    public Var divDispatch(Var other) throws CalcException {
        return other.div(this);
    }
}



























