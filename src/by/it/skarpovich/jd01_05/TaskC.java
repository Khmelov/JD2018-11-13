package by.it.skarpovich.jd01_05;

import java.util.Random;

import static java.lang.Math.pow;

class TaskC {
    public static void main(String[] args) {
        task1();
    } //Вызываем метод Task1
    /* C1. Сформировать массив[] и вывести 20-40 элементов с аргументов в заданном интервале.
    Вывести с именем индексами, а вывести элементы>3.5, вывести среднее геометрическое.*/

    private static void task1() {
        int minArrayLength = 20;                                        // Нижняя граница массива 20-40
        int maxArrayLength = 40;
        double xMin = 5.33;                                             // Нижний предел x
        double xMax = 9;
        double x;
        double sum = 0;
        final int columns = 5;                                         // Желаемое количество столблцов
        double avg = 0;                                                // Средняя геометрическая

        //Генерируем n от 20 до 40 элементов
        Random rnd1 = new Random();
        int n = minArrayLength + rnd1.nextInt(maxArrayLength + 1 - minArrayLength);
        System.out.println("Сгенерированный размер массива: " + n);

        // Создаем массив [n]
        double[] arrayA = new double[n];
        double delta = (xMax - xMin) / (n - 1);                        // Задаем шаг функции
        int c = 0;                                                     // Создаем счетчик
        for (x = xMin; x <= xMax; x += delta) {
            double z = pow((x * x + 4.5), 1.0 / 3);                    // Считаем функцию по delta
            if (c < n) {                                               // Записываем значения функции в массив
                arrayA[c] = z;
                c++;
            }
        }
        // Блок вывода массива A[])
        c = 0;
        int cB = 0;// Обнуляем счетчик
        System.out.println("Массив A[]");
        for (int i = 0; i < n; i++) {
            System.out.printf("%2s[% -3d]=%-10g", "A", i, arrayA[i]); // Выводим таблицу название(A), индекс [ i ], значение arrayA i]
            c++;
            if ((c % columns == 0) || (arrayA.length - 1 == i)) {
                System.out.println();
            }
            if (arrayA[i] > 3.5) {                                    // Считаем количество элементов >3.5
                cB++;
            }
        }
        c = 0;                                                         // Обнуляем счетчик


        // Блок массива с эелементами >3.5 (B[]). Создание

        System.out.println("Массив B[] из элементов массива A > 3.5");
        double[] arrayB = new double[cB];                              //Создаем массив размером = количеству элементов >3.5
        for (int i = 0, j = 0; i < arrayA.length; i++) {
            if (arrayA[i] > 3.5) {                                    // Присваиваем ссылки в массиве B на элементы в массиве A >3.5
                arrayB[j] = arrayA[i];
                j++;
            }
        }
        // Вывод
        for (int j = 0; j < arrayB.length; j++) {
            System.out.printf("%2s[% -3d]=%-10g", "B", j, arrayB[j]);
            c++;
            if ((c % columns == 0) || (arrayB.length - 1 == j)) {    // Модуль построения колонок
                System.out.println();
            }
            sum += arrayB[j];                                       // Cумма элементов массива со сзначениями >3.5
            avg = pow(sum, 1.0 / j);                                // Cреднее геометрическое
        }
        System.out.println("Среднее геометрическое массив B[]: " + avg); // Выводим среднее геометрическое
    }
}