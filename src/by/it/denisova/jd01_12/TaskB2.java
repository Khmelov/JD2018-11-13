package by.it.denisova.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class TaskB2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        ArrayList<String> peoples1 = new ArrayList<>();
        LinkedList<String> peoples2 = new LinkedList<>();

        for (; ; ) {
            while (count > 0) {
                peoples1.add(scanner.next());
                peoples2.add(scanner.next());
                count -= 1;
            }
            break;
        }



        System.out.println(peoples1 + " ArrayList");
        System.out.println(peoples2 + " LinkedList");
        System.out.println(process(peoples1));
        System.out.println(process(peoples2));
        process(peoples1);
        process(peoples2);
    }

    public static String process(ArrayList<String> peoples) {
        peoples.trimToSize();
        double col= 0;
        Iterator<String> iter;
        while (peoples.size()!=1) {
            iter = peoples.iterator();
            while (iter.hasNext()) {
                iter.next();
                col++;
                if (col % 2 ==0 ) iter.remove();
            }

        }

        return peoples.get(0);
    }

    public static String process(LinkedList<String> peoples) {
        double col= 0;
        Iterator<String> iter;
        while (peoples.size()!=1) {
            iter = peoples.iterator();
            while (iter.hasNext()) {
                iter.next();
                col++;
                if (col % 2 ==0 ) iter.remove();
            }
        }
        return peoples.get(0);
    }
}
