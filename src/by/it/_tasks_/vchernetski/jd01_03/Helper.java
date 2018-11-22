package by.it._tasks_.vchernetski.jd01_03;

public class Helper {
    /**
     *
     * @param arr масиив в котором надо найти минимальное значени
     * @return возвращает минимальный член массива типа double
     */
    static double findMin(double[ ] arr){
        double min=0;
        for (double v : arr) {
            if(v<min) min=v;
        }
        return min;
    }

    /**
     *
     * @param arr массив в котором надо найти максимальное значение
     * @return возвращает максимальный члtн массива типа double
     */
    static double findMax(double[ ] arr){
        double max=0;
        for (double v : arr) {
            if(v>max) max=v;
        }
        return max;
    }
    static void sort(double[ ] arr) {
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 1; j <arr.length ; j++) {
                if(arr[j]<arr[j-1]){
                    double temp;
                    temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] fin= new double[matrix.length];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <vector.length ; j++) {
                fin[i]+=matrix[i][j]*vector[j];
            }
        }
        return fin;
    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] fin = new double[matrixLeft.length][matrixRight[0].length];
        System.out.println(matrixLeft.length+" "+matrixRight[0].length);
        for (int i = 0; i <matrixLeft.length ; i++) {
            int x=0;
            for (int j = 0; j <matrixRight[i].length ; j++) {
                int count=0;
                while(count<matrixLeft[0].length){
                fin[i][j]+=matrixLeft[i][count]*matrixRight[count][x];
                count++;
                }
                x++;
                System.out.println(fin[i][j]);
            }
        }
        return fin;
    }
}
