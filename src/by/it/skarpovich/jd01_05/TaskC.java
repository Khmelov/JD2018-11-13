package by.it.skarpovich.jd01_05;

import java.util.Random;

import static java.lang.Math.pow;

class TaskC {
    public static void main(String[] args) {
        task1();
    }

    static void task1() {
        int minArrayLength = 20;
        int maxArrayLength = 40;
        double minArrayElement = 5.33;
        double maxArrayElement = 9.0;
        double sum = 0;
        int counter = 0;
        int counter2 = 0;
        final int columns = 5;
        double avg;

        Random rnd1 = new Random();
//        int n = minArrayLength + rnd1.nextInt(maxArrayLength + 1 - minArrayLength);
//        //System.out.println("Длина массива: " + n);
        int n = 28;
        //Создаем массив
        double[] arrayA = new double[n];
        for (int i = 0; i < n; i++) {
            double x = minArrayElement + Math.random() * (maxArrayElement + 1 - minArrayElement);
            double z = pow(x * x + 4.5, 1.0 / 3);
            arrayA[i] = z;
        }
        //Выводим массив в 5 колонок.

        //int counter = 0;
        System.out.println("Массив A[]");
        for (int i = 0; i < arrayA.length; i++) {
            System.out.printf("%2s[% -3d]=%-10g", "A", i, arrayA[i]);
            counter++;
            if ((counter % columns == 0) || (arrayA.length - 1 == i)) {
                System.out.println();
            }

        }

        System.out.println("Массив B[] из элементов массива A > 3.5");
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] > 3.5) {

                System.out.printf("%2s[% -3d]=%-10g", "B", i, arrayA[i]);
                counter2++;
                if ((counter2 % columns == 0) || (arrayA.length - 1 == i)) {
                    System.out.println();
                }
                sum += arrayA[i];
            }

        }
        avg = pow(sum, 1.0 / counter2);
        System.out.println();
        System.out.println("Среднее геометрическое массив B[]: " + avg);

    }

}

