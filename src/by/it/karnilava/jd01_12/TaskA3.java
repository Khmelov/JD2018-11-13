package by.it.karnilava.jd01_12;


import java.util.*;

public class TaskA3 {
    private static List<Integer> negative = new ArrayList<>();
    private static List<Integer> nulevoy = new ArrayList<>();
    private static List<Integer> positive = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();


        while (!str.equals("end")) {
            int a = Integer.parseInt(str);
            if (a < 0) {
                negative.add(a);
            }
            if (a == 0) {
                nulevoy.add(a);
            }
            if ((a > 0)) {
                positive.add(a);
            }
            str = scan.nextLine();
        }

        System.out.println(negative);
        System.out.println(nulevoy);
        System.out.println(positive);
        List<Integer> result = new ArrayList<>();
        result.addAll(positive);
        result.addAll(nulevoy);
        result.addAll(negative);
        System.out.println(result);


    }
}
