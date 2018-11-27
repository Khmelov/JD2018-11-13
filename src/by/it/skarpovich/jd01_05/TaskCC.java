package by.it.skarpovich.jd01_05;

import java.util.Random;

import static java.lang.Math.pow;

public class TaskCC {
    public static void main(String[] args) {
        task2();
    }

    private static void task2() {
        int size = 31;
        int randElement;
        int xMin = 103;                                             // Нижний предел x
        int xMax = 450;
        int c = 0;

        final int columns = 5;                                         // Желаемое количество столблцов
        Random rnd = new Random();
        int[] arrayA = new int[size];
        for (int i = 0; i < size; i++) {
            randElement = xMin + rnd.nextInt(xMax + 1 - xMin);
            arrayA[i] = randElement;
        }

        int cB = 0;//
        System.out.println("Массив A[]");
        System.out.println("------------------------------------------------------------------------------");
        for (int i = 0; i < size; i++) {

            System.out.printf("|%4s[%2d]=%-6d", "A", i, arrayA[i]); // Выводим таблицу название(A), индекс [ i ], значение arrayA i]
            c++;

            if ((c % columns == 0) || (arrayA.length - 1 == i)) {
                System.out.println();
            }
            double k = 0.1 * arrayA[i];
            if (k > i) {
                cB++;
            }

        }
        c = 0; // Обнуляем счетчик
        // Блок массива с эелементами >3.5 (B[]). Создание
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Массив B[]");
        int[] arrayB = new int[cB];                              //Создаем массив размером = количеству элементов >3.5
        for (int i = 0, j = 0; i < arrayA.length; i++) {
            double k=0.1*arrayA[i];
            if (k > i) {                                    // Присваиваем ссылки в массиве B на элементы в массиве A >3.5
                arrayB[j] = arrayA[i];
                j++;
            }
        }
        for (int j = 0; j < arrayB.length; j++) {
            System.out.printf("|%4s[%2d]=%-6d", "B", j, arrayB[j]);
            c++;
            if ((c % columns == 0) || (arrayB.length - 1 == j)) {

                System.out.println();
            }
        }
    }
}


