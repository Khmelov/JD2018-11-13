package by.it.malishevskiy.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {//Наследуем класс Vector от Var
    private double[] value;//Создаем дабловый массив value
    public Vector(double[] v){
        this.value = new double[v.length];//Говорим, что value равен вектору value
        System.arraycopy(v,0,this.value,0,value.length);//Копируем массив
    }
    public Vector(Vector newV){
        this.value = new double[newV.value.length];

        System.arraycopy(newV.value,0,this.value,0,newV.value.length);
    }

    Vector(String strvalue){
        Matcher m = Pattern.compile("(\\d+[\\.\\d+]?)").matcher(strvalue);
        int size = 0;
        while(m.find()){
            size++;
        }
        value = new double[size];
        size = 0;
        m.reset();
        while (m.find()){
            value[size++] = Double.parseDouble(m.group());
        }
    }

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
    public Var add(Var other) {
        if (other instanceof Vector){
            double[] difvar = ((Vector)other).value;
            double[] res = new double[]{4,5,6};
            for (int i = 0;i < difvar.length; i++) {
                res[i] = this.value[i] + difvar[i];
            }
            return new Vector(res);
        }
        else if (other instanceof Scalar){
            double difvar = ((Scalar)other).value;
            double[] res = new double[]{4,5,6};
            for (int i = 0;i < value.length; i++) {
                res[i] = this.value[i] + difvar;
            }
            return new Vector(res);
        }
        else return other.sub(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Vector){
            double[] difvar = ((Vector)other).value;
            double[] res = new double[]{4,5,6};
            for (int i = 0;i < difvar.length; i++) {
                res[i] = this.value[i] - difvar[i];
            }
            return new Vector(res);
        }
        else if (other instanceof Scalar){
            double difvar = ((Scalar)other).value;
            double[] res = new double[]{4,5,6};
            for (int i = 0;i < value.length; i++) {
                res[i] = this.value[i] - difvar;
            }
            return new Vector(res);
        }
        else return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector){
            double[] difvar = ((Vector)other).value;
            double res = 0;
            for (int i = 0;i < difvar.length; i++) {
                res += this.value[i] * difvar[i];
            }
            return new Scalar(res);
        }
        else if (other instanceof Scalar){
            double difvar = ((Scalar)other).value;
            double[] res = new double[]{4,5,6};
            for (int i = 0;i < value.length; i++) {
                res[i] = this.value[i] * difvar;
            }
            return new Vector(res);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Vector) {
            System.out.println("Операция деления вектор на вектор невозможна");
            return null;
        }
        else if (other instanceof Scalar){
            double difvar = ((Scalar)other).value;
            double[] res = new double[]{4,5,6};
            for (int i = 0;i < value.length; i++) {
                res[i] = this.value[i] / difvar;
            }
            return new Vector(res);
        }
        else return other.div(this);
    }
}
