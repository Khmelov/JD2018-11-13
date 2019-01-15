package by.it.baidak.calc;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value){
        double[] mas = new double[value.length];
        System.arraycopy(value,0,mas,0,value.length);
        this.value = mas;
    }

    Vector(Vector value){
        double[] mas = new double[value.value.length];
        System.arraycopy(value.value,0,mas,0,value.value.length);
        this.value = mas;
    }

    Vector(String value){
        String s = value.substring(1,value.length() - 1);
        String[] mas1 = s.split(",");
        double[] mas2 = new double[mas1.length];
        for (int i = 0; i < mas1.length; i++) {
            mas2[i] = Double.parseDouble(mas1[i]);
        }
        this.value = mas2;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Vector) {
            double[] res = new double[this.value.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        } else if(other instanceof Scalar){
            double[] res = new double[this.value.length];
            for (int i = 0; i < res.length; i++) {
                res[i] += this.value[i] + ((Scalar) other).value;
            }
            return new Vector(res);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Vector) {
            double[] res = new double[this.value.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        } else if(other instanceof Scalar){
            double[] res = new double[this.value.length];
            for (int i = 0; i < res.length; i++) {
                res[i] += this.value[i] - ((Scalar) other).value;
            }
            return new Vector(res);
        } else
            return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector) {
            double res = 0;
            for (int i = 0; i < this.value.length; i++) {
                res += this.value[i] * ((Vector) other).value[i];
            }
            return new Scalar(res);
        } else if(other instanceof Scalar){
            double[] res = new double[this.value.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i] * ((Scalar) other).value;
            }
            return new Vector(res);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Vector) {
            throw new CalcException("Деление скаляра на " + other + " невозможно");
        } else if(other instanceof Scalar){
            double[] res = new double[this.value.length];
            for (int i = 0; i < res.length; i++) {
                res[i] += this.value[i] / ((Scalar) other).value;
            }
            return new Vector(res);
        } else
            return other.div(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(this.value[0]);
        for (int i = 1; i < this.value.length; i++) {
            sb.append("," + this.value[i]);
        }
        sb.append("}");
        return sb.toString();
    }
}
