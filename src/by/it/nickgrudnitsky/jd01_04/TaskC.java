package by.it.nickgrudnitsky.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        TaskC.buildOneDimArray(line);
    }

    static void mergeSort(double[] array) {
        int left = 1;
        int right = array.length;
        TaskC.mergeSort(array, left, right);
    }

    private static double[] mergeSort(double[] array, int left, int right) {
        int midle = right / 2;
        if (right < 2) {
            return array;
        }
        double[] leftArray = new double[midle];
        double[] rightArray = new double[right - midle];
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array[i];
        }
        for (int i = midle; i < right; i++) {
            rightArray[i - midle] = array[i];
        }
        TaskC.mergeSort(leftArray, left, midle);
        TaskC.mergeSort(rightArray, midle, right - midle);
        TaskC.merge(leftArray, rightArray, array);
        return array;
    }

    private static double[] merge(double[] part1, double[] part2, double[] array) {
        int i1 = 0, i2 = 0, a = 0;
        while (i1 < part1.length && i2 < part2.length) {
            if (part1[i1] < part2[i2]) {
                array[a] = part1[i1];
                a++;
                i1++;
            } else {
                array[a] = part2[i2];
                a++;
                i2++;
            }
        }
        while (i2 < part2.length) {
            array[a] = part2[i2];
            a++;
            i2++;
        }
        while (i1 < part1.length) {
            array[a] = part1[i1];
            a++;
            i1++;
        }
        return array;
    }

    static int binarySearch(double[] array, double value) {
        int right = array.length - 1;
        int midleIndex = right;
        while (array[midleIndex] != value) {
            if (array[midleIndex] < value) {
                midleIndex = (right + midleIndex) / 2;
            } else {
                right = midleIndex;
                midleIndex = right / 2;
            }
        }
        return midleIndex;
    }

    /*static int binarySearch(double[] array, double value) {
        int index = -1;
        double midleElement = array[array.length / 2];
        if (midleElement <= value) {
            int left = array.length / 2;
            int right = array.length;
            index = TaskC.binarySearch(array, value, left, right);
        } else {
            int left = 0;
            int right = array.length / 2 - 1;
            index = TaskC.binarySearch(array, value, left, right);
        }
        return index;
    }

    static int binarySearch(double[] array, double value, int left, int right) {
        int index = -1;
        double midleElement = array[(right - left) / 2 + left];
        if (midleElement < value) {
            int left1 = array.length / 2;
            int right1 = array.length;
            index = TaskC.binarySearch(array, value, left1, right1);
            return index;
        } else {
            if (midleElement > value) {

                int left1 = 0;
                int right1 = (right - left) / 2 + left;
                index = TaskC.binarySearch(array, value, left1, right1);
                return index;
            } else {
                if (midleElement == value) {
                    index = (right - left) / 2 + left;
                    return index;
                }
            }
        }
        return index;
    }*/

    static void buildOneDimArray(String line) {
        double[] array = TaskC.getArray(line);
        TaskC.printArray(array, "V", 5);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        TaskC.mergeSort(array);
        TaskC.printArray(array, "V", 4);
        int newFirstElement = TaskC.binarySearch(array, firstElement);
        int newLastElement = TaskC.binarySearch(array, lastElement);
        System.out.println("Index of first element=" + newFirstElement);
        System.out.println("Index of last element=" + newLastElement);

    }

    static double[] getArray(String line) {
        String[] strArray = line.split(" ");
        double[] result = new double[strArray.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Double.parseDouble(strArray[i]);
        }
        return result;
    }

    static void printArray(double[] array, String name, int columncount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, array[i]);
            if ((i + 1) % columncount == 0 || i + 1 == array.length) {
                System.out.println();
            }
        }
    }
}
