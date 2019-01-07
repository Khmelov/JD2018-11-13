package by.it.kruglenja.jd01_04;

import by.it.kruglenja.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

import by.it.kruglenja.jd01_03.InOut;

/**
 * Created by user on 22.11.2018.
 */
public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        buildOneDimArray(s);
    }

    private static double[] merge(double[] left, double[] right) {
        int i = 0, j = 0, k = 0;
        double[] out = new double[left.length + right.length];
        while (k < out.length) {
            if (i == left.length) {
                out[k++] = right[j++];
            } else if (j == right.length) {
                out[k++] = left[i++];
            } else if (left[i] < right[j]) {
                out[k++] = left[i++];
            } else out[k++] = right[j++];
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


    private static void mergeSort(double[] array) {
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
        else if (val > a[center]) {
            return binarySearch(a, val, center + 1, right);
        } else return binarySearch(a, val, left, center - 1);
    }

    private static int binarySearch(double[] array, double value) {
        return binarySearch(array, value, 0, array.length - 1);
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%1$s[%2$ -3d]=%3$-9.4f", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i == arr.length - 1) System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];

        printArray(array, "V", 5);
        mergeSort(array);
        printArray(array, "V", 4);
        System.out.println("Index of first element=" + binarySearch(array, first));
        System.out.println("Index of last element=" + binarySearch(array, last));
    }
}

