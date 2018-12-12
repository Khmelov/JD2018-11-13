package by.it.vchernetski.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> arr= new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input;
        int posz=0;
        while(!((input=sc.next()).equalsIgnoreCase("end"))){
            Integer value = Integer.valueOf(input);
            if(value>0)arr.add(posz++,value);
            else if(value==0) arr.add(posz,0);
                else arr.add(value);
        }
        System.out.println(arr);
    }
}
