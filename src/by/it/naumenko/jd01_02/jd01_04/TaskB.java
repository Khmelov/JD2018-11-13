package by.it.naumenko.jd01_02.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kolPiple = sc.nextInt();
        String[] lastName = new String[kolPiple];
        for (int i = 0; i < lastName.length; i++) {
            lastName[i] = sc.next();
        }
        int[][] zarPlata = new int[kolPiple][4];
        for (int i = 0; i < zarPlata.length; i++) {
            for (int j = 0; j < zarPlata[i].length; j++) {
                System.out.println("Введите зарплату для " + lastName[i]);
                zarPlata[i][j] = sc.nextInt();
            }
        }

        int[] sum = new int[kolPiple];
        int itogo = 0;
        for (int i = 0; i < zarPlata.length; i++) {
            for (int j = 0; j < zarPlata[i].length; j++) {
                sum[i] += zarPlata[i][j];
                itogo += zarPlata[i][j];
            }
        }

        int[] sumStb = new int[4];
        for (int i = 0; i < zarPlata.length; i++) {
            for (int j = 0; j < sumStb.length; j++) {
                sumStb[j] += zarPlata[i][j];
            }
        }
        double itogo2 = 0.0;
        for (int i = 0; i < sumStb.length; i++) {
            itogo2 = itogo2 + sumStb[i] / 3.0;
        }

        double srZnach = itogo2 / 4;

        System.out.println("----------------------------------------------------");
        System.out.printf("%8s %-8s %-8s %-8s %-8s %-5s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < lastName.length; i++) {
            System.out.printf("%8s: %-8d %-8d %-8d %-8d %-5d\n", lastName[i], zarPlata[i][0], zarPlata[i][1], zarPlata[i][2], zarPlata[i][3], sum[i]);
        }
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-8s %-8d\n", "Итого", itogo);
        System.out.printf("%-8s %-8.5f\n", "Средняя", srZnach);
    }
}





//через методы, ысе работает, но тест не проходит???
/*
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kolPiple = sc.nextInt();
        String[] lastName = new String[kolPiple];
        for (int i = 0; i < lastName.length; i++) {
            lastName[i] = sc.next();
        }
        //ввод данных по зарплате
        int[][] zarPlata;
        zarPlata=inputZP(kolPiple,lastName);

        int[] sum = new int[kolPiple];
        int itogo = 0;
        for (int i = 0; i < zarPlata.length; i++) {
            for (int j = 0; j < zarPlata[i].length; j++) {
                sum[i] += zarPlata[i][j];
                itogo += zarPlata[i][j];
            }
        }
        //поквартальная сумма
        int[] sumStb = new int[4];
        sumStb = summaKvartal(zarPlata);

        double srZnach = sumSrKvartal(sumStb) / 4;//Средняя поквартальная ЗП
        printTable(lastName, zarPlata, sum);//вывод таблицы с фаммилией и зарплатой по кварталу
        printInfoZp(itogo, srZnach);//вывод информации о суме ЗП и средней поквартальной ЗП
    }

    private static int[][] inputZP(int kolPiple, String[] lastName) {
        Scanner sc=new Scanner(System.in);
        int[][] zarPlata = new int[kolPiple][4];
        for (int i = 0; i < zarPlata.length; i++) {
            for (int j = 0; j < zarPlata[i].length; j++) {
                System.out.println("Введите зарплату для " + lastName[i]);
                zarPlata[i][j] = sc.nextInt();
            }
        }
        return zarPlata;
    }

    // сумма средних поквартальных зармлат л
    private static double sumSrKvartal(int[] sumStb) {
        double sr = 0.0;
        for (int i = 0; i < sumStb.length; i++) {
            sr = sr + sumStb[i] / 3.0;
        }
        return sr;
    }

    private static int[] summaKvartal(int[][] zarPlata) {
        int[] sumStb = new int[4];
        for (int i = 0; i < zarPlata.length; i++) {
            for (int j = 0; j < sumStb.length; j++) {
                sumStb[j] += zarPlata[i][j];
            }
        }
        return sumStb;
    }

    private static void printInfoZp(int itogo, double srZnach) {
        System.out.printf("%-8s %-8d\n", "Итого", itogo);
        System.out.printf("%-8s %-8.5f\n", "Средняя", srZnach);
    }

    private static void printTable(String[] lastName, int[][] zarPlata, int[] sum) {
        System.out.println("----------------------------------------------------");
        System.out.printf("%8s %-8s %-8s %-8s %-8s %-5s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < lastName.length; i++) {
            System.out.printf("%8s: %-8d %-8d %-8d %-8d %-5d\n", lastName[i], zarPlata[i][0], zarPlata[i][1], zarPlata[i][2], zarPlata[i][3], sum[i]);
        }
        System.out.println("-----------------------------------------------------");
    }


}

 */






