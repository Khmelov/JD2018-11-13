package by.it.lobkova.jd01_05;

import java.util.ArrayList;
import java.util.List;

public class TaskC {
    static final double MIN_X_VALUE = 5.33;
    static final double MAX_X_VALUE = 9;
    static final int MIN_LENGTH_ARRAY = 20;
    static final int MAX_LENGTH_ARRAY = 40;

    public static void main(String[] args) {
        // Task C1
        double[] mas = getArray(34);
        if (mas != null) {
            printArray(mas, "A");
            printArray(getResultArray(mas), "B");
            geometricMean(getResultArray(mas));
        }

        // Task C2


    }

    static double[] getArray(int length) {
        if (length < MIN_LENGTH_ARRAY || length > MAX_LENGTH_ARRAY) {
            System.out.println("Неверная размерность массива (20-40)");
            return null;
        }

        double step = roundDouble((MAX_X_VALUE - MIN_X_VALUE) / length);
        double[] arr = new double[length];
        double z;
        int count = 0;
        for (double x = MIN_X_VALUE; x < MAX_X_VALUE; x += step) {
            x = roundDouble(x);
            z = Math.cbrt(x * x + 4.5);
            arr[count] = z;
            count++;
        }

        return arr;
    }

    static void printArray(double arr[], String name){
        int col = 0;
        System.out.println("Массив " + name +"[]");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[ %-2d ] = %-10f", i, arr[i]);
            col++;
            if(col % 5 == 0 || col == arr.length){
                System.out.println();
            }
        }
    }

    static double roundDouble(double x) {
        return Math.round(x * 1000.0 ) / 1000.0;
    }

    static double[] getResultArray(double[] arr) {
        List<Double> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 3.5) {
                arrayList.add(arr[i]);
            }
        }
        return listToArray(arrayList);
    }

    static double[] listToArray(List<Double> list) {
        int count = 0;
        double[] resultArray = new double[list.size()];
        for (double d : list) {
            resultArray[count] = d;
            count++;
        }

        return resultArray;
    }

    static void geometricMean(double[] resultArray){
        double geometricMean = 1;
        for (int i = 0; i < resultArray.length; i++) {
            geometricMean *= resultArray[i];
        }
        geometricMean /= resultArray.length;

        System.out.println("Среднее геометрическое = " + geometricMean);
    }
}