package by.it.baidak.jd01_07;

/**
 * Created by user on 27.11.2018.
 */
class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar (String value){
        this.value=Double.parseDouble(value);
    }

    Scalar (Scalar other){
        this.value = other.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
