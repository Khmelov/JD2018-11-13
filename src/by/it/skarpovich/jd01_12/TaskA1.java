package by.it.skarpovich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    List<Integer> pupils = new ArrayList<>();

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iter = grades.iterator();
        while (iter.hasNext()) {
            int grade = iter.next();
            if (grade < 4) {
                iter.remove();
            }
        }
        //grades.removeIf(i -> i < 4); - !!! Решение с лямбдой
    }

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        for (int i = 0; i < 20; i++) {
            task.pupils.add((int) (1 + Math.random() * 10));
        }
        System.out.println(task.pupils);
        task.clearBad(task.pupils);
        System.out.println(task.pupils);
    }


}



