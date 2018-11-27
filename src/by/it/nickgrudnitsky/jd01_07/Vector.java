package by.it.nickgrudnitsky.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {

    private double[] value;

     Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

     Vector(Vector vector) {
        this.value = vector.value;
    }

     Vector(String strVector) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(strVector);
        double[] array = new double[0];
        int i = 0;
        while (matcher.find()){
            int last = array.length;
            array = Arrays.copyOf(array, last+1);
            array[i]=Double.parseDouble(matcher.group());
            i++;
        }
        value = array;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < value.length; i++) {
            stringBuilder.append(value[i]);
            if (i != value.length-1){
                stringBuilder.append(", ");
            } else {
                break;
            }
        }
        stringBuilder.append("}");
        return new String(stringBuilder);
    }
}
