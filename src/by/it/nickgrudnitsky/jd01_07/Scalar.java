package by.it.nickgrudnitsky.jd01_07;

class Scalar extends Var {
    private double value;

     Scalar(double value) {
        this.value = value;
    }

     Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

     Scalar(String strScalar) {
        value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
