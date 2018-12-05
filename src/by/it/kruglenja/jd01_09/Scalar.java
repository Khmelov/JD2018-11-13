package by.it.kruglenja.jd01_09;

/**
 * Created by user on 27.11.2018.
 */
 class Scalar extends Var {
    private double value;

    public double getValue() { return value; }

    Scalar(double value){
        this.value = value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double sum = this.value + ((Scalar)other).value;
            return new Scalar(sum);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double sub = this.value - ((Scalar)other).value;
            return new Scalar(sub);
        }
        return  new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double mul = this.value * ((Scalar)other).value;
            return new Scalar(mul);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double div = this.value / ((Scalar)other).value;
            return new Scalar(div);
        }
        return other.div(this);

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
}
