package by.it.naumenko.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        String strMatrix = "{{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0},{12,25,40}}";
        strMatrix=strMatrix.replaceAll("[},{]"," ");
        strMatrix=strMatrix.trim();
        String[] mas = strMatrix.split("\\s{3,}");
        String [] masCol=mas[0].split("\\s+");//узнать количество столбцов
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i]+"      ");
        }
        int rowCount = mas.length;
        int colCount = masCol.length;
        System.out.println("\n"+mas.length);
        System.out.println(masCol.length);
        double massiv[][]=new double[rowCount][colCount];
        for (int i = 0; i < mas.length; i++) {
            String massivel[]=mas[i].split("\\s+");
            for (int j = 0; j <massivel.length ; j++) {
                massiv[i][j]=Double.parseDouble(massivel[j]);
            }
        }

        for (int i = 0; i < massiv.length; i++) {
            for (int j = 0; j < massiv[i].length; j++) {
                System.out.print(massiv[i][j]+" ");
            }
            System.out.println();
        }
//

//
//        for (int i = 0; i < mas.length; i++) {
//            System.out.printf("mas[%d]=%s   ",i,mas[i]);
//        }
//        System.out.println("\n"+mas.length);

    }
}
