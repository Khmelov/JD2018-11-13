package by.it.naumenko.jd01_02.jd01_05;

import java.util.Random;

import static java.lang.StrictMath.pow;

public class TaskC2 {

    static double[] getMas(int razmer, int nachZn, int conZn) {
        double[] mas = new double[razmer];
        Random rnd = new Random();
        for (int i = 0; i < mas.length; i++) {
            mas[i]=rnd.nextInt(nachZn)+conZn-nachZn;
        }
        return mas;
    }

    static void printArray(double[] array, String name, int col) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
           // System.out.printf("+-------------+\n");
            System.out.printf("%s[%- 3d]=% -3.1f    ", name, i, array[i]);
            //System.out.printf("+-------------+\n");
            k++;
            if ((k % col == 0) || (k == array.length))
                System.out.println();
        }
    }



    static double[] mergeSort(double[] array) {
        if (array.length > 1) {
            double[] left = leftHalf(array);
            double[] right = rightHalf(array);

            mergeSort(left);
            mergeSort(right);

            double[] mas=merge(left, right);
            for (int i = 0; i < array.length; i++) {
                array[i]=mas[i];
            }
        }
        return array;
    }

    public static double[] leftHalf(double[] array) {
        int size1 = array.length / 2;
        double[] left = new double[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }
    public static double[] rightHalf(double[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        double[] right = new double[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

    private static double[] merge(double[] part1, double[] part2) {
        double[]result=new double[part1.length+part2.length];
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (i2 >= part2.length || (i1 < part1.length && part1[i1] <= part2[i2])) {
                result[i] = part1[i1];
                i1++;
            } else {
                result[i] = part2[i2];
                i2++;
            }
        }
        return result;
    }

    static int kolNewMas(double[] array){
        int kol=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]*0.05>i)
                kol++;
        }
        return kol;
    }

    static double[] arrayB(double[] array, int razmerB){
        double[] mas = new double[razmerB];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]*0.05>i) {
                mas[k] = array[i];
                k++;
            }
        }
        return mas;
    }


    public static void main(String[] args) {

        double[] array = getMas(31,103,450);
        printArray(array,"A",4);
        System.out.println("--------------------------------------------------------------------");

        int razmerB = kolNewMas(array);
        System.out.println(razmerB);
        double[] arrayB = arrayB(array,razmerB);
        arrayB = mergeSort(arrayB);
        printArray(arrayB,"B",4);
    }
}
