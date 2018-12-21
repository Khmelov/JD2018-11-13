package by.it.naumenko.jd01_15;

import java.io.*;

public class TaskA {
    //программа
    public static void main(String[] args) throws IOException {
        int[][] arr = new int[6][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 31 - 15);
            }
        }
        writeMatrix(arr);
        readMatrix();
    }
    /*Многострочный
    комментарий*/

    //метод чтения матрицы из файлав консоль
    private static void readMatrix() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(Util.getPath("Matrix.txt")))) {
            while (bufferedReader.ready())
                System.out.println(bufferedReader.readLine());
        }
    }

    /**метод записи матрицы в файл
     *
     * @param arr
     * @throws IOException
     */
    private static void writeMatrix(int[][] arr) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(Util.getPath("Matrix.txt"))
        )) {
            for (int[] ints : arr) {
                for (int element : ints) {
                    printWriter.printf("%3d ", element);
                }
                printWriter.println();
            }
        }
    }
    /*
    private static void writeMatrix(int[][] arr) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(Util.getPath("Matrix.txt"))
        )) {
            for (int[] ints : arr) {
                for (int element : ints) {
                    printWriter.printf("%3d ", element);
                }
                printWriter.println();
            }
        }
    }*/
}
