package by.it.seroglazov.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        if (arr.length > 0) {
            double min = arr[0];
            for (double v : arr) {
                if (v < min) min = v;
            }
            return min;
        } else {
            return Double.MAX_VALUE;
        }
    }

    static double findMax(double[] arr) {
        if (arr.length > 0) {
            double max = arr[0];
            for (double v : arr) {
                if (v > max) max = v;
            }
            return max;
        } else {
            return Double.MIN_VALUE;
        }
    }

    static void sort(double[] arr) {
        boolean wasShift;
        int len = arr.length - 1;
        do {
            wasShift = false;
            for (int i = 0; i < len; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                    wasShift = true;
                }
            }
            len--;
        } while (wasShift);
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        if (matrixLeft.length == 0 || matrixRight.length == 0) return new double[0][0];
        double[][] matrixOut = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            if (matrixLeft[i].length != matrixRight.length) return new double[0][0];
            for (int j = 0; j < matrixRight[0].length; j++) {
                double sum = 0;
                for (int k = 0; k < matrixLeft[i].length; k++) {
                    sum += matrixLeft[i][k] * matrixRight[k][j];
                }
                matrixOut[i][j] = sum;
            }
        }
        return matrixOut;
    }

    static double[] mul(double[][] matrix, double[] vector) {
        if (matrix.length == 0 && vector.length == 0) return new double[0];
        double[] out = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != vector.length) return new double[0];
            double sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j] * vector[j];
            }
            out[i] = sum;
        }
        return out;
    }
}






















