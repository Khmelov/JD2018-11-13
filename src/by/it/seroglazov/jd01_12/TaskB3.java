package by.it.seroglazov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB3 {

    private static String processCommon(List<String> peoples){
        Iterator<String> it = peoples.iterator();
        int c = 1;
        while (true) {
            if (it.hasNext()) {
                it.next();
                if (c++ % 2 == 0) it.remove();
            } else {
                if (peoples.size() == 1) return peoples.get(0);
                else it = peoples.iterator();
            }
        }
    }

    static String process(ArrayList<String> peoples) {
        return processCommon(peoples);
    }

    static String process(LinkedList<String> peoples) {
        return processCommon(peoples);
    }

    static String processQueue(LinkedList<String> peoples){
        String str = "";
        int i = 1;
        while (peoples.size() > 0) {
            if (i++ % 2 == 0){
                peoples.add(peoples.remove()); // Перемещаем из начала в конец очереди
            } else peoples.remove();
        }
        return str;
    }

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();
        for (int i = 1; i <= 4096; i++) {
            arr.add("n" + i);
            list.add("n" + i);
            list2.add("n" + i);
        }
        long t1 = System.nanoTime();
        String a = process(arr);
        long t2 = System.nanoTime();
        String b = process(list);
        long t3 = System.nanoTime();
        String c = processQueue(list2);
        long t4 = System.nanoTime();
        System.out.println(a + " - ArrayList "+(t2-t1)/1000 + " мкс");
        System.out.println(b + " - LinkedList "+(t3-t2)/1000 + " мкс");
        System.out.println(b + " - LinkedList Queue "+(t4-t3)/1000 + " мкс"); // Иногда быстрее иногда нет



        /*n1 - ArrayList 8185 мкс
          n1 - LinkedList 3289 мкс

        Быстрее работает LinkedList - он быстрее удаляет, так как просто переписывает связи,
        а ArrayList должен копировать весь остаток массива справа от удаляемого элемента*/


    }

}
