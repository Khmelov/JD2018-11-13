package by.it.karnilava.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    private static List<Double> list = new ArrayList<>();
    private static int counter = 0;
    private static Scanner scanner;

    static void readData() throws Exception {
        try {



            String line = scanner.nextLine();

            double a = Double.parseDouble(line);
            list.add(a);

        } catch (NumberFormatException e) {
            Thread.sleep(100);

            counter = counter + 1;
            if (counter == 6) {
                throw e;

            }
            for (int i = list.size() - 1; i >= 0; i--) {
                if (i != list.size() - 1) {
                    System.out.print(" ");
                }
                System.out.print(list.get(i));

            }
            System.out.println();



        }
    }

    public static void main(String[] args) throws Exception {

        scanner = new Scanner(System.in);
        while (true) {
            readData();
        }



    }


}
