package by.it.nickgrudnitsky.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;


public class TaskB3 {
    private static String process(ArrayList<String> peoples) {

        int counter = 0;
        while (peoples.size() > 1) {

            for (Iterator<String> iterator = peoples.iterator(); iterator.hasNext(); ) {
                iterator.next();
                counter++;
                if (counter % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        /*int counter = 0;
        while (peoples.size() > 1) {
            ListIterator<String> iterator = peoples.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
                counter++;
                if (counter % 2 == 0) {
                    iterator.remove();
                }
            }
        }*/
        int i = 1;
        while (peoples.size() > 1){
            for (Iterator<String> it = peoples.iterator(); it.hasNext();){ it.next();
                if (i % 2 == 0) { it.remove();}
                i++;
            }
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 1; i <= 4096; i++) {
            arrayList.add("n" + i);
            linkedList.add("n" + i);
        }

        System.out.println(arrayList + " time=");
        Timer time = new Timer();
        System.out.println(process(arrayList) + " time=" + time);
        System.out.println(linkedList + " time=");
        System.out.println(process(linkedList) + " time=" + time);
    }

    public static class Timer {
        private long iniTime;
        private Double delta;

        Timer() {
            iniTime = System.nanoTime();
        }

        @Override
        public String toString() {
            delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();
            return "Прошло " + delta.toString() + " микросекунд";
        }
    }
}
