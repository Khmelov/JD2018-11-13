package by.it.mnovikov.jd01_04;

/**
 * Created by user on 20.11.2018.
 */
public class Helper {
    static double findMin(double[] arr) {
        if (arr.length == 0) {
            return Double.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double element : arr) {
                if (element < min) {
                    min = element;
                }
            }
            return min;
        }
    }

    static double findMax(double[] arr) {
        if (arr.length == 0) {
            return Double.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double element : arr
                    ) {
                if (element > max) {
                    max = element;
                }
            }
            return max;
        }
    }

    static void sort(double[] arr) {
        int last = arr.length - 1;
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i + 1] < arr[i]){
                    double temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                    swap = true;
                }
            }
            last--;
        } while (swap);
    }

}
