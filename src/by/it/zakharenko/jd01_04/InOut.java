package by.it.zakharenko.jd01_04;

import jdk.swing.interop.SwingInterOpUtils;

public class InOut {

    public static double[ ] getArray(String line) {
        //1 2 3 4 5.567
        String [] strArr=line.split("");

        double []  res=new double[strArr.length];
        for (int i=0; i<strArr.length;i++) {
            res [i] =Double.parseDouble(strArr[i]);
        }
        return res;
    }
    public static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }
    public static void printArray(double[] arr, String name, int columnCount) {
        for (int  i = 0;  i < arr.length;  i++) {
            // v[1]=12.1234
            System.out.printf("%s[%-3c]=%-7.4f", name,i, arr [i]);
            if ((i+1)%columnCount==0 || i+1==arr.length)
                System.out.println();
        }
    }
}