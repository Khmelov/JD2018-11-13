package by.it.zhivov.jd01_07;

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
}
