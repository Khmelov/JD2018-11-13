package by.it._task_.jd01_03;
import java.util.Arrays;

public class Helper {
    public static double findMin(double[ ]arr){
        if(0==arr.length){
            return Double.MAX_VALUE;
        }else {
            double min = arr[0];
            //min = (int)(min);
            for(double m :arr){
                if(min>m) min = m;
            }
            return min;

        }
    }

    public static double findMax(double[ ]arr){
        if(0==arr.length){
            return Double.MAX_VALUE;
        }else {
            double max = arr[0];
            for(double m :arr){
                if(m>max) max= m;
            }
            return max;

        }
    }

    public static void sort(double[ ]arr){
        Arrays.sort(arr);
    }
}
