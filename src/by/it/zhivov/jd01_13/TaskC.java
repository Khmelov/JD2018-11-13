package by.it.zhivov.jd01_13;

import java.util.LinkedList;
import java.util.Scanner;

public class TaskC {
    static LinkedList<String> listString = new LinkedList<>();
    static LinkedList<Double> listDouble = new LinkedList<>();
    static int error = 0;

    static void readData() throws InterruptedException {
        try {
            Double value = Double.parseDouble(listString.getLast());
            listDouble.addFirst(value);
        } catch (NumberFormatException e) {
            error++;
            if (error > 5) throw e;
            Thread.sleep(100);
            for (Double dvalue : listDouble) {
                System.out.print(dvalue + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        for (; ; ) {
            input = sc.next();
            listString.add(input);
            try {
                readData();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}