package by.it.malishevskiy.jd01_08;

class Scalar extends Var {//Создание класса, наследуемого от абстрактного Var

    public double value;//Создание общей переменной.

    Scalar(double value) {//Говорим, что эта переменная равна добловой  value из Scalar

        this.value = value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
    }
    else
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        }
    else
        return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        }
        else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        }
        else
            return super.div(other);
    }

    Scalar(String strvalue){
        this.value = Double.parseDouble(strvalue);//Говорим, что эта переменная равна стринговой strvalue
    }

    Scalar(Scalar newScalar){
        this.value = newScalar.value;
    }
    public String toString() {
        return String.valueOf(value);
    }
}