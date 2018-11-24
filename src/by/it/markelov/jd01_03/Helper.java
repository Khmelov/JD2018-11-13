package by.it.markelov.jd01_03;

import java.util.Arrays;

public class Helper {
    /**
     * метод для поиска мин. значения элементов массива
     * @param arr исходный массив
     * @return min минимальное значение элементов массива
     */
    static double findMin(double[] arr) {
        if (arr.length == 0) System.out.println("Массив пуст");
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        System.out.println();
        return min;
    }

    /**
     * метод для поиска макс. значения элементов массива
     * @param arr исходный массив
     * @return max максимальное значение элементов массива
     */
    static double findMax(double[] arr) {
        if (arr.length == 0) System.out.println("Массив пуст");
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println();
        return max;
    }

    /**
     * метод для сортировки элементов массива по возрастанию
     * @param arr исходный массив
     */
    static void sort(double[] arr) {
        if (arr.length == 0) System.out.println("Массив пуст");
        Arrays.sort(arr);
    }

    /**
     * метод для умножения матрицы на вектор
     * @param matrix матрица-множитель
     * @param vector вектор-множитель
     * @return newvector вектор-результат
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] newvector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                newvector[i] += matrix[i][j] * vector[j];
            }
        }
        return newvector;

    }

    /**
     * метод для умножения матрицы на матрицу
     * @param matrixLeft матрица-множитель1
     * @param matrixRight матрица-множитель2
     * @return newmatrix матрица-результат
     */
    static double[ ][ ] mul(double[ ][ ] matrixLeft,  double[ ][ ] matrixRight) {
        double [] [] newmatrix=new double[matrixLeft.length] [matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    newmatrix [i] [j] += matrixLeft[i][k]*matrixRight[k][j];
                }

            }
        }
        return newmatrix;
    }
}





