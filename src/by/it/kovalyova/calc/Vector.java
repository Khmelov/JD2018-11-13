package by.it.kovalyova.calc;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    public double[] value;
    public Vector(double[] v) {
        int len = v.length;
        this.value = new double[len];
        System.arraycopy(v,0, this.value, 0, len);
    }
    public Vector(Vector v) {
        int len = v.value.length;
        this.value = new double[len];
        System.arraycopy(v.value,0, this.value, 0, len);
    }
    public Vector(String s) {
        String s1 = s.replace("{","");
        String[] elems = s1.split("[,\\s}]+");
        this.value = new double[elems.length];
        int i =0;
        for (String e: elems) {
            this.value[i] = Double.parseDouble(e);
            i++;
        }

    }
    @Override
    public String toString() {
        String res = "{";
        for (int i=0; i<this.value.length-1;i++){
            res = res + Double.toString(value[i]) + ",";
        }
        res = res + Double.toString(this.value[this.value.length-1])+"}";
        return res;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Vector){
            double[] otherval = ((Vector)other).value;
            if (otherval.length!=value.length){
                throw new CalcException("Нельзя складывать вектора разной длины");
            }
            double[] res = new double[value.length];
            for (int i=0;i<otherval.length; i++) {
                res[i]=this.value[i]+otherval[i];
            }
            return new Vector(res);
        }
        else if (other instanceof Scalar){
            double otherval = ((Scalar)other).value;
            double[] res = new double[value.length];


            for (int i=0;i<value.length; i++) {
                res[i]=this.value[i]+otherval;
            }
            return new Vector(res);
        }
        //else if(other instanceof Matrix) {
        //    throw new ClassCastException("Не реализованы матрицы");
        //}
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Vector) {
            double[] otherval = ((Vector) other).value;
            if (otherval.length != value.length) {
                throw new CalcException("Нельзя вычитать вектора разной длины");
            }
            double[] res = new double[value.length];
            for (int i = 0; i < otherval.length; i++) {
                res[i] = this.value[i] - otherval[i];
            }
            return new Vector(res);
        } else if (other instanceof Scalar) {
            double otherval = ((Scalar) other).value;
            double[] res = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                res[i] = this.value[i] - otherval;
            }
            return new Vector(res);
        } else {
            throw new CalcException("Тип второго операнда неизвестен");
        }

    }
    //    else return other.sub(this);

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Vector){
            double[] otherval = ((Vector)other).value;
            if (otherval.length!=value.length){
                throw new CalcException("Нельзя умножать вектора разной длины");
            }
            double res = 0;
            for (int i=0;i<otherval.length; i++) {
                res+=this.value[i]*otherval[i];
            }
            return new Scalar(res);
        }
        else if (other instanceof Scalar){
            double otherval = ((Scalar)other).value;
            double[] res = new double[value.length];
            for (int i=0;i<value.length; i++) {
                res[i]=this.value[i]*otherval;
            }
            return new Vector(res);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Vector) {
            System.out.println("Не делим вектор");
            return null;
        }
        else if (other instanceof Scalar){
            double otherval = ((Scalar)other).value;
            double[] res = new double[value.length];

            for (int i=0;i<value.length; i++) {
                res[i]=this.value[i]/otherval;
            }
            return new Vector(res);
        }
        else return other.div(this);
    }
}
