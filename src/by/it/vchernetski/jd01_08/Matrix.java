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
