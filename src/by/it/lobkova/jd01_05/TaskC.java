package by.it.lobkova.jd01_05;

public class TaskC {
    static final double MIN_X_VALUE = 5.33;
    static final double MAX_X_VALUE = 9;

    public static void main(String[] args) {
        printArray(getArray(34), "A");
        printArray(getResultArray(getArray(34)), "B");
    }

    static double[] getArray(int length) {
        if (length < 20 || length > 40) {
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
            System.out.printf("%-4s[ %-2d ] = %-10f", name, i, arr[i]);
            col++;
            if(col % 5 == 0 || col == arr.length){
                System.out.println();
            }
        }
    }

    static double roundDouble(double x) {
        return Math.round(x * 1000.0 ) / 1000.0;
    }

    static double[] getResultArray(double[] arr){
        int count = 0;
        double[] resultArr = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>= 3.5){
                resultArr[count] = arr[i];
                count++;
            }
        }
        return resultArr;
    }

}
