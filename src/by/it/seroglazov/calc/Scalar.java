package by.it.seroglazov.calc;

public class Scalar extends Var {

    private double value;

    double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }
    Scalar(String strValue){
        value = Double.parseDouble(strValue);
    }
    @SuppressWarnings("unused")
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
    public Var div(Scalar s) throws CalcException {
        if (s.value == 0)
            throw new CalcException(ResMan.get("divisionByZero"));
        return new Scalar(value / s.value);
    }

    @Override
    public Var add(Vector v) {
        return v.add(this);
    }

    @Override
    public Var sub(Vector v) throws CalcException {
        return v.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Vector v) {
        return v.mul(this);
    }

    @Override
    public Var div(Vector v) throws CalcException {
        return super.div((Var)v);
    }

    @Override
    public Var add(Matrix m) throws CalcException {
        return m.add(this);
    }

    @Override
    public Var sub(Matrix m) throws CalcException {
        return m.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Matrix m) throws CalcException {
        return m.mul(this);
    }

    @Override
    public Var div(Matrix m) throws CalcException {
        return super.div((Var)m);
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
