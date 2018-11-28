package by.it.mnovikov.jd01_05;

import java.util.ArrayList;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        ArrayList<Double> nums = new ArrayList<>();
        for (double x = 5.33; x <= 9; x += 0.1) {
            double z = pow(pow(x, 2) + 4.5, 1.0 / 3);
            nums.add(z);
        }

        ArrayList<Double> nums2 = new ArrayList<>();
        for (double elem : nums
                ) {
            if (elem > 3.5) nums2.add(elem);
        }

        int line = 5;
        int count = 0;
        System.out.println("Массив A[]");
        for (int i = 0; i < nums.size(); i++) {
            System.out.printf("A[ %-2d] = %g    ", i, nums.get(i));
            count++;
            if (count % line == 0 || count == nums.size()) System.out.println();
        }
        System.out.println("Массив B[] из элементов массива A > 3.5");
        for (int i = 0; i < nums2.size(); i++) {
            System.out.printf("B[ %-2d] = %g    ", i, nums2.get(i));
            count++;
            if (count % line == 0 || count == nums2.size()) System.out.println();
        }
    }
}
