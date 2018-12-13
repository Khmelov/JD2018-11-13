package by.it.evenchik.jd01_08;

class Scalar extends by.it.evenchik.jd01_08.Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strVal) {
        this.value = Double.parseDouble(strVal);
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    @Override
    public by.it.evenchik.jd01_08.Var add(by.it.evenchik.jd01_08.Var other) {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double res = this.value + operand2.value;
            return new Scalar(res);
        } else
            return other.add(this);
    }

    @Override
    public by.it.evenchik.jd01_08.Var sub(by.it.evenchik.jd01_08.Var other) {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double res = this.value - operand2.value;
            return new Scalar(res);
        } else
            return other.sub(this).mul(new Scalar(-1.0));
    }

    @Override
    public by.it.evenchik.jd01_08.Var mul(by.it.evenchik.jd01_08.Var other) {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double res = this.value * operand2.value;
            return new Scalar(res);
        } else
            return other.mul(this);
    }

    @Override
    public by.it.evenchik.jd01_08.Var div(by.it.evenchik.jd01_08.Var other) {
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
