package by.it.skarpovich.jd01_09;

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double sum=this.value+((Scalar) other).value;
            return new Scalar(sum);
        }
        else
           return other.add(this);

    }
    //Вычитание
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sum = this.value - ((Scalar) other).value;
            return new Scalar(sum);
        } else
            return new Scalar(-1).mul(other).add(this);
    }
    //Умножение
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double mul = this.value *((Scalar) other).value;
            return new Scalar(mul);
        } else
            return other.mul(this);
    }

    public Var div(Var other) {
        if (other instanceof Scalar) {
            double div = this.value/((Scalar) other).value;
            return new Scalar(div);
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
