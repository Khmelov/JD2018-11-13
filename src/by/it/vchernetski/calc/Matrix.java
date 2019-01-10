package by.it.vchernetski.calc;

import by.it.vchernetski.calc.errors.Errors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;
    Matrix(double[][] value){
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i],0,this.value[i], 0,value[0].length);
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
        m = Pattern.compile("[-?\\d\\.\\d? ,]{2,}").matcher(strvalue);
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
    public Var add (Var other)throws CalcException{
//        if(other instanceof Matrix && ((Matrix) other).value.length == this.value.length && ((Matrix)other).value[0].length == this.value[0].length){
//            double[][] res = new double[this.value.length][this.value[0].length];
//            for (int i = 0; i < this.value.length; i++) {
//                for (int j = 0; j < this.value[i].length; j++) {
//                    res[i][j] = ((Matrix) other).value[i][j]+this.value[i][j];
//                }
//            }
//            return new Matrix(res);
//        }
//        if(other instanceof  Scalar){
//            double[][] res = new double[this.value.length][this.value[0].length];
//            for (int i = 0; i < this.value.length; i++) {
//                for (int j = 0; j < this.value[i].length; j++) {
//                    res[i][j] =this.value[i][j]+((Scalar) other).getValue();
//                }
//            }
//            return new Matrix(res);
//        }
//        return super.add(other);
        return other.addDisp(this);
    }
    @Override
    public Var sub (Var other)throws CalcException{
//        if(other instanceof Matrix && ((Matrix) other).value.length == this.value.length && ((Matrix)other).value[0].length == this.value[0].length){
//            double[][] res = new double[this.value.length][this.value[0].length];
//            for (int i = 0; i < this.value.length; i++) {
//                for (int j = 0; j < this.value[i].length; j++) {
//                    res[i][j] = this.value[i][j]-((Matrix) other).value[i][j];
//                }
//            }
//            return new Matrix(res);
//        }
//        if(other instanceof  Scalar){
//            double[][] res = new double[this.value.length][this.value[0].length];
//            for (int i = 0; i < this.value.length; i++) {
//                for (int j = 0; j < this.value[i].length; j++) {
//                    res[i][j] =this.value[i][j]-((Scalar) other).getValue();
//                }
//            }
//            return new Matrix(res);
//        }
//        return super.add(other);
        return other.subDisp(this);
    }
    @Override
    public Var mul(Var other)throws CalcException{
//        if(other instanceof Scalar){
//            double[][] res = new double[this.value.length][this.value[0].length];
//            for (int i = 0; i < res.length; i++) {
//                for (int j = 0; j < res[i].length; j++) {
//                    res[i][j] = this.value[i][j]*((Scalar) other).getValue();
//                }
//            }
//            return new Matrix(res);
//        }
//        if(other instanceof Vector && this.value[0].length == ((Vector) other).getValue().length){
//            double [] res = new double[((Vector) other).getValue().length];
//            for (int i = 0; i < this.value.length; i++) {
//                for (int j = 0; j < this.value[i].length; j++) {
//                    res[i] += ((Vector) other).getValue()[j]*this.value[i][j];
//                }
//            }
//            return new Vector(res);
//        }
//        if(other instanceof Matrix && this.value[0].length == ((Matrix) other).value.length){
//            double[][] res = new double[this.value.length][((Matrix) other).value[0].length];
//            for (int i = 0; i < this.value.length; i++) {
//                for (int j = 0; j < ((Matrix) other).value[i].length; j++) {
//                    int counter = 0;
//                    while(counter<this.value[0].length) {
//                        res[i][j] += this.value[i][counter] * ((Matrix) other).value[counter][j];
//                        counter++;
//                    }
//                }
//            }
//            return new Matrix(res);
//        }
//        return super.mul(other);
        return other.mulDisp(this);
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
    @Override
    public Var div(Var other) throws CalcException{
        return other.divDisp(this);
    }
    @Override
    public Var addDisp(Var other)throws CalcException {
        return other.add(this);
    }

    @Override
    public Var subDisp(Var other)throws CalcException {
        return other.sub(this);
    }

    @Override
    public Var divDisp(Var other)throws CalcException {
        return other.div(this);
    }

    @Override
    public Var mulDisp(Var other)throws CalcException {
        return other.mul(this);
    }

    @Override
    public Var add(Scalar other) throws CalcException{
        double[][] res = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                res[i][j] =this.value[i][j]+other.getValue();
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var sub(Scalar other) throws CalcException{
        double[][] res = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                res[i][j] =this.value[i][j]-other.getValue();
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var mul(Scalar other) throws CalcException{
        double[][] res = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = this.value[i][j]*((Scalar) other).getValue();
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var div(Scalar other)throws CalcException {
        if(other.getValue() == 0) throw new CalcException(resMan.get(Errors.ERR_D0));
        double[][] res = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = this.value[i][j]/((Scalar) other).getValue();
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var add(Matrix other) throws CalcException{
        if(this.value.length!=other.value.length|this.value[0].length!=other.value[0].length) throw new CalcException(resMan.get(Errors.ERR_MS));
        double[][] res = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                res[i][j] = other.value[i][j]+this.value[i][j];
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var sub(Matrix other) throws CalcException{
        if(this.value.length!=other.value.length|this.value[0].length!=other.value[0].length) throw new CalcException(resMan.get(Errors.ERR_MS));
        double[][] res = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                res[i][j] = this.value[i][j]-((Matrix) other).value[i][j];
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var mul(Matrix other) throws CalcException{
        if(this.value[0].length!=other.value.length) throw new CalcException(resMan.get(Errors.ERR_MC));
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

    @Override
    public Var div(Matrix other)throws CalcException {
        return super.div((Var) other);
    }

    @Override
    public Var add(Vector other)throws CalcException {
        return super.add((Var) other);
    }

    @Override
    public Var sub(Vector other)throws CalcException {
        return super.div((Var) other);
    }

    @Override
    public Var mul(Vector other)throws CalcException{
        double [] res = new double[((Vector) other).getValue().length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                res[i] += ((Vector) other).getValue()[j]*this.value[i][j];
            }
        }
        return new Vector(res);
    }

    @Override
    public Var div(Vector other)throws CalcException {
        return super.div((Var) other);
    }
}
