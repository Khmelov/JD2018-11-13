package by.it.zhivov.jd01_04;

import java.util.Arrays;

public class Helper {
    public static void main(String[] args) {
        double[] mass = {1, 2, 3, 4, 5, 6, -4.5};
        findMin(mass);
    }

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
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void sort(double[] arr) {
        Arrays.sort(arr);
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] fin = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                fin[i] += matrix[i][j] * vector[j];
            }
        }
        return fin;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] fin = new double[matrixLeft.length][matrixRight[0].length];
        System.out.println(matrixLeft.length + " " + matrixRight[0].length);
        for (int i = 0; i < matrixLeft.length; i++) {
            int x = 0;
            for (int j = 0; j < matrixRight[i].length; j++) {
                int count = 0;
                while (count < matrixLeft[0].length) {
                    fin[i][j] += matrixLeft[i][count] * matrixRight[count][x];
                    count++;
                }
                x++;
                System.out.println(fin[i][j]);
            }
        }
        return fin;
    }

}
