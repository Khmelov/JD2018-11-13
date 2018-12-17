package by.it.markelov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private List<Integer> grades=new ArrayList<Integer>();

    public static void main(String[] args) {
        TaskA1 obj= new TaskA1();

        for (int i = 0; i < 10; i++) {
            obj.grades.add((int) (Math.random()*10+1));
        }
        System.out.println(obj.grades);
        obj.clearBad(obj.grades);
        System.out.println(obj.grades);
    }

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> it = grades.iterator();
        while (it.hasNext()){
            if (it.next()<4)
                it.remove();
        }
    }
}
