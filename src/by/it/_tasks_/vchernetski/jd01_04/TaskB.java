package by.it._tasks_.vchernetski.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        double averagesalary=0;
        Scanner sc = new Scanner (System.in);
        int n =sc.nextInt();
        int []sumsalary=new int[n];
        int sum=0;
        String[] fams = new String[n];
        for (int i = 0; i <fams.length ; i++) {
            fams[i]=sc.next();
        }
        int[][] salary=new int[n][5];
        for (int i = 0; i <n ; i++) {
            System.out.println("Введите зарплату для "+fams[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < 4; j++) {
                salary[i][4]+=salary[i][j];
            }
            sumsalary[i]+=salary[i][4];
        }
        for (int i = 0; i <n; i++) {
            sum+=sumsalary[i];
        }
        averagesalary=((double)sum)/((double)n*4);
        System.out.println(averagesalary);
        System.out.println("-----------------------------------------------");
        System.out.println("\tФамилия  "+ "Квартал1  "+"Квартал2   "+ "Квартал3 "+"Квартал4  "+"Итого");
        for (int i = 0; i <n ; i++) {
            System.out.printf("%10s:",fams[i]);
            for (int j = 0; j <5 ; j++) {
                System.out.printf("%9d",salary[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------");
        System.out.printf("%-10s %3d%n","Итого",sum);
        System.out.printf("%-10s %4.4f","Средняя",averagesalary);
    }
}
