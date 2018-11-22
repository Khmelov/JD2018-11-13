package by.it.naumenko.jd01_02.jd01_04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TaskC {

    static int binarySearch(double[] array, double value) {
        int l = 0;
        int r = array.length;
        int count = 0;
        //int m=0;
        while (l <= r) {
            count++;
            int m = (l + r) / 2;
            if (array[m] == value)
                return m;
            else {
                if (array[m] > value)
                    r = m - 1;
                else
                    l = m + 1;
            }
        }
        return -1;
    }

    static void mergeSort(double[] array) {
        if (array.length > 1) {
            double[] left = leftHalf(array);
            double[] right = rightHalf(array);

            mergeSort(left);
            mergeSort(right);

            merge(left, right);
        }

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

    private static void mergeSort(double[] array, int left, int right) {
        if (array.length == 0)
            return;
        if (left == right)
            return;
        //if (left<right)
        int m = (left + right - 1) / 2;
        double opora = array[m];
        int i = left;
        int j = right;
        while (i <= j) {
            while (array[i] < opora)
                i++;
            while (array[j] > opora)
                j--;
            if (i <= j) {
                double buf = array[i];
                array[i] = array[j];
                array[j] = buf;
                i++;
                j--;
            }
        }
        if (left < j)
            mergeSort(array, left, j);
        if (right > i)
            mergeSort(array, i, right);

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

    static void buildOneDimArray(String line) {

        double[] array = InOut.getArray(line);
//        InOut.printArray(array, "V", 5);
//        System.out.println("____________________________________________________________________");
//        Helper.sort(array);
//        InOut.printArray(array, "V", 5);
//        System.out.println("____________________________________________________________________");
//        array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array, 0, array.length - 1);
        //mergeSort(array);
        InOut.printArray(array, "V", 5);
        System.out.println("first element=" + binarySearch(array, first));
        System.out.println("last element=" + binarySearch(array, last));


    }

    public static void main(String[] args) {
        buildOneDimArray("-2.310827638481257 14.876159483727324 7.662856079541147 9.225516084847108 10.725368644381923 7.909606308398793 -3.6335505176061442 -0.4000595278305603 8.226360816015205 13.197203542702404 13.840364190147707 4.6725045400184655 -4.918078711688857 5.548748291130764 2.323033748122562");
        //buildOneDimArray("123 99 88 77 66 5 4 3 1 0 2");
        //String line = "-2.310827638481257 14.876159483727324 7.662856079541147 9.225516084847108 10.725368644381923 7.909606308398793 -3.6335505176061442 -0.4000595278305603 8.226360816015205 13.197203542702404 13.840364190147707 4.6725045400184655 -4.918078711688857 5.548748291130764 2.323033748122562";
        //double[] array = InOut.getArray(line);
        //mergeSort(array,0,array.length-1);

    }
}
