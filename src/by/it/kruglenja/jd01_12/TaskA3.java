package by.it.kruglenja.jd01_12;





import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        List arr= new ArrayList();
        int zeroPos = 0;
        while (!(str=sc.next()).equalsIgnoreCase("end")){
            Integer val = Integer.valueOf(str);
            if (val == 0)
                arr.add(zeroPos++, val);
            else if (val> 0)
                arr.add(zeroPos, 0);
            else
                arr.add(val);
        }
        System.out.println(arr);
    }
}
