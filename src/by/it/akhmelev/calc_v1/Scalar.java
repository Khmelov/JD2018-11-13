package by.it.akhmelev.calc_v1;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strValue) {
        value = Double.parseDouble(strValue);
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double res = this.value + operand2.value;
            return new Scalar(res);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double res = this.value - operand2.value;
            return new Scalar(res);
        } else
            return other.sub(this).mul(new Scalar(-1.0));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double res = this.value * operand2.value;
            return new Scalar(res);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double res = this.value / operand2.value;
            return new Scalar(res);
        } else
            return super.div(other);
    }


    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
