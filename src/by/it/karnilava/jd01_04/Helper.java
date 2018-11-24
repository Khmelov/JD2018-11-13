package by.it.karnilava.jd01_04;

public class Helper {


    static double findMin(double[ ] arr){
        if( 0==arr.length){
            return Double.MIN_VALUE;}
            else {
                double min=arr[0];
                for(double m:arr) {
                    if (min>m) min=m;}
                    return min;
            }
        }

    static double findMax(double[ ] arr) {
        if(0==arr.length){
            return Double.MAX_VALUE;
        }
        else {
            double max=arr[0];
            for(double m:arr){
                if (max<m) max=m;}
                return max;
            }
        }

    static void sort(double[ ] arr) {
        printMas(arr);
        boolean swap;
        double last = arr.length-1;
        do{
            swap = false;
            for(int j=0; j<last; j++){
                if (arr[j] > arr[j+1]) {
                    double buffer = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=buffer;
                    swap=true;
                }
            }
            last --;
        }
        while (swap);
        printMas(arr);

    }

    private static void printMas(double massive[]){
        for(double m:massive) System.out.print(m+ " ");
        System.out.println();
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){

        double [] z=new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                z[i]=z[i]+matrix[i][j]*vector[j];
                return z;




    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];
        for(int i=0; i<matrixLeft.length; i++)
            for(int j=0; j<matrixRight[0].length; j++)
                for(int k=0; k<matrixRight.length; k++)
                    z[i][j]=z[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                return z;

    }



    }



