package by.it.burlakov.jd01_04;

/**
 * Created by user on 20.11.2018.
 */
public class Helper {

    public static void sort(double[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for(int k = i + 1; k < arr.length; k++){
                if(arr[k] < arr[i]){
                    double tmp = arr[k];
                    arr[k] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

}
