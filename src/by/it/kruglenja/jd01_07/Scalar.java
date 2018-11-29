package by.it.kruglenja.jd01_07;

/**
 * Created by user on 27.11.2018.
 */
 class Scalar extends Var {
    public double value;

    Scalar(double value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
    Scalar(String strValue){
        value = Double.parseDouble(strValue);
    }
    Scalar(Scalar otherScalar){
        this.value = otherScalar.value;
    }
}
