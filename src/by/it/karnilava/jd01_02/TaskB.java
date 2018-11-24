package by.it.karnilava.jd01_02;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        step2(month);
        System.out.println("Введите параметр 'a'");
        double a = scanner.nextDouble();
        System.out.println("Введите параметр 'b'");
        double b = scanner.nextDouble();
        System.out.println("Введите параметр 'c'");
        double c = scanner.nextDouble();
        step3(a,b,c);

        step1();

    }

    static void step3(double a, double b, double c){
        double D = b*b - 4*a*c;
        if (D==0){
                double x = -b/(2*a);
                System.out.println(x);

            }
            else if (D<0) {
                System.out.println("корней нет");

            }
            else {
                double x1 = (-b+Math.sqrt(D))/(2*a);
            double x2 = (-b-Math.sqrt(D))/(2*a);
            System.out.println(x1+" "+x2);

        }
    }

    static void step1 () {
            for (int i = 1; i <= 25; i++) {
                System.out.print(i + " ");
                if (i % 5 == 0) {
                    System.out.println();
                }
            }

        }

        static void step2(int month){
        switch (month){
                case 1 : {System.out.println("январь");
                break;}
            case 2: {
                System.out.println("февраль");
                break;
            }
            case 3:{
                System.out.println("март");
                break;
            }
            case 4:{
                System.out.println("апрель");
                break;
            }
            case 5:{
                System.out.println("май");
                break;
            }
            case 6:{
                System.out.println("июнь");
                break;
            }
            case 7:{
                System.out.println("июль");
                break;
            }
            case 8:{
                System.out.println("август");
                break;
            }
            case 9:{
                System.out.println("сентябрь");
                break;
            }
            case 10:{
                System.out.println("октябрь");
                break;
            }
            case 11:{
                System.out.println("ноябрь");
                break;
            }
            case 12:{
                System.out.println("декабрь");
                break;
            }
            default:{
                System.out.println("нет такого месяца");
                break;
            }


        }





        }


}