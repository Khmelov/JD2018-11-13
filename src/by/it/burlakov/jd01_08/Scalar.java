package by.it.burlakov.jd01_08;

/**
 * Created by user on 27.11.2018.
 */
class Scalar extends Var {

    private double value;

    Scalar(double value){
        this.value = value;
    }
    Scalar(String strValue ){
        this.value = Double.parseDouble(strValue);
    }

    Scalar(Scalar otherScalar){
        this.value = otherScalar.value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            return new Scalar(this.value + ((Scalar) other).value);
        }

        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            return new Scalar(this.value - ((Scalar) other).value);
        }
        return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value * ((Scalar) other).value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value/((Scalar) other).value);
        }
        return super.div(other);
    }


    public String toString(){
        return String.valueOf(value);
    }
}
