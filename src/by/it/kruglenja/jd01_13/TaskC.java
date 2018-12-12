package by.it.kruglenja.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static List<Double> array = new ArrayList<>();
    private static int exNum = 5;
    private static String line;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            try {
                line = sc.nextLine();
                readData();
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
    }

    private static void readData() throws Exception {
        try {
            double num = Double.parseDouble(line);
            array.add(num);
        } catch (Exception e) {
            exNum--;
            if (exNum < 0) throw e;
            Thread.sleep(100);
            printArr();
        }
    }

    private static void printArr() {
        for (int i = array.size() - 1; i >= 0; i--) {
            System.out.print(array.get(i) + " ");
        }
    }
}
