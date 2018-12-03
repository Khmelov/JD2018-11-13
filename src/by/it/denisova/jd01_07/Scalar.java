package by.it.denisova.jd01_07;

public class Scalar extends Var {

    private double value;

    Scalar(double value){
        this.value = value;
    }

    Scalar(String strValue){
        value = Double.parseDouble(strValue);
    }

    Scalar (Scalar otherScalar){
        this.value = otherScalar.value;
    }

    public Var add(Var other){
        if (other instanceof Scalar){

            Scalar scalar1 = (Scalar) other;
            double result = this.value + scalar1.value;
            return new Scalar(result);
        }
        else{
            return other;
        }

    }

    Var sub(Var other){
        if (other instanceof Scalar){
            Scalar scalar1 = (Scalar) other;
            double resilt = this.value - scalar1.value;
            return  new Scalar(resilt);
        }
        else {
            return other;
        }
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }
}
