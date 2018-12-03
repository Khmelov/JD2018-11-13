package by.it.malishevskiy.jd01_03;

import java.util.Arrays;

import java.util.Scanner;

public class Helper {
    public static void main(String[] args) {
            double[] arr = new double[7];
            int i = 0;
            Scanner scanner = new Scanner(System.in);
            for (double element : arr)
            {
                System.out.print("Введите " + (i + 1) + "-й элемент массива: ");
                arr[i] = scanner.nextInt();

                System.out.println(arr[i] + " - ");

                i++;
            }
            System.out.println(Arrays.toString(arr));

            findMin(arr);
            findMax(arr);
            sort(arr);
            double[] vector = {1, 2, 3};
            double [][] matrix = {{1, 2, 3}, {4,5,6}};
            double [][] matrixLeft = {{1, 2, 3}, {4, 5, 6}};
            double [][] matrixRight = {{2, 3, 4}, {5, 6, 7}};
            mul(matrix, vector);
            mul(matrixLeft, matrixRight);
        }

        static double findMin(double[ ] arr){
            double min = arr[0];
            for (double element : arr) {
                if (element < min) min = element;
            }
            System.out.println("Минимум массива равен " + min);

            return min;
        }

    static double findMax(double[ ] arr){
        double max = arr[0];
        for (double element : arr) {
            if (element > max) max = element;
        }
        System.out.println("Максимум массива равен " + max);

        return max;
    }
    static void sort(double[] arr){
        Arrays.sort(arr);
        for(int i = 0; i <  arr.length; i++) {
            System.out.print(arr[i] + "  ");
    }
  }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i] = z[i] + matrix[i][j] * vector[j];
            }
        }
        return z;
    }

    static double[ ][ ] mul(double[][] matrixLeft, double[ ][ ] matrixRight){
        double [][] z = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++){
            for (int j = 0; j < matrixRight[0].length; j++){
                for (int k = 0; k < matrixRight.length; k++){
                    z[i][j] = z[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }

            }
        }
        return z;
    }


}





