package by.it.karnilava.jd01_12;

import java.util.*;

public class TaskA1 {
    private static List<Integer> marks = new ArrayList<>(10);


    public static void main(String[] args) {



        for (int i = 0; i < 10; i++) {


            marks.add(new Random().nextInt(10)+1);
        }


        System.out.println(marks);
        new TaskA1().clearBad(marks);

    }
    void clearBad(List<Integer> grades){
        grades.removeIf(integer -> integer < 4);
        System.out.println(grades);

    }
}
