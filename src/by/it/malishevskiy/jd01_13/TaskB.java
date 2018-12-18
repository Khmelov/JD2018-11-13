package by.it.malishevskiy.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        double sum = 0;

        while (!(string = scanner.nextLine()).equalsIgnoreCase("end")) {// Воводим элементы с новой строки до ввода end
            try {
                double num = Double.parseDouble(string);// Переводим элементы из строки в число
                if (num < 0) {
                    throw new ArithmeticException("Отрицательное число");// Бросаем ошибку ArithmeticException для отрицательных чисел
                }
                sum = sum + num;
                System.out.println(num + " " + Math.sqrt(sum));

            } catch (NumberFormatException | ArithmeticException e) {// Ловим ошибки
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        String name = e.getClass().getName();
                        String classname = element.getClassName();// Получаем название класса
                        int number = element.getLineNumber();// Получаем номер строки возникшей ошибки
                        System.out.printf("name: %s\n" + "class: %s\n" + "line: %d\n", name, classname, number);
                        break;
                    }
                }
            }
        }
    }
}
