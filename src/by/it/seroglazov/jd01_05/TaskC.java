package by.it.seroglazov.jd01_05;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        task6();
        task7();
    }

    private static void printMas(double[] mas, String name, int col) {
        for (int j = 0; j < mas.length; j++) {
            System.out.printf("%s[ %-2d] = %-9.5f", name, j, mas[j]);
            if ((j + 1) % col == 0 || j == mas.length - 1) System.out.println();
        }
    }

    private static void task6() {
        int n = 25;
        double left = 5.33;
        double right = 9;
        double dx = (right - left) / (n - 1);
        double x = left;
        double[] arrA = new double[n];
        int i = 0;
        while (x <= right) {
            arrA[i++] = pow(x * x + 4.5, 1.0 / 3);
            x += dx;
        }
        printMas(arrA, "A", 5);
        int count = 0;
        for (double v : arrA) {
            if (v > 3.5) count++;  // Calc how much are more than 3.5
        }
        //
        double[] arrB = new double[count];
        int k = 0;
        for (double a : arrA) {
            if (a > 3.5) {
                arrB[k++] = a;
            }
        }
        printMas(arrB, "B", 5);
    }

    private static void task7() {
        int[] arrA = new int[31];
        Random r = new Random();
        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = 103 + r.nextInt(348); // Random [103 - 450]
        }
        int[] arrC = new int[arrA.length];
        int j = 0;
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] * 0.1 > i) {
                arrC[j++] = arrA[i];
            }
        }
        int[] arrB = Arrays.copyOf(arrC, j);
        Arrays.sort(arrB);
        printFramedArray(arrA, 'A', 5, 12, true);
        printFramedArray(arrB, 'B', 2, 12, false);
    }

    /**
     * Print an array in special symblos frame
     *
     * @param a actual array
     * @param ch Header symbol for this array
     * @param columnsAmount how  much columns
     * @param blockLength nternal space length of every cell in symbols. 12 is recomended
     * @param horiz if true - indexes will be grow from left to right; if false - from up to down
     */
    private static void printFramedArray(int[] a, char ch, int columnsAmount, int blockLength, boolean horiz) {
        char vl = '\u2551'; // Vertical line ║
        String ul = TablStr.getUpLine(columnsAmount, blockLength); // Up line
        String cl = TablStr.getCenterLine(columnsAmount, blockLength); // Center line
        String dl = TablStr.getDownLine(columnsAmount, blockLength); // Down line
        String blank = TablStr.getBlankLine(blockLength);
        System.out.print("Array ");
        System.out.println(ch);
        System.out.print(ul);
        int rowAmount = a.length / columnsAmount + 1; // int
        int counter = 0;
        int index;
        for (int row = 0; row < rowAmount; row++) {
            for (int i = 0; i < columnsAmount; i++) {
                System.out.print(vl);
                if (horiz) {
                    if (counter < a.length)
                        System.out.printf(" %c[%2d]=% -4d ", ch, counter, a[counter++]);
                    else
                        System.out.print(blank);
                } else {
                    index = i * rowAmount + row;
                    if (index < a.length)
                        System.out.printf(" %c[%2d]=% -4d ", ch, index, a[index]);
                    else
                        System.out.print(blank);
                }
            }
            System.out.println(vl);
            if (row != rowAmount - 1) System.out.print(cl);
        }
        System.out.print(dl);
    }

}



























