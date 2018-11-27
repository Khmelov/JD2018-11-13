package by.it.zakharenko.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();

        Scanner scanner=new Scanner(System.in);
        int month=scanner.nextInt();
        step2(month);

        double a=scanner.nextDouble();
        double b=scanner.nextDouble();
        double c=scanner.nextDouble();
        step3(a, b, c);
    }
    private static void step1(){
        for (int i = 1; i <=25 ; i++) {
            System.out.print(i + " ");
            if (i%5==0) System.out.println();
        }

    }
    private static void step2(int month) {
        switch (month) {
            case 1: System.out.println("январь"); break;
            case 2: System.out.println("февраль"); break;
            case 3: System.out.println("март"); break;
            case 4: System.out.println("апрель"); break;
            case 5: System.out.println("май"); break;
            case 6: System.out.println("июнь"); break;
            case 7: System.out.println("июль"); break;
            case 8: System.out.println("август"); break;
            case 9: System.out.println("сентябрь"); break;
            case 10: System.out.println("октябрь"); break;
            case 11: System.out.println("ноябрь"); break;
            case 12: System.out.println("декабрь"); break;
            default: System.out.println("нет такого месяца");
        }

    }
    private static void step3(double a, double b, double c) {
        double dis=b*b-4*a*c;
        if (dis<0)
            System.out.println("корней нет");
        else if (dis==0) {
            double x=-b/(2*a);
            System.out.println(x);
        } else {
            double x1=(-b+Math.sqrt(dis))/(2*a);
            double x2=(-b-Math.sqrt(dis))/(2*a);
            System.out.println(x1+" "+x2);
        }
    }
}
