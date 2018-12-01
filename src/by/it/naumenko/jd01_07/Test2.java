package by.it.naumenko.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
//        String strMatrix = "{{1.0,2.0},{3,4.0}}";
//        Pattern pattern1 = Pattern.compile("[0-9]+,[0-9]+");
//        Matcher matcher1 = pattern1.matcher(strMatrix);
//
//        int i1 = 0;
//        int rowsCount = 0;
//        int columnsCount = 0;
//        while (matcher1.find()) {
//            rowsCount++;
//            Pattern pattern = Pattern.compile("[0-9]+");
//            Matcher matcher = pattern.matcher(matcher1.group());
//            while (matcher.find()){
//                columnsCount++;
//            }
//        }
//        matcher1.reset();
//        double[][] value = new double[rowsCount][columnsCount];
//
//        while (matcher1.find()) {
//            Pattern pattern = Pattern.compile("[0-9]+");
//            Matcher matcher = pattern.matcher(matcher1.group());
//            double[] array = new double[0];
//            int i = 0;
//            while (matcher.find()) {
//                int last = array.length;
//                array = Arrays.copyOf(array, last + 1);
//                array[i] = Double.parseDouble(matcher.group());
//                i++;
//            }
//            value[i1] = Arrays.copyOf(array, array.length);
//            i1++;
//        }
//
//        for (int i = 0; i < value.length; i++) {
//            for (int j = 0; j < value[i].length; j++) {
//                System.out.print(value[i][j]+"  ");
//            }
//            System.out.println();
//        }
    }
}
