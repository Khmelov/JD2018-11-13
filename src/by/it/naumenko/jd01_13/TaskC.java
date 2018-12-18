package by.it.naumenko.jd01_13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    static LinkedList<String> strings = new LinkedList<>();
    static LinkedList<Double> numbers = new LinkedList<>();
    static int count = 0;

    static void readData() throws Exception {
        try {
            Double num = Double.parseDouble(strings.getLast());
            numbers.addFirst(num);
        }
        catch (Exception e) {
            count++;
            if (count >= 5) throw e;
            Thread.sleep(100);
            for (Double element : numbers) {
                System.out.print(element + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s;
        while (true){
            s = scanner.next();
            strings.add(s);
            try {
                readData();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
