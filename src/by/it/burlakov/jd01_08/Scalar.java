package by.it.burlakov.jd01_08;

/**
 * Created by user on 27.11.2018.
 */
class Scalar extends Var {

    private double value;

    Scalar(double value){
        this.value = value;
    }
    Scalar(String strValue ){
        this.value = Double.parseDouble(strValue);
    }

    Scalar(Scalar otherScalar){
        this.value = otherScalar.value;
    }

    public Var add(Var other){
        if(other instanceof Scalar){
            Scalar operand2 = (Scalar)other;
            double res = this.value + operand2.value;
            return new Scalar(res);
        }
        return other.add(other);
    }


    public String toString(){
        return String.valueOf(value);
    }
}
