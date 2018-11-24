package by.it.mnovikov.jd01_03;

/**
 * Created by user on 19.11.2018.
 */

public class Helper {
    static double findMin(double[] arr) {
        double min = arr[0];
        for (double element : arr
                ) {
            if (element < min) min = element;
        }
        System.out.println("min = " + min);
        return min;
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (double element : arr
                ) {
            if (element > max) max = element;
        }
        System.out.println("max = " + max);
        return max;
    }

    static void sort(double[] arr) {
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;
                }
            }
            last--;
        } while (swap);
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++) {
                z[i] += matrix[i][j] * vector[j];
            }
        return z;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    z[i][j] += matrixLeft[i][k] * matrixRight[k][j];
        return z;
    }
}