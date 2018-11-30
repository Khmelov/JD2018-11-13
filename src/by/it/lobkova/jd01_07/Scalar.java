package by.it.lobkova.jd01_07;

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
}
