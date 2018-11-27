package by.it.skarpovich.jd01_04;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество работников n:");
        int n = scanner.nextInt();//Вводим количество человек с клавиатуры
        scanner.nextLine();

        System.out.println("Введите фамилии " + n + " работников:");
        String[] surnameArray = new String[n]; //создаем массив Фамилий в количестве n.
        for (int i = 0; i < n; i++) {
            surnameArray[i] = scanner.nextLine(); //Заполняем массив с клавиатуры
        }

        final int quarters = 4;
        int[][] salary = new int[n][quarters];

        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплаты для " + surnameArray[i]);
            for (int j = 0; j < quarters; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }


//     int n = 3;
//        String[] surnameArray = {"Ленин", "Сталин", "Брежнев" };
//        int[][] salary = {{2, 43, 1, 2}, {2, 110, 26, 7}, {15, 15, 66, 22}};
//        final int quarters = 4;


        int[] total = new int[n];
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");

        for (int i = 0; i < n; i++) {
            System.out.printf("%8s: ", surnameArray[i]);

            for (int j = 0; j < quarters; j++) {
                System.out.printf("%-10d", salary[i][j]);
                total[i] += salary[i][j];
            }
            System.out.printf("%-10d\n", total[i]);
        }

        System.out.println("-------------------------------------------------------");
        int totalAll = 0;
        for (int i = 0; i < n; i++) {
            totalAll += total[i];
        }
        System.out.printf("%-10s%-10d\n", "Итого", totalAll);
        System.out.printf("%-10s%-9.6f", "Итого", (double) totalAll / (n * quarters));
    }
}

//String[] line = new String[n];
//          line[i] = scanner.nextLine();
//            line[i] = line[i].trim();
//            String[] stringArray2 = line[i].split(" ");
//            int[] arr = new int[stringArray2.length];
//
//            for (int j = 0; j
//
//                    < stringArray2.length; j++) {
//                arr[j] = Integer.parseInt(stringArray2[j]);
//                arr2[i][j] = arr[j];





