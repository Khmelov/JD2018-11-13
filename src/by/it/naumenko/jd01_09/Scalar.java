package by.it.naumenko.jd01_09;

class Scalar extends Var {
    double value;

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

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            Scalar operand2=(Scalar) other;
            double rezultat=this.value+operand2.value;
            return new Scalar(rezultat);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            Scalar operand2= (Scalar) other;
            double rezultat = this.value-operand2.value;
            return new Scalar(rezultat);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar){
            Scalar operand2 = (Scalar)other;
            double rezultat = this.value*operand2.value;
            return new Scalar(rezultat);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            Scalar operand2=(Scalar)other;
            double rezultat = this.value/operand2.value;
            return new Scalar(rezultat);

        }
        return other.div(this);
    }
}
