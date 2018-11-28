package by.it.skarpovich.jd01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        //A1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа в одну строку через пробел:");
        String keyboardLine = scanner.nextLine();
        double[] arr = InOut.getArray(keyboardLine);
        System.out.println();
        //A2
        System.out.println("Вывод преобразованной строки чисел в виде массива arr[] типа double:");
        InOut.printArray(arr);
        System.out.println();
        System.out.println();
        //A3
        System.out.println("Введите имя 'name' для массива arr[]:");
        String name = scanner.nextLine();
        System.out.println();

        System.out.println("Введите количество колонок:");
        Integer columnCount = scanner.nextInt();
        System.out.println();

        System.out.println("Вывод одномерного массива arr[] с именем:" + name + " и количеством колонок:" + columnCount + " в таблицу:");
        InOut.printArray(arr, name, columnCount);
        System.out.println();
        //B1
        System.out.println("Вывод минимума массива arr[]:");
        Helper.findMin(arr);
        System.out.println(Helper.findMin(arr));
        System.out.println();
        //B2
        System.out.println("Вывод максимума массива arr[]:");
        Helper.findMax(arr);
        System.out.println(Helper.findMax(arr));
        System.out.println();
        //B3
        System.out.println("Вывод отсортированного массива arr[] по возрастанию:");
        Helper.sort(arr);
        System.out.println();
        System.out.println();

        //C1
        double[][] matrix = {
                {-2, 1, 0},
                {4, 2, 1},
                {-1, 4, 0},
        };
        double[] vector = {-1, 3, 1};

        System.out.println("Вывод произведения матрицы на вектор:");
        Helper.mul(matrix, vector);

        //C2
        double[][] matrixLeft = {
                {-1, 4, 0},
                {4, 0, 1},
                {-1, 5, 0},

        };
        double[][] matrixRight = {
                {-1, 2, 0},
                {2, 2, 5},
                {-3, 1, 0},

        };
        System.out.println("Вывод произведения матрицы на матрицу:");
        Helper.mul(matrixLeft, matrixRight);
        System.out.println();

    }
}

// Второй способ ввода с клавиатуры
//    public static String consoleReadLine () throws IOException {
//        InputStreamReader iStreamReader = new InputStreamReader(System.in);
//        BufferedReader line = new BufferedReader(iStreamReader);
//        String out = line.readLine();
//        return out;

