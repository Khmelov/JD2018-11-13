package by.it.seroglazov.calc;

public class Scalar extends Var {
    private double value;

    @Override
    String getType() {
        return "Scalar";
    }

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }
    Scalar(String strValue){
        value = Double.parseDouble(strValue);
    }
    Scalar(Scalar otherScalar){
        this.value = otherScalar.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Var add(Scalar s) {
        return new Scalar(value + s.value);
    }

    @Override
    public Var sub(Scalar s) {
        return new Scalar(value - s.value);
    }

    @Override
    public Var mul(Scalar s) {
        return new Scalar(value * s.value);
    }

    @Override
    public Var div(Scalar s) {
        return new Scalar(value / s.value);
    }

    @Override
    public Var add(Vector v) {
        return v.add(this);
    }

    @Override
    public Var sub(Vector v) {
        return v.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Vector v) {
        return v.mul(this);
    }

    @Override
    public Var div(Vector v) {
        return super.div((Var)v);
    }

    @Override
    public Var add(Matrix m) {
        return m.add(this);
    }

    @Override
    public Var sub(Matrix m) {
        return m.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Matrix m) {
        return m.mul(this);
    }

    @Override
    public Var div(Matrix m) {
        return super.div((Var)m);
    }

    @Override
    public Var add(Var other) {
        return other.addDispatch(this);
    }

    @Override
    public Var sub(Var other) {
        return other.subDispatch(this);
    }

    @Override
    public Var mul(Var other) {
        return other.mulDispatch(this);
    }

    @Override
    public Var div(Var other) {
        return other.divDispatch(this);
    }

    @Override
    public Var addDispatch(Var other) {
        return other.add(this);
    }

    @Override
    public Var subDispatch(Var other) {
        return other.sub(this);
    }

    @Override
    public Var mulDispatch(Var other) {
        return other.mul(this);
    }

    @Override
    public Var divDispatch(Var other) {
        return other.div(this);
    }
}
