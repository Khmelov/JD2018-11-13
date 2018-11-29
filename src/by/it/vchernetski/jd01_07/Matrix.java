package by.it.vchernetski.jd01_07;

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
        Matcher m = Pattern.compile("\\d+\\p{Punct}[^\\{}]").matcher(strvalue);
        int counter = 0;
        while(m.find()) {
            counter++;
        }
        StringBuilder[] mas = new StringBuilder[counter];
        counter = 0;
        m.reset();
        while (m.find()){
            mas[counter++] = new StringBuilder(m.group());
        }
        m = Pattern.compile("(\\d+[\\.\\d+]?)").matcher(mas[0]);
        counter=0;
        while (m.find()){
            counter++;
        }
        value= new double[mas.length][counter];
        for (int i = 0; i < value.length; i++) {
            m = Pattern.compile("(\\d+[\\.\\d+]?)").matcher(mas[i]);
            counter =0;
            while (m.find()){
                value[i][counter++]=Double.parseDouble(m.group());
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
