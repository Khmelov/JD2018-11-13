package by.it.skarpovich.jd01_03;

class InOut {

    /* Задание A1. Преобразовать строки чисел, введенных с клавиатуры в одномерный
    массив arr[] типа double, вернуть значение. */
    static double[] getArray(String line) {
        line = line.trim();
        String[] stringArray = line.split(" ");
        double[] arr = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            arr[i] = Double.parseDouble(stringArray[i]);
        }
        return arr;
    }

    /* Задание A2. Вывод преобразованной строки чисел в виде массива типа double. */
    static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /* Задание A3. Вывод массива arr[] в виде таблицы с именами 'name', количеством колонок columnCount при помощи printf. */
    static void printArray(double[] arr, String name, int columnCount) {
        int column = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(name);
            System.out.printf("[% -3d]=%-9.4f", i, arr[i]);
            column++;
            if ((column % columnCount == 0) || (arr.length - 1 == i)) {
                System.out.println();
            }
        }
    }

}








