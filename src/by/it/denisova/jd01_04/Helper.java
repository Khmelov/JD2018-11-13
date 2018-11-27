package by.it.denisova.jd01_04;

 class Helper {






    static double findMin(double[] arr) {
        double min;
        if (0 == arr.length)
            return Integer.MAX_VALUE;
        else {
            min = (int) arr[0];
            for (double i : arr)
                if (min > i) {
                    min = i;
                }
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max;
        if (0 == arr.length)
            return Integer.MAX_VALUE;
        else {
            max = (int) arr[0];
            for (double i : arr)
                if (max < i) {
                    max = i;
                }
        }
        return max;
    }

    static  void sort (double[] arr){
       boolean swap;
        int last = arr.length-1;
        do{ swap = false;
        for (int i = 0; i<last; i++)
            if( arr[i] > arr[i+1]) {
                double buffer = arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=buffer;
                swap=true;
            }
            last--;

        }
        while (swap);
        System.out.println(arr);

    }


    static double[] mul(double matrix[][], double vector[]) {

        double [] z = new double[matrix.length];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <vector.length; j++) {
                z[i] += matrix[i][j] * vector[j];
            }
        }

        return z;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double [][] y = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i <matrixLeft.length ; i++) {
            for (int j = 0; j <matrixLeft[0].length ; j++) {
                for (int k = 0; k <matrixRight.length ; k++) {
                    y[i][j] = y[i][j]+ matrixLeft[i][j]*matrixRight[k][i];

                    
                }
            }
            
        }
        return y;
    }

}
