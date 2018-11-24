package by.it.burlakov.jd01_03;

public class InOut {
    /**
     * Получение массива из строки
     * @param line - строка чисел через пробел
     * @return массив чисел типа double
     */
    static double[] getArray(String line){

        String[] stringsArr = line.trim().split(" ");

        double[] result = new double[stringsArr.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = Double.parseDouble(stringsArr[i]);
        }
        return  result;
    }
    /**
     * Печать массива
     * @param arr - массив чисел типа double
     */
    static void printArray(double[]arr){
        for (double element : arr) {
            System.out.println(element + " ");
        }
    }
    /**
     * Печать массива с заданным именем и кол-вом колонок
     * @param arr - массив чисел типа double
     * @param name - имя массива
     * @param columnCount - количестово колонок
     */
    static void printArray(double[ ] arr, String name, int columnCount){
        int col = 0;
        for (int i = 0; i < arr.length; i++) {

            // v[ 0 ]=-123.678
            System.out.printf("%s[% -3d]=%-10.5f", name, i, arr[i]);
            col++;
            if(col % columnCount == 0 || col == arr.length){
                System.out.println();
            }
        }
    }
}
