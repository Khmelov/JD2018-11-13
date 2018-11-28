package by.it.lobkova.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        final int ARR_LENGTH = 4;
        int num = scanInputNum();
        String[] fam = scanInputFam(num);
        int[][] salary = getSalary(num, fam);
        result(num, fam, salary);
    }


    static void result(int num, String[] fam, int[][] salary){
        final int ARR_LENGTH = 4;
        int[] total = new int[num];
        System.out.printf("%1$s%1$s%1$s%1$s%1$s%1$s\n", "----------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        for (int i = 0; i < num; i++) {
            System.out.printf("%8s: ", fam[i]);
            for (int j = 0; j < ARR_LENGTH; j++) {
                System.out.printf("%-10d", salary[i][j]);
                total[i] += salary[i][j];
            }
            System.out.printf("%-10d\n", total[i]);
        }
        System.out.printf("%1$s%1$s%1$s%1$s%1$s%1$s\n", "----------");
        int totalAllEmployee = 0;
        for (int i = 0; i < num; i++) {
            totalAllEmployee += total[i];
        }
        System.out.printf("%-8s  %-10d\n", "Итого", totalAllEmployee);
        System.out.printf("%-8s  %-9.6f\n", "Средняя", (double) totalAllEmployee / (num * ARR_LENGTH));
    }

    private static int scanInputNum(){
        System.out.println("Введите число людей: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        return num;
    }

    private static String[] scanInputFam(int num){
        System.out.println("Введите фамилии " + num + " людей " );
        Scanner scanner = new Scanner(System.in);
        String[] fam = new String[num];

        for (int i = 0; i < fam.length; i++) {
            fam[i] = scanner.nextLine();
        }
        return fam;
    }

    private static int[][] getSalary(int num, String[] fam){
        Scanner sc = new Scanner(System.in);
        final int ARR_LENGTH = 4;
        int[][] salary = new int[num][ARR_LENGTH];

        for (int i = 0; i < num; i++) {
            System.out.println("Введите зарплату для " + fam[i]);
            for (int j = 0; j < ARR_LENGTH; j++) {
                salary[i][j] = sc.nextInt();
            }
        }
        return salary;
    }


}
