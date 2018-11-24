package by.it.baidak.jd01_03;

public class Helper {

    /**
     *
     * @param arr исходный массив
     * @return min сохраняет минимальное значение в массиве
     */
    static double findMin(double[ ] arr){
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min) min = arr[i];
        }
        return min;
    }

    /**
     *
     * @param arr исходный массив
     * @return max сохраняет максимальное значение в массиве
     */
    static double findMax(double[ ] arr){
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }

    public static void sort(double[ ] arr){
        boolean swap = false;
        do {swap = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i + 1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;
                }
            }
        } while(swap);
    }
}
