package by.it.nickgrudnitsky.jd01_03;


public class Helper {
    static double findMax(double[] array) {
        double max = array[0];
        for (double element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    static double findMin(double[] array) {
        double min = array[0];
        for (double element : array) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    static void sort(double[] array) {
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    double buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    swap = true;
                }
            }
        } while (swap);
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        if (matrix[0].length != vector.length) {
            System.out.println("Error");
        } else {
            for (int i = 0; i < matrix.length; i++) {
                for (int i1 = 0; i1 < vector.length; i1++) {
                    result[i] = result[i] + matrix[i][i1] * vector[i1];
                }
            }
        }
        return result;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        if (matrixLeft[0].length != matrixRight.length) {
            System.out.println("Error");
        } else {
            for (int i = 0; i < matrixLeft.length; i++) {
                for (int i1 = 0; i1 < matrixRight[0].length; i1++) {
                    for (int i2 = 0; i2 < matrixRight.length; i2++) {
                        result[i][i1] = result[i][i1] + matrixLeft[i][i2] * matrixRight[i2][i1];
                    }
                }
            }
        }
        return result;
    }
}


