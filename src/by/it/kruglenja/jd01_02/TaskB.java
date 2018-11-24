package by.it.kruglenja.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();
        Scanner scanner = new Scanner(System.in);
        step2(scanner.nextInt());
        step3(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

    }
    private static void step1(){

        int num = 1;
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                arr[i][j] = num;
                num++;
                System.out.printf("% -3d",arr[i][j]);
            }
            System.out.println();
        }
    }

    private static void step2(int month){
        switch (month) {
            case 1:
                System.out.println("январь");break;
            case 2:
                System.out.println("февраль");break;
            case 3:
                System.out.println("март");break;
            case 4:
                System.out.println("апрель");break;
            case 5:
                System.out.println("май");break;
            case 6:
                System.out.println("июнь");break;
            case 7:
                System.out.println("июль");break;
            case 8:
                System.out.println("август");break;
            case 9:
                System.out.println("сентябрь");break;
            case 10:
                System.out.println("октябрь");break;
            case 11:
                System.out.println("ноябрь");break;
            case 12:
                System.out.println("декабрь");break;
            default:
                System.out.println("нет такого месяца");
        }
    }

    private static void step3(double a, double b, double c){
        double root1;
        double root2;

        if (a != 0 && b != 0){
            double d = Math.pow(b, 2) - (4 * a * c);
            if (d > 0) {
                root1 = (-b + Math.sqrt(d)) / (2 * a);
                root2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println(root1 + " " + root2);
            }else if (d == 0){
                root1 = -b / (2 * a);
                System.out.println(root1);
            }else {
                System.out.println("корней нет");
            }
        }
    }
}