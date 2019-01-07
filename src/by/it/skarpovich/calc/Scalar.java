package by.it.skarpovich.calc;

import by.it.skarpovich.calc.res.Messages;

class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }
    //Сложение
    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sum=this.value+((Scalar) other).value;
            return new Scalar(sum);
        }
        else
            return other.add(this);

    }
    //Вычитание
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sum = this.value - ((Scalar) other).value;
            return new Scalar(sum);
        } else
            return new Scalar(-1).mul(other).add(this);
    }
    //Умножение
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double mul = this.value *((Scalar) other).value;
            return new Scalar(mul);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            if (operand2.value==0)
                throw new CalcException(ResMan.INSTANCE.get(Messages.STR_ZERO));
            double res = this.value / operand2.value;
            return new Scalar(res);
        } else
            return super.div(other);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }


}
