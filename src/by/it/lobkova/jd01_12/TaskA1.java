package by.it.lobkova.jd01_12;

import by.it.nickgrudnitsky.jd01_04.TaskA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private static final int LIST_LENGTH = 30;
    private static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 taskA1 = new TaskA1();
        for (int i = 0; i < LIST_LENGTH; i++) {
            arrayList.add((int) (1 + Math.random() * 10));
        }

        System.out.println(arrayList);
        taskA1.clearBad(arrayList);

    }

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value < 4) {
                iterator.remove();
            }
        }
        System.out.println(grades);
    }

}

