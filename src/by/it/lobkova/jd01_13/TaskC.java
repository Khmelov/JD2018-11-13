package by.it.lobkova.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    static String inputData;
    static ArrayList<Double> numbers = new ArrayList<>();
    static int exceptionCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                inputData = scanner.nextLine();
                try {
                    readData();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
    }

    static void readData() throws Exception {
        try {
            double number = Double.parseDouble(inputData);
            numbers.add(number);
        } catch (Exception e) {
            exceptionCount++;
            if (exceptionCount > 5) {
                throw e;
            }
            Thread.sleep(100);
            printList();
        }
    }

    static void printList() {
        for (int i = numbers.size() - 1; i >= 0; i--) {
            System.out.print(numbers.get(i) + " ");

        }
    }
}