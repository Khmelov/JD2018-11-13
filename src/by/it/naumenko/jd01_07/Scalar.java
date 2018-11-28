package by.it.naumenko.jd01_07;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str){
        value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar){
        value = scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
