package by.it.akhmelev.jd01_01;

import static java.lang.Thread.sleep;

public class Test0xC0000005 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            sleep(100);
            System.out.println("Hello world!");
        }
    }
}
