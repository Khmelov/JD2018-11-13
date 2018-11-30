package by.it.lobkova.jd01_08;

public class Scalar extends Var {


    public Scalar(double value) {
        super(value);
    }

    public Scalar(Scalar scalar) {
        super(scalar.getValue());
    }

    public Scalar(String strScalar) {
        super(Double.valueOf(strScalar));
    }

    @Override
    public String toString() {
        return super.getValue() + "";
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            //double res = this.value+operand2.value;
            //return new Scalar(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }
}
