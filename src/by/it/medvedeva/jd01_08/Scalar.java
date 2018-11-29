package by.it.medvedeva.jd01_08;

class Scalar extends Var {
    private double value;


    Scalar(double value) {
        this.value = value;
    }



    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }
    Scalar(Scalar scalar){
        this.value=scalar.value;

    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            Scalar operand2= (Scalar) other;
            double res=this.value+operand2.value;
            return new Scalar(res);
        }
        return other.add(this);
    }
    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double res = this.value - operand2.value;
            return new Scalar(res);
        }
        return other.sub(this).mul(new Scalar(-1.0));
    }
    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double res = this.value * operand2.value;
            return new Scalar(res);
        }
        return other.mul(this);
    }
    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar operand2 = (Scalar) other;
            double res = this.value / operand2.value;
            return new Scalar(res);
        }
        return other.div(this);
    }
    @Override
    public String toString() {
        return Double.toString(value);
    }
}

