package by.it.vchernetski.calc;

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

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other){
//        if (other instanceof Scalar){
//            Scalar operand2 = (Scalar) other;
//            double result = this.value + operand2.value;
//            return new Scalar(result);
//        }
//        return other.add(this);
        return other.addDisp(this);
    }
    @Override
    public Var mul(Var other){
//        if (other instanceof Scalar){
//            Scalar operand2 = (Scalar) other;
//            double result = this.value * operand2.value;
//            return new Scalar(result);
//        }
//        return other.mul(this);
        return other.mulDisp(this);
    }
    @Override
    public Var sub(Var other){
//        if (other instanceof Scalar){
//            Scalar operand2 = (Scalar) other;
//            double result = this.value - operand2.value;
//            return new Scalar(result);
//        }
//        return other.sub(this).mul(new Scalar(-1.0));
        return other.subDisp(this);
    }
    @Override
    public Var div(Var other){
//        if (other instanceof Scalar){
//            Scalar operand2 = (Scalar) other;
//            double result = this.value / operand2.value;
//            return new Scalar(result);
//        }
//            return super.div(other);
        return other.divDisp(this);
    }
    @Override
    public Var addDisp (Var other){
        return other.add(this);
    }

    @Override
    public Var subDisp(Var other) {
        return other.sub(this);
    }

    @Override
    public Var divDisp(Var other) {
        return other.div(this);
    }

    @Override
    public Var mulDisp(Var other) {
        return other.mul(this);
    }
    @Override
    public Var add (Scalar other){
        return new Scalar(this.value+other.value);
    }
    @Override
    public Var sub (Scalar other){
        return new Scalar(this.value-other.value);
    }
    @Override
    public Var mul (Scalar other){
        return new Scalar(this.value*other.value);
    }
    @Override
    public Var div (Scalar other){
        return new Scalar(this.value/other.value);
    }

    @Override
    public Var add(Matrix other) {
       return other.add((Var) this);
    }

    @Override
    public Var sub(Matrix other) {
        return other.sub((Var) this);
    }

    @Override
    public Var mul(Matrix other) {
        return other.mul((Var) this);
    }

    @Override
    public Var div(Matrix other) {
        return super.div((Var) this);
    }

    @Override
    public Var add(Vector other) {
        return other.add((Var) this);
    }

    @Override
    public Var sub(Vector other) {
        return other.sub((Var) this);
    }

    @Override
    public Var mul(Vector other) {
        return other.mul((Var) this);
    }

    @Override
    public Var div(Vector other) {
        return super.div((Var) other);
    }
}
