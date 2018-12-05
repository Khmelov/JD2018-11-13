package by.it.nickgrudnitsky.jd01_09;

class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        value = Double.parseDouble(strScalar);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double rezult = this.value + ((Scalar) other).value;
            return new Scalar(rezult);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double rezult = this.value - ((Scalar) other).value;
            return new Scalar(rezult);
        } else {
            return new Scalar(-1).mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double rezult = this.value * ((Scalar) other).value;
            return new Scalar(rezult);
        } else {
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double rezult = this.value / ((Scalar) other).value;
            return new Scalar(rezult);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
