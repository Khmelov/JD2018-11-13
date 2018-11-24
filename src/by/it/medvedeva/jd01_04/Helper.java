package by.it.medvedeva.jd01_04;

import java.util.Arrays;

public class Helper {
    /**
     *
     * @param arr
     * @return минимум массива arr
     */
    static double findMin(double[ ] arr){
        double min=arr[0];
        for (double m: arr){
            if (min>m) min=m;}
        return min;

        }


    /**
     *
     * @param arr
     * @return максимум массива arr
     */
    static double findMax(double[ ] arr){
        double max=arr[0];
        for (double m: arr){
            if (max<m) max=m;}
        return max;

    }

    /**
     *
     * @param arr
     */
    static void sort (double[ ] arr){
        Arrays.sort(arr);


    }

    /**
     *
     * @param matrix
     * @param vector
     * @return результат умножения матрицы на вектор
     */
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] z =new double[matrix.length];
        for (int k = 0; k <matrix.length ; k++)
            for (int j = 0; j <vector.length ; j++)
            z[k]=z[k]+matrix[k][j]*vector[j];
            return z;

    }

    /**
     *
     * @param matrixLeft
     * @param matrixRight
     * @return результат умножения матрицы на матрицу
     */

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][]z=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i <matrixLeft.length ; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k <matrixRight.length ; k++)
                z[i][j]=z[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                return z;

        }

    }





