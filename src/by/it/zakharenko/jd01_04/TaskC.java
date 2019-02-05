package by.it.zakharenko.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        //buildOneDimArray(new Scanner(System.in).nextLine());
        System.out.println(-0.0f == 0.0f); //true
        System.out.println(Float.compare(-0.0f, 0.0f) == 0 ? true : false); //false
        System.out.println(Float.NaN == Float.NaN);//false
        System.out.println(Float.compare(Float.NaN, Float.NaN) == 0 ? true : false); //true
        System.out.println(-0.0d == 0.0d); //true
        System.out.println(Double.compare(-0.0d, 0.0d) == 0 ? true : false);//false
        System.out.println(Double.NaN == Double.NaN);//false
        System.out.println(Double.compare(Double.NaN, Double.NaN) == 0 ? true : false);//true
    }


    private static double[] merge(double[] part1, double[] part2) {
        int i = 0, j = 0, k = 0;
        double[] out = new double[part1.length + part2.length];
        while (k < out.length) {
            if (i == part1.length) out[k++] = part2[j++];
            else if (j == part2.length) out[k++] = part1[i++];
            else if (part1[i] < part2[j]) out[k++] = part1[i++];
            else out[k++] = part2[j++];
        }
        return out;
    }


    private static double[] mergeSort(double[] array, int left, int right) {
        if (left == right) {
            double[] d = {array[left]};
            return d;
        }
        int halfIndex = (right + left) / 2;
        return merge(mergeSort(array, left, halfIndex), mergeSort(array, halfIndex + 1, right));
    }


    static void mergeSort(double[] array) {
        double[] sortMas = mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < sortMas.length; i++) {
            array[i] = sortMas[i];
        }
    }

    private static int binarySearch(double[] a, double val, int left, int right) {
        if (left == right) {
            if (a[left] == val) return left;
            else return -1;
        }
        int center = (left + right) / 2;
        if (a[center] == val) return center;
        else if (val > a[center]) return binarySearch(a, val, center + 1, right);
        else return binarySearch(a, val, left, center - 1);
    }

    static int binarySearch(double[] array, double value) {
        return binarySearch(array, value, 0, array.length - 1);
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%1$s[%2$ -3d]=%3$-9.4f", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i == arr.length - 1) System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        String[] sMas = line.trim().split(" ");
        double[] dMas = new double[sMas.length];
        for (int i = 0; i < sMas.length; i++) {
            dMas[i] = Double.parseDouble(sMas[i]);
        }
        double first = dMas[0];
        double last = dMas[dMas.length - 1];
        printArray(dMas, "V", 5);
        mergeSort(dMas);
        printArray(dMas, "V", 4);
        System.out.println("Index of first element=" + binarySearch(dMas, first));
        System.out.println("Index of last element=" + binarySearch(dMas, last));
        Arrays.binarySearch(dMas, first);
        /*for (int i = 0; i < dMas.length; i++) {
            if (dMas[i] == first) {
                System.out.println("Index of first element=" + i);
            }
        }
        for (int i = 0; i < dMas.length; i++) {
            if (dMas[i] == last) {
                System.out.println("Index of last element=" + i);
            }
        }*/
    }
}
