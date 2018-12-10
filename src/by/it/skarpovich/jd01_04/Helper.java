package by.it.skarpovich.jd01_04;

public class Helper {

    //Задание B1. Найти максимум массива arr, созданного в методе getArray класса InOut, вернуть значение.
    static double findMin(double[] arr) {
        if (arr.length == 0) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double i : arr) {
                if (min > i) min = i;
            }
            return min;
        }
    }

    //Задание B2. Найти максимум массива arr, созданного в методе getArray класса InOut, вернуть значение.
    static double findMax(double[] arr) {
        if (arr.length == 0) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double i : arr) {
                if (max < i) max = i;
            }
            return max;
        }
    }

    //Задание B3. Отсортировать по максимуму массив arr, созданный в методе getArray класса InOut.
    static void sort(double[] arr) {
        System.out.println("Вывод массива, отсортированного по максимуму:");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    double m = arr[i];
                    arr[i] = arr[j];
                    arr[j] = m;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    //Задание C1. Выполнить произведение матрицы matrix на вектор vector (заданы в ConsoleRunner), вернуть значение.
    static double[] mul(double[][] matrix, double[] vector) {
        double[] matrixtoVector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                matrixtoVector[i] = matrixtoVector[i] + matrix[i][j] * vector[j];
            }
        }

        for (int i = 0; i < matrixtoVector.length; i++) {
            System.out.println(matrixtoVector[i]);
        }
        System.out.println();
        return matrixtoVector;
    }

    //Задание C2. Выполнить произведение матрицы matrixLeft на матрицу matrixRight (заданы в ConsoleRunner), вернуть значение.
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] matrixToMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {

                for (int k = 0; k < matrixRight.length; k++) {
                    matrixToMatrix[i][j] = matrixToMatrix[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        for (int i = 0; i < 3; i++, System.out.println()) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrixToMatrix[i][j] + " ");
            }
        }
        System.out.println();
        return matrixToMatrix;
    }
}
