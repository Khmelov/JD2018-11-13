package by.it.burlakov.jd01_01;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        System.out.println("i = " + i);
        Hello hello = new Hello();
        hello.setSlogan("HI JAVA");
        hello.print();
    }
}
