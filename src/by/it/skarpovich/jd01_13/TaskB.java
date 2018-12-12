package by.it.skarpovich.jd01_13;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        double sum = 0;

        while (!(str = sc.nextLine()).equalsIgnoreCase("end")) {    // Воводим элементы с новой строки до ввода end
            try {
                double num = Double.parseDouble(str);                          // Переводим элементы из строки в число
                if (num < 0) {
                    throw new ArithmeticException("Отрицательное число");      // Бросаем ошибку ArithmeticException для отрицательных чисел
                }
                sum = sum + num;                                               // Считаем сумму введнных чисел
                System.out.println(num + " " + Math.sqrt(sum));

            } catch (NumberFormatException | ArithmeticException e) {          // Ловим ошибки
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) { // Провереяем или имя класса в элементе совпадает с именем класса TaskB.
                        String name = e.getClass().getName();
                        String clname = element.getClassName();                 // Получаем название класса
                        int number = element.getLineNumber();                   // Получаем номер строки возникшей ошибки
                        System.out.printf("name: %s\n" + "class: %s\n" + "line: %d\n", name, clname, number);
                        break;
                    }
                }
            }
        }
    }
}
