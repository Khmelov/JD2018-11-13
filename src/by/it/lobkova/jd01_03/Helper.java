package by.it.lobkova.jd01_03;

public class Helper {

    static void sort(double[] arr) {
        boolean swap;
        double last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] >= arr[i + 1]) {
                    double buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
    }

    static double findMin(double[] arr) {
        double min = arr[0];
        for (double elem : arr) {
            if (elem <= min) min = elem;
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (double elem : arr) {
            if (elem >= max) max = elem;
        }
        return max;
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i] += matrix[i][j] * vector[j];
            }
        }
        return z;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    z[i][j] += matrixLeft[i][k] * matrixRight[k][j];

                }

            }

        }
        return z;
    }
}

