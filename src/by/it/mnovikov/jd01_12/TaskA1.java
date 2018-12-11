package by.it.mnovikov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by user on 08.12.2018.
 */
public class TaskA1 {

    private List<Integer> markList = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();


        for (int i = 0; i < 10; i++) {
            task.markList.add(1+(int)(Math.random()*10));
        }
        System.out.println(task.markList);
        task.clearBad(task.markList);
        System.out.println(task.markList);
    }

    private void clearBad(List<Integer> markList) {
        Iterator<Integer> iterator = markList.iterator();
        while (iterator.hasNext()){
            Integer value = iterator.next();
            if (value<4)
                iterator.remove();
        }
    }
}
