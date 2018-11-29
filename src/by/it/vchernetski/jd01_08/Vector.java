package by.it.vchernetski.jd01_08;

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
