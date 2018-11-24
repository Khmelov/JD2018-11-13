package by.it.burlakov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        buildOneDimArray("123 99 88 77 66 5 4 3 1 0 2");
    }

    private static void buildOneDimArray(String line){

        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        System.out.println(Arrays.toString(array));
        System.out.println("first element=" + binarySearch(array, first));
        System.out.println("last element=" + binarySearch(array, last));
    }

    private static void mergeSort(double[] array){

        int middle = array.length / 2;

        double[] part1 = new double[array.length / 2];
        double[] part2 = new double[array.length - middle];

        for (int i = 0; i < middle; i++) {
            part1[i] = array[i];
        }
        for (int i = 0; i < array.length - middle; i++) {
            part2[i] = array[i + middle];
        }

        double[] result = merge(mergeSort(part1, 0, middle), mergeSort(part2, middle + 1, array.length));

        for (int i = 0; i < array.length; i++) {
            array[i] = result[i];
        }
    }

    private static double[] mergeSort(double[ ] array, int left, int right){

        if(array.length < 2) {
            return array;
        }

        int middle = array.length / 2;
        double[] part1 = new double[array.length / 2];
        double[] part2 = new double[array.length - middle];

        for (int i = 0; i < middle; i++) {
            part1[i] = array[i];
        }
        for (int i = 0; i < array.length - middle; i++) {
            part2[i] = array[i + middle];
        }
        return merge(mergeSort(part1, left, middle), mergeSort(part2, middle + 1, right));
    }

    private static double[] merge(double[ ] part1, double[ ] part2){
        double[] result = new double[part1.length + part2.length];
        int p1_Index = 0;
        int p2_Index = 0;
        int res_Index = 0;

        while (p1_Index < part1.length && p2_Index < part2.length){
            if(part1[p1_Index] <= part2[p2_Index]){
                result[res_Index] = part1[p1_Index];
                p1_Index++;
            } else {
                result[res_Index] = part2[p2_Index];
                p2_Index++;
            }
            res_Index++;
        }
        while (p1_Index < part1.length){
            result[res_Index] = part1[p1_Index];
            res_Index++;
            p1_Index++;
        }
        while (p2_Index < part2.length){
            result[res_Index] = part2[p2_Index];
            res_Index++;
            p2_Index++;
        }
        return result;
    }
    
    private static int binarySearch(double[] array, double value){
        int left = 0;
        int right = array.length - 1;
        int middle;

        while(left <= right){
            middle = (left + right) / 2;
            if(array[middle] == value){
                return middle;
            } else if(array[middle] > value){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
