package by.it.skarpovich.jd01_04;

import java.util.Scanner;

class TaskA {
    public static void main(String[] args) {
        printMulTable();
        System.out.println("Введите числа в одну строку через пробел:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        //double[] arr = InOut.getArray(line); спросить!

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

    public static void buildOneDimArray(String line) {
        double[] arr = InOut.getArray(line);
        double start = arr[0];
        double end = arr[arr.length - 1];

        InOut.printArray(arr, "V", 5);
        Helper.sort(arr);
        InOut.printArray(arr, "V", 4);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == start) System.out.println("Index of first element="+i);
            if (arr[i] == end) System.out.println("Index of last element="+i);

        }
    }
}


