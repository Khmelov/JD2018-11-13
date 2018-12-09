package by.it.seroglazov.jd01_11;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {

        /*ListB<Integer> la = new ListB<>();
        la.add(10);
        la.add(12);
        la.add(8);
        la.add(3);
        System.out.println(la);
        ListB<Integer> la2 = new ListB<>();
        la2.add(100);
        la2.add(200);
        System.out.println(la2);
        la.addAll(la2);
        System.out.println(la);

        ListB<String> l2 = new ListB<>(3);
        l2.add("Привет");
        l2.add("Меня");
        l2.add("Зовут");
        l2.add("Ренат");
        l2.add("Порошок");
        l2.add("Уходи");
        System.out.println(l2);
        String str = l2.set(3, "Колян");
        System.out.println(l2);
        System.out.println(str);
        l2.add(4, "Ренатович");
        System.out.println(l2);*/

        SetC<Integer> s = new SetC<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(1);
        s.add(5);
        s.add(6);
        s.add(7);
        s.add(8);
        System.out.println(s);
        s.remove(5);
        s.remove(9);
        System.out.println(s);

        ArrayList<Integer> lb = new ArrayList<>();
        lb.add(0);
        lb.add(2);
        lb.add(7);
        lb.add(16);
        System.out.println(lb);
        System.out.println(s.containsAll(lb));
        s.removeAll(lb);
        System.out.println(s);
        s.add(0);
        s.add(2);
        s.add(7);
        s.add(16);
        System.out.println(s);
        System.out.println(s.containsAll(lb));

    }
}
