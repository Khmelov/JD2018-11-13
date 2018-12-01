package by.it.malishevskiy.jd01_03;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double [] array = InOut.getArray(str); // Вызываем метод InOut.getArray(str) и молучаем массив
        InOut.printArray(array);// Печатаем этот массив
        InOut.printArray(array, "V", 3 ); // Печатаем этот массив и вывести в 3 колонки
        double[] masMin = {1, 2, 3};
        double d = Helper.findMin(masMin);
        System.out.println(d);
        double[] masMax = {1, 2, 3};
        double e = Helper.findMax(masMax);
        System.out.println(e);
    }
}
