package by.it.zhivov.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();

        Scanner scan = new Scanner(System.in);
        int month = scan.nextInt();
        step2(month);

        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        step3(a, b, c);
    }
    static void step1(){
        for(int i = 1; i < 26; i++){
            if(i % 5 != 0){
                System.out.print(i + " ");
            } else {
                System.out.println(i + " ");
            }
        }
    }

    static void step2(int month){
        String result = "";
        switch (month){
            case 1 : result = "январь";
                break;
            case 2 : result = "февраль";
                break;
            case 3 : result = "март";
                break;
            case 4 : result = "апрель";
                break;
            case 5 : result = "май";
                break;
            case 6 : result = "июнь";
                break;
            case 7 : result = "июль";
                break;
            case 8 : result = "август";
                break;
            case 9 : result = "сентябрь";
                break;
            case 10 : result = "октябрь";
                break;
            case 11 : result = "ноябрь";
                break;
            case 12 : result = "декабрь";
                break;
            default: result = "нет такого месяца";
        }
        System.out.println(result);
    }

    static void step3(double a, double b, double c){
        double discr = b * b - 4 * a * c;
        if(discr > 0){
            double x1 = (-b + Math.sqrt(discr)) / (2 * a);
            double x2 = (-b - Math.sqrt(discr)) / (2 * a);
            System.out.println(x1 + " " + x2);
        } else if(discr == 0){
            System.out.println(-(b / (2 * a)));
        } else {
            System.out.println("корней нет");
        }
    }
}
