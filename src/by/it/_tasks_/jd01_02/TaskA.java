package by.it._tasks_.jd01_02;

import java.util.Scanner;
//
public class TaskA {
    public static void main(String[] args) {
        System.out.println("Введите данные в масив согластно ТЗ" + "\n10 целых чисел через пробел");
        Scanner scanner = new Scanner(System.in);
        /*        1. Добавил объект класс Scanner
                  2. Назначил имя объекта scanner
                     Идентификатор scanner ссылается
                     на объект класса Scanner
                  3. Назначил входной поток данных System.in
        */
        int[] mas = new int[10];
        /*
        1. Cолздал масив командой int[]
        2. Присвоил ему имя mas
        3. Объявил длинну масива командой new int[длинна массива]
        */
        for (int i = 0; i < mas.length; i++) {
            /*
              0. цикл отвечает за набивку масива переменными
              1. Объявил переменную i в теле цикла
            * 2. Ввел условие что i должно выполнятся пока не станет больше длинны МАСИВА mas
            * 3. Каждый раз повтор цикла прибавляет к i по еденице пока не станет равна длинне масива mas
            * 4. Каждый раз когда цикл выдает true запускать цикл. индекс масива  получает данные с ввода.
            */
            mas[i] = scanner.nextInt();
        }
        /* инициализирует методы согластно списка ниже*/
        step1(mas);
        step2(mas);
        step3(mas);
    }

    private static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int element : mas) {
            if (min > element) min = element;
            if (max < element) max = element;
        }
        System.out.printf(min + " " + max);
    }

    private static void step2(int[] mas) {
        /*создаем переменную для среднеорифметического*/
        double avg = 0;
        for (int element : mas) {
            avg = avg + element;

        }
        avg = avg / mas.length;
        for (int element : mas)
            if (element < avg)
                System.out.print(element + " ");
    }

    private static void step3(int[] mas) {
        int min = mas[0];
        for (int element : mas) {
            if (min > element) min = element;
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min)
                System.out.print(i + " ");
        }
    }
}




