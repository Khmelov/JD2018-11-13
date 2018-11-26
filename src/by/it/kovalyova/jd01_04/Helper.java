package by.it.kovalyova.jd01_04;

import java.util.Arrays;

public class Helper {

    static double findMin(double[] arr) {
        double min = arr[0];
        for (double m : arr) {
            if (min > m) min = m;
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (double m : arr) {
            if (max < m) max = m;
        }
        return max;

    }

    static void sort(double[] arr) {
        Arrays.sort(arr);
    }

        static double[ ] mul(double[ ][ ] matrix, double[ ] vector) {
            double[] z =new double[matrix.length];
            for (int k = 0; k <matrix.length ; k++)
                for (int j = 0; j <vector.length ; j++)
                    z[k]=z[k]+matrix[k][j]*vector[j];
                return z;

                }
        static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
            double[][]z=new double[matrixLeft.length][matrixRight[0].length];
            for (int i = 0; i <matrixLeft.length ; i++)
                for (int j = 0; j <matrixRight[0].length ; j++)
                    for (int k = 0; k <matrixRight.length ; k++)
                        z[i][j]=z[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                        return z;
                    }

                }













