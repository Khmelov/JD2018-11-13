package by.it.markelov.jd02_06.Calculator;

class Scalar extends Var {
    double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str) {
        value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar) {
        value = scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double result = this.value + operand2.value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double result = this.value - operand2.value;
            return new Scalar(result);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double result = this.value * operand2.value;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            if (operand2.value == 0)
                throw new CalcException("Деление на ноль");
            double result = this.value / operand2.value;
            return new Scalar(result);
        }
        throw new CalcException("Деление числа на вектор или матрицу невозможно");
    }
}
