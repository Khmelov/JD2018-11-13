package by.it.markelov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();

        Scanner scr = new Scanner(System.in);
        String line = scr.nextLine();
        buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

//    static void buildOneDimArray(String line) {
//        double array[] = InOut.getArray(line);
//        double first = array[0];
//        double last = array[array.length - 1];
//        InOut.printArray(array, "V", 5);
//        Helper.sort(array);
//        InOut.printArray(array, "V", 4);
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == first) {
//            System.out.println("Index of first element=" + i);
//            break;
//            }
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == last) {
//            System.out.println("Index of last element=" + i);
//            break;
//            }
//        }
//    }
//}

    static void buildOneDimArray(String line) {
// формируем из строки массив типа double
        line.trim();
        String masString[] = line.split(" ");
        double masDouble[] = new double[masString.length];
        for (int i = 0; i < masString.length; i++) {
            masDouble[i] = Double.parseDouble(masString[i]);
        }
//выводим на консоль в 5 колонок
        int col = 0;
        String name="V";
        for (int i = 0; i < masDouble.length; i++) {
            System.out.printf("%s[%3d]=%-6.2f ", name, i, masDouble[i]);
            col++;
            if (col % 5 == 0) System.out.println();
        }
        System.out.println("\n");
//сохраняем значения первого и последнего элемента массива перед сортировкой
        double firstElemeht = masDouble[0];
        double lastElemeht = masDouble[masDouble.length - 1];
        System.out.println("Первый и последний элементы исходного массива: " + firstElemeht + " " + lastElemeht);
        System.out.println();
//сортируем массив
        Arrays.sort(masDouble);
//выводим на консоль в 4 колонки
        col = 0;
        for (int i = 0; i < masDouble.length; i++) {
            System.out.printf("%s[%3d]=%-6.2f ", name, i, masDouble[i]);
            col++;
            if (col % 4 == 0) System.out.println();
        }
        System.out.println("\n");
//вычисляем новые (после сортировки) индексы первого и последнего элемента
//исходного массива и выводим их на консоль
        for (int i = 0; i < masDouble.length; i++) {
            if (masDouble[i] == firstElemeht) System.out.println("Index of first element=" + i);
            if (masDouble[i] == lastElemeht) System.out.println("Index of last element=" + i);
        }
    }
}

