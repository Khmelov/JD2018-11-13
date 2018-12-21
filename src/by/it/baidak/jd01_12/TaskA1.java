package by.it.baidak.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by user on 08.12.2018.
 */
public class TaskA1 {

    private ArrayList<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {

        TaskA1 currentClass = new TaskA1();
        currentClass.clearBad(currentClass.grades);
        for(int i = 0; i <10;i++){
            currentClass.grades.add(1 + (int) (Math.random() * 10));
        }
        System.out.println(currentClass.grades);
        currentClass.clearBad(currentClass.grades);
        System.out.println(currentClass.grades);
    }

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next < 4) iterator.remove();
        }
    }
}
