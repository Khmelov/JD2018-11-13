package by.it.malishevskiy.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {

    private List<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        for (int i = 0; i < 10; i++) {
            task.grades.add((int)(Math.random()) * 10);
        }
        System.out.println(task.grades);
    }

    private void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while(iterator.hasNext()){

        }
    }
}
