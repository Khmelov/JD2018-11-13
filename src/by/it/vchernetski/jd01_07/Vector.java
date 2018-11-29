package by.it.vchernetski.jd01_07;

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
}
