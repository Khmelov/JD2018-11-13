package by.it.nickgrudnitsky.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        TaskA.printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        TaskA.buildOneDimArray(line);

    }
    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int i1 = 2; i1 < 10; i1++) {
                System.out.printf("%d*%d=%-3d", i, i1, i * i1);
            }
            System.out.println();
        }
    }

    //Tasr 2
    static void buildOneDimArray(String line) {
        double[] array = TaskA.getArray(line);
        TaskA.printArray(array, "V", 5);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        TaskA.sort(array);
        TaskA.printArray(array, "V", 4);
        int newFirstElement = TaskA.getFirstElementIndex(array, firstElement);
        int newLastElement = TaskA.getLastElementIndex(array, lastElement);
        System.out.println("Index of first element=" + newFirstElement);
        System.out.println("Index of last element=" + newLastElement);

    }

    static double[] getArray(String line) {
        String[] strArray = line.split(" ");
        double[] result = new double[strArray.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Double.parseDouble(strArray[i]);
        }
        return result;
    }

    static void printArray(double[] array, String name, int columncount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, array[i]);
            if ((i + 1) % columncount == 0 || i + 1 == array.length) {
                System.out.println();
            }
        }
    }

    static void sort(double[] array) {
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    double buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    swap = true;
                }
            }
        } while (swap);
    }

    static int getFirstElementIndex(double[] array, double firstElement) {
        int a = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstElement) {
                a = i;
            }
        }
        return a;
    }

    static int getLastElementIndex(double[] array, double lastElement) {
        int a = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == lastElement) {
                a = i;
            }
        }
        return a;
    }
}
