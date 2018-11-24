package by.it.markelov.jd01_04;

public class InOut {
    /**
     *метод для преобразования строки в массив тип double
     *@param line исходная строка
     *@return m выходной одномерный массив
     */
    static double[] getArray(String line) {
        String trim = line.trim();
        String[] split = trim.split(" ");
        double m[] = new double[split.length];
        for (int i = 0; i < split.length; i++) {
            m[i] = Double.parseDouble(split[i]);

        }
        return m;
    }

    /**
     * метод для вывода массива на консоль
     * @param arr входной одномерный массив
     */
    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");

        }
        System.out.println();
    }

    /**
     * метод для форматированного вывода массива на консоль
     * @param arr входной одномерный массив
     * @param name выводимое имя массива
     * @param columnCoun количество столбцов при выводе
     */
    static void printArray(double[] arr, String name, int columnCoun) {
        int col=0;
        for (int i = 0; i <arr.length; i++) {
            System.out.printf("%s[%d]=%-7.2f     ", name, i, arr[i]);
            col++;
            if (col % columnCoun == 0) System.out.println();
        }
        System.out.println("\n");
    }
}


