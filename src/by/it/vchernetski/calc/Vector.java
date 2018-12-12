package by.it.vchernetski.calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    private double[] value;
    Vector(double[] value){
        this.value = new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }
    Vector(Vector otherVector){
        this.value = new double[otherVector.value.length];

        System.arraycopy(otherVector.value,0,this.value,0,otherVector.value.length);
    }

    Vector(String strvalue){
        strvalue=strvalue.replaceAll("\\s","");
        Matcher m = Pattern.compile("\\{(.*)}").matcher(strvalue);
        while(m.find()) {
            String str = m.group(1).replace("\\s","");
            String[] values = str.split(",");
            value = new double[values.length];
            int i = 0;
            while (i<values.length){
                value[i]=Double.parseDouble(values[i++]);
            }
        }
    }
    public double[] getValue() {
        return value;
    }
    @Override
    public Var add(Var other) {
//        if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
//            Vector res = new Vector(Arrays.copyOf(this.value, this.value.length));
//            Vector operand = (Vector) other;
//            for (int i = 0; i < res.value.length; i++) {
//                res.value[i] = res.value[i] + ((Vector) other).value[i];
//            }
//            return new Vector(res);
//        }
//        if (other instanceof Scalar){
//            Vector res = new Vector(Arrays.copyOf(this.value,this.value.length));
//            Scalar operand = (Scalar) other;
//            for (int i = 0; i < res.value.length; i++) {
//                res.value[i] = res.value[i] + operand.getValue();
//            }
//            return res;
//        }
//        return super.add(other);
        return other.addDisp(this);
    }

    @Override
    public Var sub(Var other) {
//        if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
//            Vector res = new Vector(Arrays.copyOf(this.value, this.value.length));
//            Vector operand = (Vector) other;
//            for (int i = 0; i < res.value.length; i++) {
//                res.value[i] = res.value[i] - ((Vector) other).value[i];
//            }
//            return new Vector(res);
//        }
//        if (other instanceof Scalar){
//            Vector res = new Vector(Arrays.copyOf(this.value,this.value.length));
//            Scalar operand = (Scalar) other;
//            for (int i = 0; i < res.value.length; i++) {
//                res.value[i] = res.value[i] - operand.getValue();
//            }
//            return res;
//        }
//        return super.sub(other);
        return other.subDisp(this);
    }
    @Override
    public Var mul(Var other){
//        if(other instanceof Vector && this.value.length == ((Vector) other).value.length){
//            Vector v = new Vector(Arrays.copyOf(this.value,this.value.length));
//            double result = 0;
//            for (int i = 0; i < this.value.length; i++) {
//                result+= v.value[i]*((Vector)other).value[i];
//            }
//            return new Scalar(result);
//        }
//        if(other instanceof Scalar){
//            Vector res = new Vector(Arrays.copyOf(this.value,this.value.length));
//            for (int i = 0; i < res.value.length; i++) {
//                res.value[i] = res.value[i]*((Scalar) other).getValue();
//            }
//            return  res;
//        }
//        return other.mul(this);
        return other.mulDisp(this);
    }
    @Override
    public Var div (Var other){
//        if (other instanceof Scalar){
//            Vector res = new Vector(Arrays.copyOf(this.value,this.value.length));
//            for (int i = 0; i < res.value.length; i++) {
//                res.value[i] = res.value[i]/((Scalar)other).getValue();
//            }
//            return res;
//        }
//        return super.div(this);
        return other.divDisp(this);
    };
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        String del=", ";
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]).append(del);
            if(i == value.length-2) del = "}";
        }
        return sb.toString();
    }

    @Override
    public Var addDisp(Var other) {
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
    public Var add(Scalar other) {
        Vector res = new Vector(Arrays.copyOf(this.value,this.value.length));
        for (int i = 0; i < res.value.length; i++) {
            res.value[i] = res.value[i] + other.getValue();
        }
        return res;
    }

    @Override
    public Var sub(Scalar other) {
        Vector res = new Vector(Arrays.copyOf(this.value,this.value.length));
        for (int i = 0; i < res.value.length; i++) {
            res.value[i] = res.value[i] - other.getValue();
        }
        return res;
    }

    @Override
    public Var mul(Scalar other) {
            Vector res = new Vector(Arrays.copyOf(this.value,this.value.length));
            for (int i = 0; i < res.value.length; i++) {
                res.value[i] = res.value[i]*other.getValue();
            }
            return  res;
    }

    @Override
    public Var div(Scalar other) {
            Vector res = new Vector(Arrays.copyOf(this.value,this.value.length));
            for (int i = 0; i < res.value.length; i++) {
                res.value[i] = res.value[i]/other.getValue();
            }
            return res;
    }

    @Override
    public Var add(Matrix other) {
        return super.add((Var) other);
    }

    @Override
    public Var sub(Matrix other) {
        return super.sub((Var) other);
    }

    @Override
    public Var mul(Matrix other) {
        return super.mul((Var) other);
    }

    @Override
    public Var div(Matrix other) {
        return super.div((Var) other);
    }

    @Override
    public Var add(Vector other) {
        Vector res = new Vector(Arrays.copyOf(this.value, this.value.length));
        for (int i = 0; i < res.value.length; i++) {
            res.value[i] = res.value[i] + other.value[i];
        }
        return res;
    }

    @Override
    public Var sub(Vector other) {
        Vector res = new Vector(Arrays.copyOf(this.value, this.value.length));
        for (int i = 0; i < res.value.length; i++) {
            res.value[i] = res.value[i] - other.value[i];
        }
        return res;
    }

    @Override
    public Var mul(Vector other) {
        Vector v = new Vector(Arrays.copyOf(this.value,this.value.length));
        double result = 0;
        for (int i = 0; i < this.value.length; i++) {
            result+= v.value[i]*((Vector)other).value[i];
        }
        return new Scalar(result);
    }

    @Override
    public Var div(Vector other) {
        return super.div((Var)this);
    }
}
