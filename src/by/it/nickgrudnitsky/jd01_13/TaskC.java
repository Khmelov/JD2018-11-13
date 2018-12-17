package by.it.nickgrudnitsky.jd01_13;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            data = scanner.next();
            try {
                readData();
            } catch (Exception e) {
                for (Double aDouble : arrayList) {
                    System.out.print(aDouble + " ");
                }
                break;
            }
        }
    }

    private static String data;
    private static List<Double> arrayList = new LinkedList<>();
    private static int errCounter = 0;

    private static void readData() throws Exception {
        try {
            Double number = Double.valueOf(data);
            ((LinkedList<Double>) arrayList).addFirst(number);
        } catch (Exception e) {
            if (errCounter == 4) throw e;
            Thread.sleep(100);
            errCounter++;
        }
    }
}
