package by.it.vchernetski.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;
    Matrix(double[][] value){
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i],0,this.value[i], 0,value.length);
        }
    }

    Matrix(Matrix otherm){
        this.value = new double[otherm.value.length][otherm.value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(otherm.value[i],0,this.value[i], 0,value.length);
        }
    }

    Matrix(String strvalue){
        strvalue=strvalue.replaceAll("\\s","");
        Matcher m = Pattern.compile("\\{(.*)}").matcher(strvalue);
        if(m.find()) strvalue = m.group(1);
        m = Pattern.compile("[\\d ,.]{2,}").matcher(strvalue);
        int size=0;
        while (m.find()){
            size++;}
        String[] lines = new String[size];
        m.reset();
        size=0;
        while (m.find()){
            lines[size++]=m.group();
        }
        String[][] mstr = new String[lines.length][lines[0].split(",").length];
        value=new double[lines.length][lines[0].split(",").length];
        for (int i = 0; i < lines.length; i++) {
            mstr[i]=lines[i].split(",");
        }
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                value[i][j]=Double.parseDouble(mstr[i][j]);
            }
        }
    }
    @Override
    public Var add (Var other){
        if(other instanceof Matrix && ((Matrix) other).value.length == this.value.length && ((Matrix)other).value[0].length == this.value[0].length){
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    res[i][j] = ((Matrix) other).value[i][j]+this.value[i][j];
                }
            }
            return new Matrix(res);
        }
        if(other instanceof  Scalar){
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    res[i][j] =this.value[i][j]+((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        return super.add(other);
    }
    @Override
    public Var sub (Var other){
        if(other instanceof Matrix && ((Matrix) other).value.length == this.value.length && ((Matrix)other).value[0].length == this.value[0].length){
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    res[i][j] = this.value[i][j]-((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        if(other instanceof  Scalar){
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    res[i][j] =this.value[i][j]-((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        return super.add(other);
    }
    @Override
    public Var mul(Var other){
        if(other instanceof Scalar){
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = this.value[i][j]*((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        if(other instanceof Vector && this.value[0].length == ((Vector) other).getValue().length){
            double [] res = new double[((Vector) other).getValue().length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    res[i] += ((Vector) other).getValue()[j]*this.value[i][j];
                }
            }
            return new Vector(res);
        }
        if(other instanceof Matrix && this.value[0].length == ((Matrix) other).value.length){
            double[][] res = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[i].length; j++) {
                    int counter = 0;
                    while(counter<this.value[0].length) {
                        res[i][j] += this.value[i][counter] * ((Matrix) other).value[counter][j];
                        counter++;
                    }
                }
            }
            return new Matrix(res);
        }
        return super.mul(other);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[i].length; j++) {
                sb.append(value[i][j]);
                if (j != value[i].length - 1) sb.append(", ");
            }
            if(i<value.length-1) sb.append("}, ");
            if(i == value.length-1) sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }
}
