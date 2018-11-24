package by.it.kruglenja.jd01_03;

public class Helper {
    static  double findMin(double[]arr){
        double minVal = 0;
        for (double anArr : arr) {
            if (anArr < minVal){
                minVal = anArr;
            }
        }
        System.out.println("minVal = " + minVal);
        System.out.println();
        return minVal;
    }
    static  double findMax(double[]arr){
        double maxVal = 0;
        for (double anArr : arr) {
            if (anArr > maxVal){
                maxVal = anArr;
            }
        }System.out.println("maxVal = " + maxVal);
        System.out.println();

        return maxVal;
    }
   public static void sort(double[]arr){
        double temp = 0;
        boolean flag1 = true;
        while (flag1) {
            flag1 = false;
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    flag1 = true;
                }
            }
        }

            for (double anArr : arr) {
                System.out.print(anArr + " ");
            }
        System.out.println();

        }

    static double[] mul(double[][]matrix, double[]vector){
        double[] multMV = new double[matrix.length];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                multMV[i] = multMV[i] + matrix[i][j] * vector[j];
            }
        }
        return multMV;
    }
    static double[][]mul(double[][]matrixLeft, double[][]matrixRight){
        double[][] mul = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    mul[i][j] = mul[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        for (int i = 0; i < mul.length; i++) {
            for (int j = 0; j < mul[i].length; j++) {
                System.out.printf("[% -7.1f] ", mul[i][j]);
            }
            System.out.println();
        }
        return mul;
    }

}