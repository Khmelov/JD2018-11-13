package by.it._tasks_.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int numbOfEmploy = Integer.parseInt(scanner.nextLine());// Число людей
        String[] nameOfEmploy = new String[numbOfEmploy];

        for (int i = 0; i < nameOfEmploy.length; i++) {
            nameOfEmploy[i] = scanner.nextLine(); /*вводив фамилию в индекс масива*/
        }

        String strSalary;
        int masSalary[];
        int salaryArr[][] = new int[numbOfEmploy][4];
        for (int i = 0; i < nameOfEmploy.length; i++) {
            System.out.println("Введите зарплату для: " + nameOfEmploy[i]);
            strSalary = scanner.nextLine();
            masSalary = InOut.getArrayInt(strSalary);/*one person*/
            for (int j = 0; j < masSalary.length; j++) {
                salaryArr[i][j] = masSalary[j];
            }
        }

        System.out.printf("%s%n", "------------------------------------------------------------");
        System.out.printf("%-11s%-11s%-11s%-11s%-11s%-11s%n", "ФАМИЛИЯ", "КВАРТАЛ-1", "КВАРТАЛ-2", "КВАРТАЛ-3", "КВАРТАЛ-4", "ИТОГО");
        int counterSum = 0;
        int common = 0;
        int[] avgq = new int[4];
        for (int i = 0; i < nameOfEmploy.length; i++) {
            System.out.printf("%-11s", nameOfEmploy[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-11d", salaryArr[i][j]);

                counterSum += salaryArr[i][j];
                avgq[j] += salaryArr[i][j];

            }
            System.out.printf("%-11d%n", counterSum);
            common += counterSum;
            counterSum = 0;

        }
        System.out.println("Итого " + common);
        int avgClumn = 0;
        float[] bred = new float[4];

        for (int i = 0; i < avgq.length; i++) {

            bred[i] = avgq[i] / numbOfEmploy; //делим сумму за квартал на кол-во работников введенных через сканер.

        }
        for (int i = 0; i < bred.length; i++) {
            avgClumn += bred[i];
        }

        float coficion = avgq.length;
        float avg = common / coficion;
        System.out.printf("%-10s%-3.7f%n", "Средняя ", avg/numbOfEmploy);
    }
}

