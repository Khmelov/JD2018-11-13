package by.it.vchernetski.jd01_09;

class Scalar extends Var {
    private double value;
    Scalar(double value) {
        this.value = value;
    }
    Scalar(String strvalue){
        this.value=Double.parseDouble(strvalue);
    }
    Scalar(Scalar otherScalar){
        this.value=otherScalar.value;
    }
    public String toString() {
        return String.valueOf(value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other){
        if (other instanceof Scalar){
            Scalar operand2 = (Scalar) other;
            double result = this.value + operand2.value;
            return new Scalar(result);
        }
        return other.add(this);
    }
    public Var mul(Var other){
        if (other instanceof Scalar){
            Scalar operand2 = (Scalar) other;
            double result = this.value * operand2.value;
            return new Scalar(result);
        }
        return other.mul(this);
    }
    public Var sub(Var other){
        if (other instanceof Scalar){
            Scalar operand2 = (Scalar) other;
            double result = this.value - operand2.value;
            return new Scalar(result);
        }
        return other.sub(this).mul(new Scalar(-1.0));
    }
    public Var div(Var other){
        if (other instanceof Scalar){
            Scalar operand2 = (Scalar) other;
            double result = this.value / operand2.value;
            return new Scalar(result);
        }
            return super.div(other);
    }
}
