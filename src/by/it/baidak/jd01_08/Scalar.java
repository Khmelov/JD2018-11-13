package by.it.baidak.jd01_08;

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
    public Var add(Var v) {
        if(v instanceof Scalar) {
            Scalar operand2 = (Scalar) v;
            double res = this.value + operand2.value;
            return new Scalar(res);
        }
        return v.add(this);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
