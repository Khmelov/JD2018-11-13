package by.it.karnilava.jd01_04;

import java.util.Scanner;

public class TaskC {
    static void buildOneDimArray(String line) {

        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);
        InOut.printArray(array, "V", 4);

        System.out.println("Index of first element=" + binarySearch(array, first));
        System.out.println("Index of last element=" + binarySearch(array, last));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void mergeSort(double[] array) {
        double[] sortedArray = mergeSort1(array);
        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }

    private static double[] mergeSort1(double[] array) {
        double[] l;
        double[] r;

        if (array.length % 2 == 0) {
            l = new double[array.length / 2];
        } else {
            l = new double[(array.length + 1) / 2];
        }

        System.arraycopy(array, 0, l, 0, l.length);
        r = new double[array.length / 2];
        System.arraycopy(array, l.length, r, 0, r.length);
        double[] sortL;
        double[] sortR;
        if (l.length > 1) {
            sortL = mergeSort1(l);
        } else {
            sortL = l;
        }
        if (r.length > 1) {
            sortR = mergeSort1(r);
        } else {
            sortR = r;
        }
        return merge(sortL, sortR);
    }

    private static double[] merge(double[] arrayL, double[] arrayR) {
        double[] array = new double[arrayL.length + arrayR.length];
        int lIndex = 0;
        int rIndex = 0;
        for (int i = 0; i < array.length; i++) {
            boolean ifL = lIndex < arrayL.length;
            boolean ifR = rIndex < arrayR.length;
            double lValue = ifL ? arrayL[lIndex] : 0;
            double rValue = ifR ? arrayR[rIndex] : 0;
            if (ifL && ifR) {
                if (lValue > rValue) {
                    array[i] = rValue;
                    rIndex++;
                } else {
                    array[i] = lValue;
                    lIndex++;
                }
            }
            if (!ifL) {
                array[i] = rValue;
                rIndex++;
            }
            if (!ifR) {
                array[i] = lValue;
                lIndex++;
            }
        }
        return array;
    }

    static int binarySearch(double[] array, double value) {
        int index = -1;
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (value == array[mid]) {
                index = mid;
                break;
            } else {
                if (value <= array[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return index;
    }
}

