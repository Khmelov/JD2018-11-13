package by.it.naumenko.jd01_02.jd01_05;

import java.util.Random;

import static java.lang.StrictMath.*;

public class TaskC {
    static double[] getMas(int razmer, double nachZn, double conZn) {
        double[] mas = new double[razmer];
        double delta = (conZn - nachZn) / (double) razmer;
        for (int i = 0; i < mas.length; i++) {
            mas[i] = pow((nachZn * nachZn + 4.5), (1 / 3.0));
            nachZn += delta;
        }
        return mas;
    }

    static void printArray(double[] array, String name, int col) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%- 3d]=% -3.5f    ", name, i, array[i]);
            k++;
            if ((k % col == 0) || (k == array.length))
                System.out.println();
        }
    }

    static int razmerNewMas(double[] array, double serch) {
        int col = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > serch) {
                col++;
            }
        }
        return col;
    }

    static double[] newMas(double[] array, double serch, int col) {
        //int col = 0;
        int k = 0;
        double[] mas = new double[col];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > serch) {
                mas[k] = array[i];
                k++;
            }
        }
        return mas;
    }

    static double geometrZnach(double[] array) {
        double sum = 1;
        for (int i = 0; i < array.length; i++) {
            sum *= array[i];
        }
        //System.out.println(sum);
        return pow(sum, (1.0 / array.length));
        //return sum;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int razmer = rnd.nextInt(20) + 40 - 20;
        System.out.println(razmer);
        double[] array = getMas(razmer, 5.33, 9.0);

        System.out.println("Массив A[]");
        printArray(array, "A", 5);
        int razmerNewMas = razmerNewMas(array, 3.5);
        double[] newMas = newMas(array, 3.5, razmerNewMas);

        System.out.println("Массив B[] из элементов массива A > 3.5");
        printArray(newMas, "B", 5);

        double rezultat = geometrZnach(newMas);
        System.out.printf("сумма = %1.4f", rezultat);
    }
}
