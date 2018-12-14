package by.it.vchernetski.jd01_12;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {
    static String process(ArrayList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> i = peoples.iterator();
            while (i.hasNext()) {
                i.next();
                if (count % 2 == 0) i.remove();
                count++;
            }
        }
        return peoples.get(peoples.size() - 1);
    }

    static String process(LinkedList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> i = peoples.iterator();
            while (i.hasNext()) {
                i.next();
                if (count % 2 == 0) i.remove();
                count++;
            }
        }
        return peoples.get(peoples.size() - 1);
    }
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        LinkedList<String> list2 = new LinkedList<>();
        for (int i = 1; i <= 78; i++) {
            list1.add("n" + i);
            list2.add("n" + i);
        }
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(process(list1));
        System.out.println(process(list2));
    }
}
