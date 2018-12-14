package by.it.malishevskiy.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> arr=new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String str;
        int pos=0;
        while (!(str = scan.next()).equals("end")) {
            Integer value = Integer.valueOf(str);
            if (value>0) {
                arr.add(pos++, value);
            }
            else if (value==0) {
                arr.add(pos, 0);
            }
            else {
                arr.add(value);
            }
        }
        System.out.println(arr);
    }
}