package by.it.zakharenko.calc;

public class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar sc = (Scalar) other;
            double result = this.value + sc.value;
            return new Scalar(result);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar sc = (Scalar) other;
            double result = this.value - sc.value;
            return new Scalar(result);
        }

        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar sc = (Scalar) other;
            double result = this.value * sc.value;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar sc = (Scalar) other;
            double result = this.value / sc.value;
            return new Scalar(result);
        }
        return other.div(this);
    }
}