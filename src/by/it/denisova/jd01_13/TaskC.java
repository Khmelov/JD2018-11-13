package by.it.denisova.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
   static ArrayList<Double> numbers = new ArrayList<>();
   static int countException = 0;
   static String input;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       while (scanner.hasNext()) {
           input = scanner.nextLine();
           try {
               readData();
           }
           catch (Exception e) {
               System.out.println(e.getMessage());
           }
       }
    }

    private static void readData() throws Exception{
        try {
            double number = Double.parseDouble(input);
            numbers.add(number);
        }
        catch (Exception e) {
            countException++;
            if (countException > 5){
                throw e;
            }
            Thread.sleep(100);
            printList();
        }
    }

    private static void printList() {
        for (int i = numbers.size() -1; i >= 0; i--) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}
