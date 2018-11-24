package by.it.karnilava.jd01_05;


import java.util.Scanner;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        int length = scanner.nextInt();
        int length = 28;

        double[] array = new double[length];
        double x = 5.33;
        double delta = (9 - 5.33) / length;

        for (int i = 0; i < length; i++) {
            array[i] = pow((pow(x, 2) + 4.5), 1.0 / 3);
            x = x + delta;

        }

        System.out.println("Массив A[]");
        InOut.printArray(array, "A", 5);
        System.out.println();

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] > 3.5) {
                count++;
            }
        }

        double[] mas = new double[count];
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] > 3.5) {
                mas[j] = array[i];
                j++;
            }
        }
        System.out.println("Массив B[] из элементов массива A > 3.5");
        InOut.printArray(mas, "B", 5);
        System.out.println();

        double multy = 1;
        for (int i = 0; i < count; i++) {
            multy = mas[i] * multy;

        }
        double avg = pow(multy, 1.0 / count);
        System.out.println(avg);


    }

}





