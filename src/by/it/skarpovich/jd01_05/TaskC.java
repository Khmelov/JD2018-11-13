package by.it.skarpovich.jd01_05;

import java.util.Random;

class TaskC {

    public static void main(String[] args) {

        final int min1 = 20;
        final int max1 = 40;
        genLength(min1, max1);
        //printLength(n);
        //printLength(int n);
        // printLength(n);
//        System.out.println(n);
//        System.out.println(n); //Как можно вызвать вывод из main?
    }
    static int genLength(int min, int max) {
        int n = 0;
        Random random = new Random();
        n = min + random.nextInt(max + 1);
        System.out.println(n);
        return n;
    }
    static void printLength(int n) {
        System.out.println(n); //тут разобрался, работает.
    }
}