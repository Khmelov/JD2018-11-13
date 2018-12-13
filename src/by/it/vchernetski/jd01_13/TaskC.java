package by.it.vchernetski.jd01_13;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class TaskC {
    private static LinkedList<String> list = new LinkedList<>();
    private static LinkedList<Double> list2 = new LinkedList<>();
    private static int countermistakes = 0;
    private static void readData() throws Exception{
        try{
               Double d=Double.parseDouble(list.getLast());
               list2.addFirst(d);
            }
            catch (Exception e){
                countermistakes++;
                if(countermistakes>5) throw e;
                Thread.sleep(100);
                for (Double d: list2) {
                    System.out.print(d+" ");
                }
            }
        }
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String input;
        while(true) {
            input = sc.next();
            list.add(input);
            try {
                readData();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
