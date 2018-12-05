package by.it.denisova.jd01_09;

public class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }


    Scalar(double value){
        this.value = value;
    }

    Scalar(String strValue){
        value = Double.parseDouble(strValue);
    }

    Scalar (Scalar otherScalar){
        this.value = otherScalar.value;
    }



    @Override
    public Var add(Var other){
        if (other instanceof Scalar){
            Scalar scalar1 = (Scalar) other;
            double result = this.value + scalar1.value;
            return new Scalar(result);
        }
        else{
            return other.add(this);
        }

    }

    @Override
    public Var sub (Var other){
        if (other instanceof Scalar){
            Scalar scalar1 = (Scalar)other;
            double result = this.value - scalar1.value;
            return new Scalar(result);
        }
        else {
            return other.sub(this);
        }
    }

    @Override
    public Var mul (Var other){
        if (other instanceof Scalar){
            Scalar scalar1 = (Scalar)other;
            double result = this.value * scalar1.value;
            return new Scalar(result);
        }
        else {
            return other.mul(this);
        }
    }

    @Override
    public Var div (Var other){
        if (other instanceof Scalar){
            Scalar scalar1 = (Scalar)other;
            double result = this.value / scalar1.value;
            return new Scalar(result);
        }
        else {
            return other.div(this);
        }
    }


    @Override
    public String toString(){
        return String.valueOf(value);
    }
}
