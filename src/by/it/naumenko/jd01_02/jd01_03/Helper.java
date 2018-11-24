package by.it.naumenko.jd01_02.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void sort(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    double buf = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = buf;
                }
            }
        }
        for (double element : arr) {
            System.out.print(element + " ");
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] mas = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                mas[i] += matrix[i][j] * vector[j];
            }
        }
        return mas;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] mas = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    mas[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return mas;
    }
}
