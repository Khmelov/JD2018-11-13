package by.it.seroglazov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private ArrayList<Integer> rates = new ArrayList<Integer>();

    void clearBad(List<Integer> grades){
        grades.removeIf(x -> x < 4);
    }

    public static void main(String[] args) {
        TaskA1 ta1 = new TaskA1();
        for (int i = 0; i < 10; i++) {
            ta1.rates.add((int) (Math.random()*10) + 1);
        }
        System.out.println(ta1.rates);
        ta1.clearBad(ta1.rates);
        System.out.println(ta1.rates);
    }
}
