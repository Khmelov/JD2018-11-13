package by.it.burlakov.jd01_12;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        String[] peoples = {"Иванов", "Петров", "Сидоров", "Семенов", "Кузнецов", "Кабанов", "Дроздов"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(peoples));
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(peoples));


        System.out.println(process(arrayList));
        System.out.println(process(linkedList));
    }

    static String process(ArrayList<String> peoples){
        int i = 1;
        while (peoples.size() > 1){
            for (Iterator<String> it = peoples.iterator(); it.hasNext();){ it.next();
                if (i % 2 == 0) { it.remove();}
                i++;
            }
        }
        return  peoples.get(0);
    }

    static String process(LinkedList<String> peoples){
        int i = 1;
        while (peoples.size() > 1){
            Iterator<String> iterator = peoples.iterator();
            while(iterator.hasNext()){
                iterator.next();
                if (i % 2 == 0) {
                    iterator.remove();
                }
                i++;
            }
        }
        return  peoples.get(0);
    }
}