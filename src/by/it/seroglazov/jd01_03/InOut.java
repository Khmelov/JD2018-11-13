package by.it.seroglazov.jd01_03;

import java.util.Scanner;

/**
 * The class InOut provides methods for getting double array from string
 * and printing this array two ways in System.out
 * @author Renat Serahlazau
 */
public class InOut {

    /**
     * Преобразует строку в массив типа double значений
     * содержащихся в строке и разделенных пробелами
     * @param line - исходная строка
     * @return double[] - массив значений из исходной строки
     */
    public static double[] getArray(String line) {
        String strMas[] = line.trim().split(" ");
        double mas[] = new double[strMas.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Double.parseDouble(strMas[i]);
        }
        return mas;
    }

    /**
     * Печатает в консоль массив через пробел
     * @param arr - массив, который надо напечатать
     */
    public static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%1$s[%2$ -3d]=%3$-9.4f", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i == arr.length - 1) System.out.println();
        }
    }
}


















