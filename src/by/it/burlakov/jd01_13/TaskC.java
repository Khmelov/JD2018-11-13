package by.it.burlakov.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    static private Scanner scanner;

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        readData();
    }
    private static void readData() throws Exception {
        int count = 0;
        ArrayList<Double> list = new ArrayList<>();
       while(true){
            try {
                double number = Double.parseDouble(scanner.nextLine());
                list.add(number);
            } catch (NumberFormatException e){
                Thread.sleep(100);
                for (int i = 0; i < list.size() ; i++) {
                    System.out.print(list.get(list.size() - i - 1) + " ");
                }
                count++;
                if(count == 5){
                    throw new Exception(e);
                }
            }
        }
    }
}