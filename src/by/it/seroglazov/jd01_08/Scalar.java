package by.it.seroglazov.jd01_08;

public class Scalar extends Var {
    private double value;

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
    public Var add(Var other) {
        if (other instanceof Scalar){
            return new Scalar(value + ((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            return new Scalar(value - ((Scalar) other).value);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            return new Scalar(value * ((Scalar) other).value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            return new Scalar(value / ((Scalar) other).value);
        }
        return super.div(other);
    }

}
