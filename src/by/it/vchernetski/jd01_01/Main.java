package by.it.vchernetski.jd01_01;

public class Main {

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.printSlogan();
        hello.setSlogan("Привет мир!");
        hello.printSlogan();
        by.it.vchernetski.jd01_01.Args argObj = new Args(args);
        argObj.printArgs();
    }
}
